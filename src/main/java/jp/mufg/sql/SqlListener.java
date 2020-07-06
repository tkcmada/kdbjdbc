// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SqlListener extends ParseTreeListener {
	void enterNumberExpr(SqlParser.NumberExprContext ctx);
	void exitNumberExpr(SqlParser.NumberExprContext ctx);

	void enterGroupBy(SqlParser.GroupByContext ctx);
	void exitGroupBy(SqlParser.GroupByContext ctx);

	void enterPint(SqlParser.PintContext ctx);
	void exitPint(SqlParser.PintContext ctx);

	void enterFunctionExpr(SqlParser.FunctionExprContext ctx);
	void exitFunctionExpr(SqlParser.FunctionExprContext ctx);

	void enterStringExpr(SqlParser.StringExprContext ctx);
	void exitStringExpr(SqlParser.StringExprContext ctx);

	void enterColumnExpr(SqlParser.ColumnExprContext ctx);
	void exitColumnExpr(SqlParser.ColumnExprContext ctx);

	void enterColumnNames(SqlParser.ColumnNamesContext ctx);
	void exitColumnNames(SqlParser.ColumnNamesContext ctx);

	void enterPrimaryExpr(SqlParser.PrimaryExprContext ctx);
	void exitPrimaryExpr(SqlParser.PrimaryExprContext ctx);

	void enterCompExpr(SqlParser.CompExprContext ctx);
	void exitCompExpr(SqlParser.CompExprContext ctx);

	void enterLimit(SqlParser.LimitContext ctx);
	void exitLimit(SqlParser.LimitContext ctx);

	void enterWhere(SqlParser.WhereContext ctx);
	void exitWhere(SqlParser.WhereContext ctx);

	void enterExpr(SqlParser.ExprContext ctx);
	void exitExpr(SqlParser.ExprContext ctx);

	void enterWhenThenExpr(SqlParser.WhenThenExprContext ctx);
	void exitWhenThenExpr(SqlParser.WhenThenExprContext ctx);

	void enterBooleanLiteral(SqlParser.BooleanLiteralContext ctx);
	void exitBooleanLiteral(SqlParser.BooleanLiteralContext ctx);

	void enterTable(SqlParser.TableContext ctx);
	void exitTable(SqlParser.TableContext ctx);

	void enterSelectStmtWhole(SqlParser.SelectStmtWholeContext ctx);
	void exitSelectStmtWhole(SqlParser.SelectStmtWholeContext ctx);

	void enterHaving(SqlParser.HavingContext ctx);
	void exitHaving(SqlParser.HavingContext ctx);

	void enterOrExpr(SqlParser.OrExprContext ctx);
	void exitOrExpr(SqlParser.OrExprContext ctx);

	void enterSelectStmt(SqlParser.SelectStmtContext ctx);
	void exitSelectStmt(SqlParser.SelectStmtContext ctx);

	void enterArgs(SqlParser.ArgsContext ctx);
	void exitArgs(SqlParser.ArgsContext ctx);

	void enterStr(SqlParser.StrContext ctx);
	void exitStr(SqlParser.StrContext ctx);

	void enterEqExpr(SqlParser.EqExprContext ctx);
	void exitEqExpr(SqlParser.EqExprContext ctx);

	void enterName(SqlParser.NameContext ctx);
	void exitName(SqlParser.NameContext ctx);

	void enterCaseExpr(SqlParser.CaseExprContext ctx);
	void exitCaseExpr(SqlParser.CaseExprContext ctx);

	void enterGroupargs(SqlParser.GroupargsContext ctx);
	void exitGroupargs(SqlParser.GroupargsContext ctx);

	void enterColumnName(SqlParser.ColumnNameContext ctx);
	void exitColumnName(SqlParser.ColumnNameContext ctx);

	void enterAndExpr(SqlParser.AndExprContext ctx);
	void exitAndExpr(SqlParser.AndExprContext ctx);
}