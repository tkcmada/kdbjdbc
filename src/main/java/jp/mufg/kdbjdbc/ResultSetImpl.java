package jp.mufg.kdbjdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class ResultSetImpl extends ResultSetBase {
	private static final Logger logger = FileLogger.getLogger(ResultSetImpl.class);
	private final List<Object[]> rows;
    private int cursor = -1;

	public ResultSetImpl(ResultSetMetaData meta, List<Object[]> rows) throws SQLException {
		super(meta);
		this.rows = rows;
	}

	public ResultSetImpl(ResultSetMetaData meta) throws SQLException {
		super(meta);
		this.rows = new LinkedList<Object[]>();
	}

	@Override
	public final boolean next() throws SQLException {
        // logger.info("next cursor=" + cursor + " size=" + rows.size());
		if(cursor >= rows.size())
			return false;
		cursor++;
		return cursor < rows.size();
	}

	@Override
	public final void close() throws SQLException {
		//do nothing
	}

	@Override
	public final Object getObjectImpl(int columnIndex) throws SQLException {
        Object val = rows.get(cursor)[columnIndex-1];
        return val;
	}
}
