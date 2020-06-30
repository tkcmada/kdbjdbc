package jp.mufg.sql;

import java.io.IOException;
import java.io.StringReader;
import jp.mufg.antlrutil.*;
import org.antlr.v4.runtime.*;
import org.junit.Test;

public class SqlParserTest {
    @Test
    public void test_select_stmt() throws IOException {
        CharStream cs = new ANTLRInputStream(new StringReader("SELECT 't2'.'id' AS 'id' , 't2'.'name' AS 'name' FROM 'public'.'t2' 't2' LIMIT 1000$".replace('\'', '"')));
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
}