package jp.mufg.logjdbc;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.ShardingKey;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogConnection implements Connection {
	private static final Logger logger = LoggerFactory.getLogger(LogConnection.class);
	private final Connection target;

	public LogConnection(Connection target) {
		super();
		this.target = target;
    }
    

    ///////////////////////////////////////////////
public void abort(java.util.concurrent.Executor arg0) throws java.sql.SQLException {
	logger.info("abort" + " , " + arg0 );
target.abort(arg0);
}

public boolean isWrapperFor(java.lang.Class<?> arg0) throws java.sql.SQLException {
	logger.info("isWrapperFor" + " , " + arg0 );
	boolean result = target.isWrapperFor(arg0);
	logger.info("isWrapperFor result is " + result);
	return result;
}

public java.sql.Statement createStatement(int arg0, int arg1, int arg2) throws java.sql.SQLException {
	logger.info("createStatement" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.Statement result = new LogStatement(target.createStatement(arg0, arg1, arg2));
	logger.info("createStatement result is " + result);
	return result;
}

public java.sql.Statement createStatement() throws java.sql.SQLException {
	logger.info("createStatement");
	java.sql.Statement result = new LogStatement(target.createStatement());
	logger.info("createStatement result is " + result);
	return result;
}

public java.sql.Statement createStatement(int arg0, int arg1) throws java.sql.SQLException {
	logger.info("createStatement" + " , " + arg0  + " , " + arg1 );
	java.sql.Statement result = new LogStatement(target.createStatement(arg0, arg1));
	logger.info("createStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0, arg1, arg2);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0, int[] arg1) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0  + " , " + arg1 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0, arg1);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0, arg1, arg2, arg3);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0, String[] arg1) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0  + " , " + arg1 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0, arg1);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.PreparedStatement prepareStatement(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("prepareStatement" + " , " + arg0  + " , " + arg1 );
	java.sql.PreparedStatement result = target.prepareStatement(arg0, arg1);
	logger.info("prepareStatement result is " + result);
	return result;
}

public java.sql.CallableStatement prepareCall(String arg0, int arg1, int arg2) throws java.sql.SQLException {
	logger.info("prepareCall" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	java.sql.CallableStatement result = target.prepareCall(arg0, arg1, arg2);
	logger.info("prepareCall result is " + result);
	return result;
}

public java.sql.CallableStatement prepareCall(String arg0) throws java.sql.SQLException {
	logger.info("prepareCall" + " , " + arg0 );
	java.sql.CallableStatement result = target.prepareCall(arg0);
	logger.info("prepareCall result is " + result);
	return result;
}

public java.sql.CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws java.sql.SQLException {
	logger.info("prepareCall" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
	java.sql.CallableStatement result = target.prepareCall(arg0, arg1, arg2, arg3);
	logger.info("prepareCall result is " + result);
	return result;
}

public String nativeSQL(String arg0) throws java.sql.SQLException {
	logger.info("nativeSQL" + " , " + arg0 );
	String result = target.nativeSQL(arg0);
	logger.info("nativeSQL result is " + result);
	return result;
}

public void setAutoCommit(boolean arg0) throws java.sql.SQLException {
	logger.info("setAutoCommit" + " , " + arg0 );
target.setAutoCommit(arg0);
}

public boolean getAutoCommit() throws java.sql.SQLException {
	logger.info("getAutoCommit");
	boolean result = target.getAutoCommit();
	logger.info("getAutoCommit result is " + result);
	return result;
}

public void commit() throws java.sql.SQLException {
	logger.info("commit");
target.commit();
}

public void rollback(java.sql.Savepoint arg0) throws java.sql.SQLException {
	logger.info("rollback" + " , " + arg0 );
target.rollback(arg0);
}

public void rollback() throws java.sql.SQLException {
	logger.info("rollback");
target.rollback();
}

public boolean isClosed() throws java.sql.SQLException {
	logger.info("isClosed");
	boolean result = target.isClosed();
	logger.info("isClosed result is " + result);
	return result;
}

public java.sql.DatabaseMetaData getMetaData() throws java.sql.SQLException {
	logger.info("getMetaData");
	java.sql.DatabaseMetaData result = new LogDatabaseMetaData(target.getMetaData());
	logger.info("getMetaData result is " + result);
	return result;
}

public void setCatalog(String arg0) throws java.sql.SQLException {
	logger.info("setCatalog" + " , " + arg0 );
target.setCatalog(arg0);
}

public String getCatalog() throws java.sql.SQLException {
	logger.info("getCatalog");
	String result = target.getCatalog();
	logger.info("getCatalog result is " + result);
	return result;
}

public void setTransactionIsolation(int arg0) throws java.sql.SQLException {
	logger.info("setTransactionIsolation" + " , " + arg0 );
target.setTransactionIsolation(arg0);
}

public int getTransactionIsolation() throws java.sql.SQLException {
	logger.info("getTransactionIsolation");
	int result = target.getTransactionIsolation();
	logger.info("getTransactionIsolation result is " + result);
	return result;
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

public java.util.Map<java.lang.String, java.lang.Class<?>> getTypeMap() throws java.sql.SQLException {
	logger.info("getTypeMap");
	java.util.Map<java.lang.String, java.lang.Class<?>> result = target.getTypeMap();
	logger.info("getTypeMap result is " + result);
	return result;
}

public void setTypeMap(java.util.Map<java.lang.String, java.lang.Class<?>> arg0) throws java.sql.SQLException {
	logger.info("setTypeMap" + " , " + arg0 );
target.setTypeMap(arg0);
}

public void setHoldability(int arg0) throws java.sql.SQLException {
	logger.info("setHoldability" + " , " + arg0 );
target.setHoldability(arg0);
}

public int getHoldability() throws java.sql.SQLException {
	logger.info("getHoldability");
	int result = target.getHoldability();
	logger.info("getHoldability result is " + result);
	return result;
}

public java.sql.Savepoint setSavepoint() throws java.sql.SQLException {
	logger.info("setSavepoint");
	java.sql.Savepoint result = target.setSavepoint();
	logger.info("setSavepoint result is " + result);
	return result;
}

public java.sql.Savepoint setSavepoint(String arg0) throws java.sql.SQLException {
	logger.info("setSavepoint" + " , " + arg0 );
	java.sql.Savepoint result = target.setSavepoint(arg0);
	logger.info("setSavepoint result is " + result);
	return result;
}

public void releaseSavepoint(java.sql.Savepoint arg0) throws java.sql.SQLException {
	logger.info("releaseSavepoint" + " , " + arg0 );
target.releaseSavepoint(arg0);
}

public java.sql.Clob createClob() throws java.sql.SQLException {
	logger.info("createClob");
	java.sql.Clob result = target.createClob();
	logger.info("createClob result is " + result);
	return result;
}

public java.sql.Blob createBlob() throws java.sql.SQLException {
	logger.info("createBlob");
	java.sql.Blob result = target.createBlob();
	logger.info("createBlob result is " + result);
	return result;
}

public java.sql.NClob createNClob() throws java.sql.SQLException {
	logger.info("createNClob");
	java.sql.NClob result = target.createNClob();
	logger.info("createNClob result is " + result);
	return result;
}

public java.sql.SQLXML createSQLXML() throws java.sql.SQLException {
	logger.info("createSQLXML");
	java.sql.SQLXML result = target.createSQLXML();
	logger.info("createSQLXML result is " + result);
	return result;
}

public boolean isValid(int arg0) throws java.sql.SQLException {
	logger.info("isValid" + " , " + arg0 );
	boolean result = target.isValid(arg0);
	logger.info("isValid result is " + result);
	return result;
}

public void setClientInfo(java.util.Properties arg0) throws java.sql.SQLClientInfoException {
	logger.info("setClientInfo" + " , " + arg0 );
target.setClientInfo(arg0);
}

public void setClientInfo(String arg0, String arg1) throws java.sql.SQLClientInfoException {
	logger.info("setClientInfo" + " , " + arg0  + " , " + arg1 );
target.setClientInfo(arg0, arg1);
}

public String getClientInfo(String arg0) throws java.sql.SQLException {
	logger.info("getClientInfo" + " , " + arg0 );
	String result = target.getClientInfo(arg0);
	logger.info("getClientInfo result is " + result);
	return result;
}

public java.util.Properties getClientInfo() throws java.sql.SQLException {
	logger.info("getClientInfo");
	java.util.Properties result = target.getClientInfo();
	logger.info("getClientInfo result is " + result);
	return result;
}

public java.sql.Array createArrayOf(String arg0, Object[] arg1) throws java.sql.SQLException {
	logger.info("createArrayOf" + " , " + arg0  + " , " + arg1 );
	java.sql.Array result = target.createArrayOf(arg0, arg1);
	logger.info("createArrayOf result is " + result);
	return result;
}

public java.sql.Struct createStruct(String arg0, Object[] arg1) throws java.sql.SQLException {
	logger.info("createStruct" + " , " + arg0  + " , " + arg1 );
	java.sql.Struct result = target.createStruct(arg0, arg1);
	logger.info("createStruct result is " + result);
	return result;
}

public void setSchema(String arg0) throws java.sql.SQLException {
	logger.info("setSchema" + " , " + arg0 );
target.setSchema(arg0);
}

public String getSchema() throws java.sql.SQLException {
	logger.info("getSchema");
	String result = target.getSchema();
	logger.info("getSchema result is " + result);
	return result;
}

public void setNetworkTimeout(java.util.concurrent.Executor arg0, int arg1) throws java.sql.SQLException {
	logger.info("setNetworkTimeout" + " , " + arg0  + " , " + arg1 );
target.setNetworkTimeout(arg0, arg1);
}

public int getNetworkTimeout() throws java.sql.SQLException {
	logger.info("getNetworkTimeout");
	int result = target.getNetworkTimeout();
	logger.info("getNetworkTimeout result is " + result);
	return result;
}

public void beginRequest() throws java.sql.SQLException {
	logger.info("beginRequest");
target.beginRequest();
}

public void endRequest() throws java.sql.SQLException {
	logger.info("endRequest");
target.endRequest();
}

public boolean setShardingKeyIfValid(java.sql.ShardingKey arg0, int arg1) throws java.sql.SQLException {
	logger.info("setShardingKeyIfValid" + " , " + arg0  + " , " + arg1 );
	boolean result = target.setShardingKeyIfValid(arg0, arg1);
	logger.info("setShardingKeyIfValid result is " + result);
	return result;
}

public boolean setShardingKeyIfValid(java.sql.ShardingKey arg0, java.sql.ShardingKey arg1, int arg2) throws java.sql.SQLException {
	logger.info("setShardingKeyIfValid" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
	boolean result = target.setShardingKeyIfValid(arg0, arg1, arg2);
	logger.info("setShardingKeyIfValid result is " + result);
	return result;
}

public void setShardingKey(java.sql.ShardingKey arg0, java.sql.ShardingKey arg1) throws java.sql.SQLException {
	logger.info("setShardingKey" + " , " + arg0  + " , " + arg1 );
target.setShardingKey(arg0, arg1);
}

public void setShardingKey(java.sql.ShardingKey arg0) throws java.sql.SQLException {
	logger.info("setShardingKey" + " , " + arg0 );
target.setShardingKey(arg0);
}

public void setReadOnly(boolean arg0) throws java.sql.SQLException {
	logger.info("setReadOnly" + " , " + arg0 );
target.setReadOnly(arg0);
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

public boolean isReadOnly() throws java.sql.SQLException {
	logger.info("isReadOnly");
	boolean result = target.isReadOnly();
	logger.info("isReadOnly result is " + result);
	return result;
}

}
