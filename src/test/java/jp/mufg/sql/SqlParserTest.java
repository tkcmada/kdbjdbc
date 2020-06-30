package jp.mufg.sql;

import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import org.antlr.v4.runtime.*;
import org.junit.Test;

public class SqlParserTest {
    private void parse(String sql) throws IOException {
        CharStream cs = new ANTLRInputStream(new StringReader((sql + "$").replace('\'', '"').replace(" as ", " AS ")));
        SqlLexer lexer = new SqlLexer(cs);        
        lexer.removeErrorListeners();
        lexer.addErrorListener(new LexerErrorListener());
		TokenStream tokens = new CommonTokenStream(lexer);
        SqlParser parser = new SqlParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        parser.selectStmt();
		int errors = parser.getNumberOfSyntaxErrors();
		if (errors > 0)
            throw new RuntimeException("parse error");
    }

    @Test
    public void test_select_stmt1() throws IOException {
        parse("SELECT 't2'.'id' AS 'id' , 't2'.'name' as 'name' FROM 'public'.'t2' 't2' LIMIT 1000");
    }

    @Test
    public void test_select_stmt2() throws IOException {
        parse("SELECT 't2'.'bl' AS 'bl' , 't2'.'c' AS 'c', SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1, 2");
    }

    @Test
    public void test_select_stmt3() throws IOException {
        parse("SELECT 't2'.'bl' AS 'bl' , SUM('t2'.'bt') AS 'sum:bt:ok' FROM 'public'.'t2' 't2' GROUP BY 1");
    }

}