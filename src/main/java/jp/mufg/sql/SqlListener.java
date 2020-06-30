// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
//this is header

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SqlListener extends ParseTreeListener {
	void enterColumnNames(SqlParser.ColumnNamesContext ctx);
	void exitColumnNames(SqlParser.ColumnNamesContext ctx);

	void enterSelectStmt(SqlParser.SelectStmtContext ctx);
	void exitSelectStmt(SqlParser.SelectStmtContext ctx);

	void enterTableName(SqlParser.TableNameContext ctx);
	void exitTableName(SqlParser.TableNameContext ctx);

	void enterColumnName(SqlParser.ColumnNameContext ctx);
	void exitColumnName(SqlParser.ColumnNameContext ctx);
}