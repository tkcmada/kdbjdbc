// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SqlListener extends ParseTreeListener {
	void enterHaving(SqlParser.HavingContext ctx);
	void exitHaving(SqlParser.HavingContext ctx);

	void enterNumberExpr(SqlParser.NumberExprContext ctx);
	void exitNumberExpr(SqlParser.NumberExprContext ctx);

	void enterGroupBy(SqlParser.GroupByContext ctx);
	void exitGroupBy(SqlParser.GroupByContext ctx);

	void enterSelectStmt(SqlParser.SelectStmtContext ctx);
	void exitSelectStmt(SqlParser.SelectStmtContext ctx);

	void enterTableName(SqlParser.TableNameContext ctx);
	void exitTableName(SqlParser.TableNameContext ctx);

	void enterFunctionExpr(SqlParser.FunctionExprContext ctx);
	void exitFunctionExpr(SqlParser.FunctionExprContext ctx);

	void enterArgs(SqlParser.ArgsContext ctx);
	void exitArgs(SqlParser.ArgsContext ctx);

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

	void enterExpr(SqlParser.ExprContext ctx);
	void exitExpr(SqlParser.ExprContext ctx);

	void enterColumnName(SqlParser.ColumnNameContext ctx);
	void exitColumnName(SqlParser.ColumnNameContext ctx);
}