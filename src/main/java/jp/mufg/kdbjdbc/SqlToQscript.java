package jp.mufg.kdbjdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jp.mufg.sql.SqlLexer;
import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.ColumnNameContext;
import jp.mufg.sql.SqlParser.ExprContext;
import jp.mufg.sql.SqlParser.LimitContext;
import jp.mufg.sql.SqlParser.SelectStmtContext;
import jp.mufg.sqlutil.SqlExprs.ColumnExprWithAlias;
import jp.mufg.sqlutil.SqlExprs.Expr;
import jp.mufg.sqlutil.SqlExprs.NumberExpr;
import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import jp.mufg.kdbjdbc.SqlToQscript;
import jp.mufg.slf4j.FileLogger;

import org.antlr.v4.runtime.*;

public class SqlToQscript {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(SqlToQscript.class);

    private final SelectStmtContext stmt;

    public SqlToQscript(SelectStmtContext selectStmt) {
        this.stmt = selectStmt;
    }

    public SqlToQscript(String sql) {
        logger.info("original sql:>>>" + sql + "<<<");
        try {
            CharStream cs = new ANTLRInputStream(new StringReader((sql + "$").replace(" as ", " AS ")));
            SqlLexer lexer = new SqlLexer(cs);        
            lexer.removeErrorListeners();
            lexer.addErrorListener(new LexerErrorListener());
            TokenStream tokens = new CommonTokenStream(lexer);
            SqlParser parser = new SqlParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(ThrowingErrorListener.INSTANCE);
            this.stmt = parser.selectStmt();
            int errors = parser.getNumberOfSyntaxErrors();
            if (errors > 0)
                throw new IOException("parse error");
            // logger.info("parsed result:>>>" + stmt.toString() + "<<<");
            // logger.info("parsed result tree:" + stmt.toStringTree());
        } catch(Exception ex) {
            throw new IllegalArgumentException("SQL parse error:" + sql, ex);
        }
    }

    // public String getTableName() {
    //     return stmt.table().tbl.getTableName();
    // }

    public String getColumnAliasName(int i_starting_1) {
        return stmt.columnNames().columns.get(i_starting_1-1).getAliasName();
    }

    public boolean isOnlyGroupByColumn() {
        return stmt.groupBy() != null && stmt.groupBy().args().val.getExprs().size() == stmt.columnNames().columns.size();
    }

    public String toQscript() {
        StringBuilder s = new StringBuilder();

        //groupby
        Boolean[] excludedColumn = new Boolean[stmt.columnNames().columns.size()];
        StringBuilder gs = new StringBuilder();
        if(stmt.groupBy() != null) {
            gs.append(" by ");
            int gi = 0;
            for(Expr _expr : stmt.groupBy().args().val.getExprs()) {
                if(gi > 0)
                    gs.append(", ");
                Expr expr = _expr;
                if(expr instanceof NumberExpr) {
                    int colnum = ((NumberExpr)expr).intValue();
                    expr = stmt.columnNames().columns.get(colnum - 1).expr;
                    if(isOnlyGroupByColumn()) {
                        excludedColumn[colnum - 1] = Boolean.FALSE;
                    }
                    else {
                        excludedColumn[colnum - 1] = Boolean.TRUE;
                    }
                    gs.append(stmt.columnNames().columns.get(colnum - 1).getAliasName().replace(":", "__"));
                    gs.append(":");
                    gs.append(expr.toQscript());
                }
                else
                {
                    throw new UnsupportedOperationException();
                }
                gi++;
            }
        }

        if(stmt.limit() != null) {
            s.append(stmt.limit().NUMBER().toString() + "#");
        }
        s.append("select ");
        int i = 0;
        boolean coloutput = false;
        for(ColumnExprWithAlias c : stmt.columnNames().columns) {
            if(excludedColumn[i] == null || excludedColumn[i] == Boolean.FALSE) {
                if(coloutput)
                    s.append(", ");
                String aliasname = c.getAliasName();
                if(excludedColumn[i] == Boolean.FALSE)
                    aliasname = "dummy_" + aliasname;
                s.append(aliasname.replace(":", "__"));
                s.append(":");
                s.append(c.expr.toQscript());
                coloutput = true;
            }
            i++;
        }
        if(gs.length() > 0)
            s.append(gs.toString());
        s.append(" from ");
        s.append(stmt.table().tbl.getTableName());
        //ignore alias name
        //HAVING is ignored
        return s.toString();
    }
}