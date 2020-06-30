package jp.mufg.kdbjdbc;

import jp.mufg.sql.SqlParser;
import jp.mufg.sql.SqlParser.ColumnNameContext;
import jp.mufg.sql.SqlParser.ExprContext;
import jp.mufg.sql.SqlParser.LimitContext;
import jp.mufg.sql.SqlParser.SelectStmtContext;

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
        while(true) {
            if(i > 0)
                s.append(", ");
            ColumnNameContext c = stmt.columnNames().columnName(i);
            if(c == null)
                break;
            s.append(c.expr().val.toQscript());
            i++;
        }
        return s.toString();
    }
}