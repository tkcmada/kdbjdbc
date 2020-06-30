package jp.mufg.sql;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;

public class SqlParserTest {
    @Test
    public void test1() throws RecognitionException {
		CharStream cs = new ANTLRStringStream("Hello,World");
		SqlLexer lexer = new SqlLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		SqlParser parser = new SqlParser(tokens);
		parser.greet();
		int errors = parser.getNumberOfSyntaxErrors();
		if (errors > 0) {
			System.out.println("ERROR!");
		} else {
			System.out.println("SUCCESS!");			
		}
    }

    @Test
    public void test_select_stmt() throws RecognitionException {
		CharStream cs = new ANTLRStringStream("SELECT FROM \"t2\" LIMIT 1000");
		SqlLexer lexer = new SqlLexer(cs);
		CommonTokenStream tokens = new CommonTokenStream();
		tokens.setTokenSource(lexer);
		SqlParser parser = new SqlParser(tokens);
		parser.greet();
		int errors = parser.getNumberOfSyntaxErrors();
		if (errors > 0) {
			System.out.println("ERROR!");
		} else {
			System.out.println("SUCCESS!");			
		}
    }
}