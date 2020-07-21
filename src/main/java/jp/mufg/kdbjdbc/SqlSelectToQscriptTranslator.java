package jp.mufg.kdbjdbc;

import jp.mufg.sql.SqlLexer;
import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.SelectStmtContext;
import jp.mufg.kdbjdbc.SqlExprs.*;

import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import jp.mufg.kdbjdbc.SqlSelectToQscriptTranslator;

import org.antlr.v4.runtime.*;
import org.slf4j.LoggerFactory;

public class SqlSelectToQscriptTranslator {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SqlSelectToQscriptTranslator.class);

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
            SelectStmtContext stmtcontext = parser.selectStmtWhole().selectStmt();
            this.stmt = stmtcontext.val;
            int errors = parser.getNumberOfSyntaxErrors();
            if (errors > 0)
                throw new IOException("parse error");
            // logger.info("parsed result tree:" + stmtcontext.toStringTree());
            logger.info("parsed result>>>" + stmt.toString() + "<<<");
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