package jp.mufg.logjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Arrays;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogStatement implements Statement {
	private static final Logger logger = FileLogger.getLogger(LogStatement.class);
	private final Statement stmt;

	public LogStatement(Statement stmt) {
		super();
		this.stmt = stmt;
	}

	public final ResultSet executeQuery(String sql) throws SQLException {
		logger.info("executeQuery " + sql);
		return new LogResultSet(stmt.executeQuery(sql));
	}

	public final boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		return stmt.isWrapperFor(iface);
	}

	public final <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		return stmt.unwrap(iface);
	}

	public final int executeUpdate(String sql) throws SQLException {
		logger.info("executeUpdate " + sql);
		return stmt.executeUpdate(sql);
	}

	public final void close() throws SQLException {
		logger.info("close");
		stmt.close();
	}

	public final int getMaxFieldSize() throws SQLException {
		logger.info("getMaxFieldSize");
		return stmt.getMaxFieldSize();
	}

	public final void setMaxFieldSize(int max) throws SQLException {
		logger.info("setMaxFieldSize");
		stmt.setMaxFieldSize(max);
	}

	public final int getMaxRows() throws SQLException {
		logger.info("getMaxRows");
		return stmt.getMaxRows();
	}

	public final void setMaxRows(int max) throws SQLException {
		logger.info("setMaxRows");
		stmt.setMaxRows(max);
	}

	public final void setEscapeProcessing(boolean enable) throws SQLException {
		logger.info("setEscapeProcessing");
		stmt.setEscapeProcessing(enable);
	}

	public final int getQueryTimeout() throws SQLException {
		logger.info("getQueryTimeout");
		return stmt.getQueryTimeout();
	}

	public final void setQueryTimeout(int seconds) throws SQLException {
		logger.info("setQueryTimeout");
		stmt.setQueryTimeout(seconds);
	}

	public final void cancel() throws SQLException {
		logger.info("cancel");
		stmt.cancel();
	}

	public final SQLWarning getWarnings() throws SQLException {
		logger.info("getWarnings");
		return stmt.getWarnings();
	}

	public final void clearWarnings() throws SQLException {
		logger.info("clearWarnings");
		stmt.clearWarnings();
	}

	public final void setCursorName(String name) throws SQLException {
		logger.info("setCursorName");
		stmt.setCursorName(name);
	}

	public final boolean execute(String sql) throws SQLException {
		logger.info("execute >>>" + sql + "<<<");
        boolean result = stmt.execute(sql);
		logger.info("result:" + result);
        return result;
	}

	public final ResultSet getResultSet() throws SQLException {
		logger.info("getResultSet");
		return new LogResultSet(stmt.getResultSet());
	}

	public final int getUpdateCount() throws SQLException {
		logger.info("getUpdateCount");
		return stmt.getUpdateCount();
	}

	public final boolean getMoreResults() throws SQLException {
		logger.info("getMoreResults");
		return stmt.getMoreResults();
	}

	public final void setFetchDirection(int direction) throws SQLException {
		logger.info("setFetchDirection");
		stmt.setFetchDirection(direction);
	}

	public final int getFetchDirection() throws SQLException {
		logger.info("getFetchDirection");
		return stmt.getFetchDirection();
	}

	public final void setFetchSize(int rows) throws SQLException {
		logger.info("setFetchSize");
		stmt.setFetchSize(rows);
	}

	public final int getFetchSize() throws SQLException {
		logger.info("getFetchSize");
		return stmt.getFetchSize();
	}

	public final int getResultSetConcurrency() throws SQLException {
		logger.info("getResultSetConcurrency");
		return stmt.getResultSetConcurrency();
	}

	public final int getResultSetType() throws SQLException {
		logger.info("getResultSetType");
        return stmt.getResultSetType();
	}

	public final void addBatch(String sql) throws SQLException {
		logger.info("addBatch " + sql);
		stmt.addBatch(sql);
	}

	public final void clearBatch() throws SQLException {
		logger.info("clearBatch");
		stmt.clearBatch();
	}

	public final int[] executeBatch() throws SQLException {
		logger.info("executeBatch");
		return stmt.executeBatch();
	}

	public final Connection getConnection() throws SQLException {
		logger.info("getConnection");
		return stmt.getConnection();
	}

	public final boolean getMoreResults(int current) throws SQLException {
		logger.info("getMoreResults");
		return stmt.getMoreResults(current);
	}

	public final ResultSet getGeneratedKeys() throws SQLException {
		logger.info("getGeneratedKeys");
		return new LogResultSet(stmt.getGeneratedKeys());
	}

	public final int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		logger.info("executeUpdate " + sql + " " + autoGeneratedKeys);
		return stmt.executeUpdate(sql, autoGeneratedKeys);
	}

	public final int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
		logger.info("executeUpdate " + sql + " " + Arrays.toString(columnIndexes));
		return stmt.executeUpdate(sql, columnIndexes);
	}

	public final int executeUpdate(String sql, String[] columnNames) throws SQLException {
		logger.info("executeUpdate " + sql + " " + Arrays.toString(columnNames));
		return stmt.executeUpdate(sql, columnNames);
	}

	public final boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
		logger.info("execute " + sql + " " + autoGeneratedKeys);
		return stmt.execute(sql, autoGeneratedKeys);
	}

	public final boolean execute(String sql, int[] columnIndexes) throws SQLException {
		logger.info("execute " + sql + " " + Arrays.toString(columnIndexes));
		return stmt.execute(sql, columnIndexes);
	}

	public final boolean execute(String sql, String[] columnNames) throws SQLException {
		logger.info("execute " + sql + " " + Arrays.toString(columnNames));
		return stmt.execute(sql, columnNames);
	}

	public final int getResultSetHoldability() throws SQLException {
		logger.info("getResultSetHoldability");
		return stmt.getResultSetHoldability();
	}

	public final boolean isClosed() throws SQLException {
		logger.info("isClosed");
		return stmt.isClosed();
	}

	public final void setPoolable(boolean poolable) throws SQLException {
		logger.info("setPoolable");
		stmt.setPoolable(poolable);
	}

	public final boolean isPoolable() throws SQLException {
		logger.info("isPoolable");
		return stmt.isPoolable();
	}

	public final void closeOnCompletion() throws SQLException {
		logger.info("closeOnCompletion");
		stmt.closeOnCompletion();
	}

	public final boolean isCloseOnCompletion() throws SQLException {
		logger.info("isCloseOnCompletion");
		return stmt.isCloseOnCompletion();
	}

	public final long getLargeUpdateCount() throws SQLException {
		logger.info("getLargeUpdateCount");
		return stmt.getLargeUpdateCount();
	}

	public final void setLargeMaxRows(long max) throws SQLException {
		logger.info("setLargeMaxRows");
		stmt.setLargeMaxRows(max);
	}

	public final long getLargeMaxRows() throws SQLException {
		logger.info("getLargeMaxRows");
		return stmt.getLargeMaxRows();
	}

	public final long[] executeLargeBatch() throws SQLException {
		logger.info("executeLargeBatch");
		return stmt.executeLargeBatch();
	}

	public final long executeLargeUpdate(String sql) throws SQLException {
		logger.info("executeLargeUpdate " + sql);
		return stmt.executeLargeUpdate(sql);
	}

	public final long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
		logger.info("executeLargeUpdate " + sql + " " + autoGeneratedKeys);
		return stmt.executeLargeUpdate(sql, autoGeneratedKeys);
	}

	public final long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
		logger.info("executeLargeUpdate " + sql + " " + Arrays.toString(columnIndexes));
		return stmt.executeLargeUpdate(sql, columnIndexes);
	}

	public final long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
		logger.info("executeLargeUpdate " + sql + " " + Arrays.toString(columnNames));
		return stmt.executeLargeUpdate(sql, columnNames);
	}

	public final String enquoteLiteral(String val) throws SQLException {
		logger.info("enquoteLiteral");
		return stmt.enquoteLiteral(val);
	}

	public final String enquoteIdentifier(String identifier, boolean alwaysQuote) throws SQLException {
		logger.info("enquoteIdentifier");
		return stmt.enquoteIdentifier(identifier, alwaysQuote);
	}

	public final boolean isSimpleIdentifier(String identifier) throws SQLException {
		logger.info("isSimpleIdentifier");
		return stmt.isSimpleIdentifier(identifier);
	}

	public final String enquoteNCharLiteral(String val) throws SQLException {
		logger.info("enquoteNCharLiteral");
		return stmt.enquoteNCharLiteral(val);
	}
}
