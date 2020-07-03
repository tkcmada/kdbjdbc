// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class SqlBaseListener implements SqlListener {
	@Override public void enterNumberExpr(SqlParser.NumberExprContext ctx) { }
	@Override public void exitNumberExpr(SqlParser.NumberExprContext ctx) { }

	@Override public void enterGroupBy(SqlParser.GroupByContext ctx) { }
	@Override public void exitGroupBy(SqlParser.GroupByContext ctx) { }

	@Override public void enterPint(SqlParser.PintContext ctx) { }
	@Override public void exitPint(SqlParser.PintContext ctx) { }

	@Override public void enterFunctionExpr(SqlParser.FunctionExprContext ctx) { }
	@Override public void exitFunctionExpr(SqlParser.FunctionExprContext ctx) { }

	@Override public void enterStringExpr(SqlParser.StringExprContext ctx) { }
	@Override public void exitStringExpr(SqlParser.StringExprContext ctx) { }

	@Override public void enterColumnExpr(SqlParser.ColumnExprContext ctx) { }
	@Override public void exitColumnExpr(SqlParser.ColumnExprContext ctx) { }

	@Override public void enterColumnNames(SqlParser.ColumnNamesContext ctx) { }
	@Override public void exitColumnNames(SqlParser.ColumnNamesContext ctx) { }

	@Override public void enterPrimaryExpr(SqlParser.PrimaryExprContext ctx) { }
	@Override public void exitPrimaryExpr(SqlParser.PrimaryExprContext ctx) { }

	@Override public void enterCompExpr(SqlParser.CompExprContext ctx) { }
	@Override public void exitCompExpr(SqlParser.CompExprContext ctx) { }

	@Override public void enterLimit(SqlParser.LimitContext ctx) { }
	@Override public void exitLimit(SqlParser.LimitContext ctx) { }

	@Override public void enterWhere(SqlParser.WhereContext ctx) { }
	@Override public void exitWhere(SqlParser.WhereContext ctx) { }

	@Override public void enterExpr(SqlParser.ExprContext ctx) { }
	@Override public void exitExpr(SqlParser.ExprContext ctx) { }

	@Override public void enterWhenThenExpr(SqlParser.WhenThenExprContext ctx) { }
	@Override public void exitWhenThenExpr(SqlParser.WhenThenExprContext ctx) { }

	@Override public void enterBooleanLiteral(SqlParser.BooleanLiteralContext ctx) { }
	@Override public void exitBooleanLiteral(SqlParser.BooleanLiteralContext ctx) { }

	@Override public void enterTable(SqlParser.TableContext ctx) { }
	@Override public void exitTable(SqlParser.TableContext ctx) { }

	@Override public void enterHaving(SqlParser.HavingContext ctx) { }
	@Override public void exitHaving(SqlParser.HavingContext ctx) { }

	@Override public void enterOrExpr(SqlParser.OrExprContext ctx) { }
	@Override public void exitOrExpr(SqlParser.OrExprContext ctx) { }

	@Override public void enterSelectStmt(SqlParser.SelectStmtContext ctx) { }
	@Override public void exitSelectStmt(SqlParser.SelectStmtContext ctx) { }

	@Override public void enterArgs(SqlParser.ArgsContext ctx) { }
	@Override public void exitArgs(SqlParser.ArgsContext ctx) { }

	@Override public void enterStr(SqlParser.StrContext ctx) { }
	@Override public void exitStr(SqlParser.StrContext ctx) { }

	@Override public void enterEqExpr(SqlParser.EqExprContext ctx) { }
	@Override public void exitEqExpr(SqlParser.EqExprContext ctx) { }

	@Override public void enterName(SqlParser.NameContext ctx) { }
	@Override public void exitName(SqlParser.NameContext ctx) { }

	@Override public void enterCaseExpr(SqlParser.CaseExprContext ctx) { }
	@Override public void exitCaseExpr(SqlParser.CaseExprContext ctx) { }

	@Override public void enterGroupargs(SqlParser.GroupargsContext ctx) { }
	@Override public void exitGroupargs(SqlParser.GroupargsContext ctx) { }

	@Override public void enterColumnName(SqlParser.ColumnNameContext ctx) { }
	@Override public void exitColumnName(SqlParser.ColumnNameContext ctx) { }

	@Override public void enterAndExpr(SqlParser.AndExprContext ctx) { }
	@Override public void exitAndExpr(SqlParser.AndExprContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	@Override public void visitTerminal(TerminalNode node) { }
	@Override public void visitErrorNode(ErrorNode node) { }
}