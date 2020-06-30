package jp.mufg.sql;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.*;
import org.junit.Test;

public class SqlParserTest {
    @Test
    public void test_select_stmt() throws IOException {
		CharStream cs = new ANTLRInputStream(new StringReader("SELECT t2"));
		SqlLexer lexer = new SqlLexer(cs);
		TokenStream tokens = new CommonTokenStream(lexer);
		SqlParser parser = new SqlParser(tokens);
		parser.selectStmt();
		int errors = parser.getNumberOfSyntaxErrors();
		if (errors > 0)
            throw new RuntimeException("parse error");
    }
}