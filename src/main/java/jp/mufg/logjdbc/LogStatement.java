package jp.mufg.logjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogStatement implements Statement {
	private static final Logger logger = LoggerFactory.getLogger(LogStatement.class);
	private final Statement target;

	public LogStatement(Statement target) {
		super();
		this.target = target;
	}



public boolean execute(String arg0, String[] arg1) throws java.sql.SQLException {
	logger.info("execute" + " , " + arg0  + " , " + arg1 );
	boolean result = target.execute(arg0, arg1);
	logger.info("execute result is " + result);
	return result;
}

public boolean execute(String arg0) throws java.sql.SQLException {
	logger.info("execute" + " , " + arg0 );
	boolean result = target.execute(arg0);
	logger.info("execute result is " + result);
	return result;
}

public boolean execute(String arg0, int[] arg1) throws java.sql.SQLException {
	logger.info("execute" + " , " + arg0  + " , " + arg1 );
	boolean result = target.execute(arg0, arg1);
	logger.info("execute result is " + result);
	return result;
}

public boolean execute(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("execute" + " , " + arg0  + " , " + arg1 );
	boolean result = target.execute(arg0, arg1);
	logger.info("execute result is " + result);
	return result;
}

public void close() throws java.sql.SQLException {
	logger.info("close");
target.close();
}

public <T> T unwrap(java.lang.Class<T> arg0) throws java.sql.SQLException {
	logger.info("unwrap" + " , " + arg0 );
	T result = target.unwrap(arg0);
	logger.info("unwrap result is " + result);
	return result;
}

public java.sql.ResultSet executeQuery(String arg0) throws java.sql.SQLException {
	logger.info("executeQuery" + " , " + arg0 );
	java.sql.ResultSet result = new LogResultSet( target.executeQuery(arg0) );
	logger.info("executeQuery result is " + result);
	return result;
}

public boolean isWrapperFor(java.lang.Class<?> arg0) throws java.sql.SQLException {
	logger.info("isWrapperFor" + " , " + arg0 );
	boolean result = target.isWrapperFor(arg0);
	logger.info("isWrapperFor result is " + result);
	return result;
}

public int executeUpdate(String arg0) throws java.sql.SQLException {
	logger.info("executeUpdate" + " , " + arg0 );
	int result = target.executeUpdate(arg0);
	logger.info("executeUpdate result is " + result);
	return result;
}

public int executeUpdate(String arg0, int[] arg1) throws java.sql.SQLException {
	logger.info("executeUpdate" + " , " + arg0  + " , " + arg1 );
	int result = target.executeUpdate(arg0, arg1);
	logger.info("executeUpdate result is " + result);
	return result;
}

public int executeUpdate(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("executeUpdate" + " , " + arg0  + " , " + arg1 );
	int result = target.executeUpdate(arg0, arg1);
	logger.info("executeUpdate result is " + result);
	return result;
}

public int executeUpdate(String arg0, String[] arg1) throws java.sql.SQLException {
	logger.info("executeUpdate" + " , " + arg0  + " , " + arg1 );
	int result = target.executeUpdate(arg0, arg1);
	logger.info("executeUpdate result is " + result);
	return result;
}

public int getMaxFieldSize() throws java.sql.SQLException {
	logger.info("getMaxFieldSize");
	int result = target.getMaxFieldSize();
	logger.info("getMaxFieldSize result is " + result);
	return result;
}

public void setMaxFieldSize(int arg0) throws java.sql.SQLException {
	logger.info("setMaxFieldSize" + " , " + arg0 );
target.setMaxFieldSize(arg0);
}

public int getMaxRows() throws java.sql.SQLException {
	logger.info("getMaxRows");
	int result = target.getMaxRows();
	logger.info("getMaxRows result is " + result);
	return result;
}

public void setMaxRows(int arg0) throws java.sql.SQLException {
	logger.info("setMaxRows" + " , " + arg0 );
target.setMaxRows(arg0);
}

public void setEscapeProcessing(boolean arg0) throws java.sql.SQLException {
	logger.info("setEscapeProcessing" + " , " + arg0 );
target.setEscapeProcessing(arg0);
}

public int getQueryTimeout() throws java.sql.SQLException {
	logger.info("getQueryTimeout");
	int result = target.getQueryTimeout();
	logger.info("getQueryTimeout result is " + result);
	return result;
}

public void setQueryTimeout(int arg0) throws java.sql.SQLException {
	logger.info("setQueryTimeout" + " , " + arg0 );
target.setQueryTimeout(arg0);
}

public void cancel() throws java.sql.SQLException {
	logger.info("cancel");
target.cancel();
}

public java.sql.SQLWarning getWarnings() throws java.sql.SQLException {
	logger.info("getWarnings");
	java.sql.SQLWarning result = target.getWarnings();
	logger.info("getWarnings result is " + result);
	return result;
}

public void clearWarnings() throws java.sql.SQLException {
	logger.info("clearWarnings");
target.clearWarnings();
}

public void setCursorName(String arg0) throws java.sql.SQLException {
	logger.info("setCursorName" + " , " + arg0 );
target.setCursorName(arg0);
}

public java.sql.ResultSet getResultSet() throws java.sql.SQLException {
	logger.info("getResultSet");
	java.sql.ResultSet result = new LogResultSet( target.getResultSet() );
	logger.info("getResultSet result is " + result);
	return result;
}

public int getUpdateCount() throws java.sql.SQLException {
	logger.info("getUpdateCount");
	int result = target.getUpdateCount();
	logger.info("getUpdateCount result is " + result);
	return result;
}

public boolean getMoreResults(int arg0) throws java.sql.SQLException {
	logger.info("getMoreResults" + " , " + arg0 );
	boolean result = target.getMoreResults(arg0);
	logger.info("getMoreResults result is " + result);
	return result;
}

public boolean getMoreResults() throws java.sql.SQLException {
	logger.info("getMoreResults");
	boolean result = target.getMoreResults();
	logger.info("getMoreResults result is " + result);
	return result;
}

public void setFetchDirection(int arg0) throws java.sql.SQLException {
	logger.info("setFetchDirection" + " , " + arg0 );
target.setFetchDirection(arg0);
}

public int getFetchDirection() throws java.sql.SQLException {
	logger.info("getFetchDirection");
	int result = target.getFetchDirection();
	logger.info("getFetchDirection result is " + result);
	return result;
}

public void setFetchSize(int arg0) throws java.sql.SQLException {
	logger.info("setFetchSize" + " , " + arg0 );
target.setFetchSize(arg0);
}

public int getFetchSize() throws java.sql.SQLException {
	logger.info("getFetchSize");
	int result = target.getFetchSize();
	logger.info("getFetchSize result is " + result);
	return result;
}

public int getResultSetConcurrency() throws java.sql.SQLException {
	logger.info("getResultSetConcurrency");
	int result = target.getResultSetConcurrency();
	logger.info("getResultSetConcurrency result is " + result);
	return result;
}

public int getResultSetType() throws java.sql.SQLException {
	logger.info("getResultSetType");
	int result = target.getResultSetType();
	logger.info("getResultSetType result is " + result);
	return result;
}

public void addBatch(String arg0) throws java.sql.SQLException {
	logger.info("addBatch" + " , " + arg0 );
target.addBatch(arg0);
}

public void clearBatch() throws java.sql.SQLException {
	logger.info("clearBatch");
target.clearBatch();
}

public int[] executeBatch() throws java.sql.SQLException {
	logger.info("executeBatch");
	int[] result = target.executeBatch();
	logger.info("executeBatch result is " + result);
	return result;
}

public java.sql.Connection getConnection() throws java.sql.SQLException {
	logger.info("getConnection");
	java.sql.Connection result = target.getConnection();
	logger.info("getConnection result is " + result);
	return result;
}

public java.sql.ResultSet getGeneratedKeys() throws java.sql.SQLException {
	logger.info("getGeneratedKeys");
	java.sql.ResultSet result = new LogResultSet( target.getGeneratedKeys() );
	logger.info("getGeneratedKeys result is " + result);
	return result;
}

public int getResultSetHoldability() throws java.sql.SQLException {
	logger.info("getResultSetHoldability");
	int result = target.getResultSetHoldability();
	logger.info("getResultSetHoldability result is " + result);
	return result;
}

public boolean isClosed() throws java.sql.SQLException {
	logger.info("isClosed");
	boolean result = target.isClosed();
	logger.info("isClosed result is " + result);
	return result;
}

public void setPoolable(boolean arg0) throws java.sql.SQLException {
	logger.info("setPoolable" + " , " + arg0 );
target.setPoolable(arg0);
}

public boolean isPoolable() throws java.sql.SQLException {
	logger.info("isPoolable");
	boolean result = target.isPoolable();
	logger.info("isPoolable result is " + result);
	return result;
}

public void closeOnCompletion() throws java.sql.SQLException {
	logger.info("closeOnCompletion");
target.closeOnCompletion();
}

public boolean isCloseOnCompletion() throws java.sql.SQLException {
	logger.info("isCloseOnCompletion");
	boolean result = target.isCloseOnCompletion();
	logger.info("isCloseOnCompletion result is " + result);
	return result;
}

public long getLargeUpdateCount() throws java.sql.SQLException {
	logger.info("getLargeUpdateCount");
	long result = target.getLargeUpdateCount();
	logger.info("getLargeUpdateCount result is " + result);
	return result;
}

public void setLargeMaxRows(long arg0) throws java.sql.SQLException {
	logger.info("setLargeMaxRows" + " , " + arg0 );
target.setLargeMaxRows(arg0);
}

public long getLargeMaxRows() throws java.sql.SQLException {
	logger.info("getLargeMaxRows");
	long result = target.getLargeMaxRows();
	logger.info("getLargeMaxRows result is " + result);
	return result;
}

public long[] executeLargeBatch() throws java.sql.SQLException {
	logger.info("executeLargeBatch");
	long[] result = target.executeLargeBatch();
	logger.info("executeLargeBatch result is " + result);
	return result;
}

public long executeLargeUpdate(String arg0, int[] arg1) throws java.sql.SQLException {
	logger.info("executeLargeUpdate" + " , " + arg0  + " , " + arg1 );
	long result = target.executeLargeUpdate(arg0, arg1);
	logger.info("executeLargeUpdate result is " + result);
	return result;
}

public long executeLargeUpdate(String arg0, String[] arg1) throws java.sql.SQLException {
	logger.info("executeLargeUpdate" + " , " + arg0  + " , " + arg1 );
	long result = target.executeLargeUpdate(arg0, arg1);
	logger.info("executeLargeUpdate result is " + result);
	return result;
}

public long executeLargeUpdate(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("executeLargeUpdate" + " , " + arg0  + " , " + arg1 );
	long result = target.executeLargeUpdate(arg0, arg1);
	logger.info("executeLargeUpdate result is " + result);
	return result;
}

public long executeLargeUpdate(String arg0) throws java.sql.SQLException {
	logger.info("executeLargeUpdate" + " , " + arg0 );
	long result = target.executeLargeUpdate(arg0);
	logger.info("executeLargeUpdate result is " + result);
	return result;
}

public String enquoteLiteral(String arg0) throws java.sql.SQLException {
	logger.info("enquoteLiteral" + " , " + arg0 );
	String result = target.enquoteLiteral(arg0);
	logger.info("enquoteLiteral result is " + result);
	return result;
}

public String enquoteIdentifier(String arg0, boolean arg1) throws java.sql.SQLException {
	logger.info("enquoteIdentifier" + " , " + arg0  + " , " + arg1 );
	String result = target.enquoteIdentifier(arg0, arg1);
	logger.info("enquoteIdentifier result is " + result);
	return result;
}

public boolean isSimpleIdentifier(String arg0) throws java.sql.SQLException {
	logger.info("isSimpleIdentifier" + " , " + arg0 );
	boolean result = target.isSimpleIdentifier(arg0);
	logger.info("isSimpleIdentifier result is " + result);
	return result;
}

public String enquoteNCharLiteral(String arg0) throws java.sql.SQLException {
	logger.info("enquoteNCharLiteral" + " , " + arg0 );
	String result = target.enquoteNCharLiteral(arg0);
	logger.info("enquoteNCharLiteral result is " + result);
	return result;
}



}
