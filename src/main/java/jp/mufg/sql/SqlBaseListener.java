// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
//this is header


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class SqlBaseListener implements SqlListener {
	@Override public void enterColumnNames(SqlParser.ColumnNamesContext ctx) { }
	@Override public void exitColumnNames(SqlParser.ColumnNamesContext ctx) { }

	@Override public void enterSelectStmt(SqlParser.SelectStmtContext ctx) { }
	@Override public void exitSelectStmt(SqlParser.SelectStmtContext ctx) { }

	@Override public void enterTableName(SqlParser.TableNameContext ctx) { }
	@Override public void exitTableName(SqlParser.TableNameContext ctx) { }

	@Override public void enterColumnName(SqlParser.ColumnNameContext ctx) { }
	@Override public void exitColumnName(SqlParser.ColumnNameContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}