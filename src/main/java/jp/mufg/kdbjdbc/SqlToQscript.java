package jp.mufg.kdbjdbc;

import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.ColumnNameContext;
import jp.mufg.sql.SqlParser.ExprContext;
import jp.mufg.sql.SqlParser.LimitContext;
import jp.mufg.sql.SqlParser.SelectStmtContext;
import jp.mufg.sqlutil.SqlExprs.ColumnExprWithAlias;

public class SqlToQscript {
    private final SelectStmtContext stmt;

    public SqlToQscript(SelectStmtContext selectStmt) {
        this.stmt = selectStmt;
    }

    public String toQscript() {
        StringBuilder s = new StringBuilder();
        if(stmt.limit() != null) {
            s.append(stmt.limit().NUMBER().toString() + "#");
        }
        s.append("select ");
        int i = 0;
        for(ColumnExprWithAlias c : stmt.columnNames().columns) {
            if(i > 0)
                s.append(", ");
            s.append(c.expr.toQscript());
            i++;
        }
        s.append(" from ");
        s.append(stmt.table().tbl.getTableName());
        //ignore alias name
        return s.toString();
    }
}