package jp.mufg.kdbjdbc;
import java.util.HashSet;

import jp.mufg.sql.SqlLexer;
import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.SelectStmtContext;
import jp.mufg.sqlutil.SqlExprs.Arguments;
import jp.mufg.sqlutil.SqlExprs.ColumnExprWithAlias;
import jp.mufg.sqlutil.SqlExprs.EqExpr;
import jp.mufg.sqlutil.SqlExprs.Expr;
import jp.mufg.sqlutil.SqlExprs.SelectStatement;
import jp.mufg.sqlutil.SqlExprs.TypeContext;

import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;
import jp.mufg.slf4j.FileLogger;

import org.antlr.v4.runtime.*;

public class SqlSelectToQscriptTranslator {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(SqlSelectToQscriptTranslator.class);

    private final SelectStatement stmt;

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
            this.stmt = parser.selectStmtWhole().selectStmt().val;
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
        stmt.checkType(ctxt);
    }

    public String toQscript() {
        return stmt.toQscript();
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