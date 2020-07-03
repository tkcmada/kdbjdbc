package jp.mufg.kdbjdbc;
import java.util.HashSet;

import jp.mufg.sql.SqlLexer;
import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.SelectStmtContext;
import jp.mufg.sqlutil.SqlExprs.ColumnExprWithAlias;
import jp.mufg.sqlutil.SqlExprs.EqExpr;
import jp.mufg.sqlutil.SqlExprs.Expr;
import jp.mufg.sqlutil.SqlExprs.TypeContext;

import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;
import jp.mufg.slf4j.FileLogger;

import org.antlr.v4.runtime.*;

public class SqlSelectToQscriptTranslator {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(SqlSelectToQscriptTranslator.class);

    private final SelectStmtContext stmt;

    public SqlSelectToQscriptTranslator(String sql) {
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

    public void convertLiteralType(TypeContext ctxt) {
        if(stmt.where() != null) {
            if(stmt.where().val instanceof EqExpr) {
                ((EqExpr) stmt.where().val).checkType(ctxt); //TODO : add checkType to Expr
            }
        }
    }

    // public String getTableName() {
    //     return stmt.table().tbl.getTableName();
    // }

    public String getColumnAliasName(int i_starting_1) {
        return stmt.columnNames().columns.get(i_starting_1-1).getAliasName();
    }

    public boolean isDistinct() {
        if(stmt.groupBy() == null)
            return false;
        HashSet<Integer> colnum = new HashSet<Integer>();
        for(int i = 1; i <= stmt.columnNames().columns.size(); i++)
            colnum.add(i);
        for(Integer colno : stmt.groupBy().groupargs().val) {
            colnum.remove(colno);
        }
        return colnum.size() == 0;
    }

    public String toQscript() {
        StringBuilder s = new StringBuilder();

        final boolean distinct = isDistinct();
        //groupby
        boolean[] excludedColumn = new boolean[stmt.columnNames().columns.size()];
        StringBuilder gs = new StringBuilder();
        if(! distinct && stmt.groupBy() != null) {
            for(Integer colnum : stmt.groupBy().groupargs().val) {
                if(gs.length() > 0)
                    gs.append(", ");
                Expr expr = stmt.columnNames().columns.get(colnum - 1).expr;
                excludedColumn[colnum - 1] = true;
                gs.append(escapeColumnName(stmt.columnNames().columns.get(colnum - 1).getAliasName()));
                gs.append(":");
                gs.append(expr.toQscript());
            }
        }

        if(distinct) {
            s.append("distinct ");
        }
        if(stmt.limit() != null) {
            s.append(stmt.limit().pint().val + "#");
        }
        s.append("select ");
        {
            int i = 0;
            StringBuilder cs = new StringBuilder();
            for(ColumnExprWithAlias c : stmt.columnNames().columns) {
                if(! excludedColumn[i]) {
                    if(cs.length() > 0)
                        cs.append(", ");
                    String aliasname = c.getAliasName();
                    cs.append(escapeColumnName(aliasname));
                    cs.append(":");
                    cs.append(c.expr.toQscript());
                }
                i++;
            }
            s.append(cs.toString());
        }
        if(gs.length() > 0) {
            s.append(" by ");
            s.append(gs.toString());
        }
        s.append(" from ");
        s.append(stmt.table().tbl.getTableName());
        //ignore alias name
        //HAVING is ignored
        if(stmt.where() != null) {
            s.append(" where ");
            s.append(stmt.where().val.toQscript());
        }
        return s.toString();
    }
    //------------------------------------------------
    //helper methods
    //------------------------------------------------
    public static String escapeColumnName(String s) {
        return s.replace(":", "__");
    }

    public static String dequoteColumnName(String s) {
        return s.replace("__", ":");
    }
}