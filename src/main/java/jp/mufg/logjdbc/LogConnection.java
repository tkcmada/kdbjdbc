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

import jp.mufg.slf4j.FileLogger;

public class LogConnection implements Connection {
	private static final Logger logger = FileLogger.getLogger(LogConnection.class);
	private final Connection conn;

	public LogConnection(Connection conn) {
		super();
		this.conn = conn;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap " + iface);
		return conn.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor " + iface);
		return conn.isWrapperFor(iface);
	}

	public Statement createStatement() throws SQLException {
		logger.info("createStatement");
		return new LogStatement(conn.createStatement());
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		logger.info("prepareStatement " + sql);
		return new LogPreparedStatement(conn.prepareStatement(sql));
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		logger.info("prepareCall " + sql);
		return new LogCallableStatement(conn.prepareCall(sql));
	}

	public String nativeSQL(String sql) throws SQLException {
		logger.info("nativeSQL " + sql);
		return conn.nativeSQL(sql);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		logger.info("setAutoCommit " + autoCommit);
		conn.setAutoCommit(autoCommit);
	}

	public boolean getAutoCommit() throws SQLException {
		logger.info("getAutoCommit");
		return conn.getAutoCommit();
	}

	public void commit() throws SQLException {
		logger.info("commit");
		conn.commit();
	}

	public void rollback() throws SQLException {
		logger.info("rollback");
		conn.rollback();
	}

	public void close() throws SQLException {
		logger.info("close");
		conn.close();
	}

	public boolean isClosed() throws SQLException {
		logger.info("isClosed");
		return conn.isClosed();
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		logger.info("getMetaData");
		return new LogDatabaseMetaData(conn.getMetaData());
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		logger.info("setReadOnly " + readOnly);
		conn.setReadOnly(readOnly);
	}

	public boolean isReadOnly() throws SQLException {
		logger.info("isReadOnly");
		return conn.isReadOnly();
	}

	public void setCatalog(String catalog) throws SQLException {
		logger.info("setCatalog " + catalog);
		conn.setCatalog(catalog);
	}

	public String getCatalog() throws SQLException {
		logger.info("getCatalog");
		return conn.getCatalog();
	}

	public void setTransactionIsolation(int level) throws SQLException {
		logger.info("setTransactionIsolation " + level);
		conn.setTransactionIsolation(level);
	}

	public int getTransactionIsolation() throws SQLException {
		logger.info("getTransactionIsolation");
		return conn.getTransactionIsolation();
	}

	public SQLWarning getWarnings() throws SQLException {
		logger.info("getWarnings");
		return conn.getWarnings();
	}

	public void clearWarnings() throws SQLException {
		logger.info("clearWarnings");
		conn.clearWarnings();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		logger.info("createStatement" + resultSetType + " " + resultSetConcurrency);
		return new LogStatement(conn.createStatement(resultSetType, resultSetConcurrency));
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		logger.info("prepareStatement" + sql + " " + resultSetType + " " + resultSetConcurrency);
		return new LogPreparedStatement(conn.prepareStatement(sql, resultSetType, resultSetConcurrency));
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		logger.info("prepareCall" + sql + " " + resultSetType + " " + resultSetConcurrency);
		return new LogCallableStatement(conn.prepareCall(sql, resultSetType, resultSetConcurrency));
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		logger.info("getTypeMap");
		return conn.getTypeMap();
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		logger.info("setTypeMap " + map);
		conn.setTypeMap(map);
	}

	public void setHoldability(int holdability) throws SQLException {
		logger.info("setHoldability " + holdability);
		conn.setHoldability(holdability);
	}

	public int getHoldability() throws SQLException {
		logger.info("getHoldability");
		return conn.getHoldability();
	}

	public Savepoint setSavepoint() throws SQLException {
		logger.info("setSavepoint");
		return conn.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		logger.info("setSavepoint " + name);
		return conn.setSavepoint(name);
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		logger.info("rollback " + savepoint);
		conn.rollback(savepoint);
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		logger.info("releaseSavepoint " + savepoint);
		conn.releaseSavepoint(savepoint);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		logger.info("createStatement " + resultSetType + " " + resultSetConcurrency + " " + resultSetHoldability);
		return new LogStatement(conn.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		logger.info("prepareStatement " + sql + " " + resultSetType + " " + resultSetConcurrency + " " + resultSetHoldability);
		return new LogPreparedStatement(conn.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		logger.info("prepareCall " + sql + " " + resultSetType + " " + resultSetConcurrency + " " + resultSetHoldability);
		return new LogCallableStatement(conn.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		logger.info("prepareStatement " + sql + " " + autoGeneratedKeys);
		return new LogPreparedStatement(conn.prepareStatement(sql, autoGeneratedKeys));
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		logger.info("prepareStatement " + sql + " " + Arrays.toString(columnIndexes));
		return new LogPreparedStatement(conn.prepareStatement(sql, columnIndexes));
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		logger.info("prepareStatement " + sql + " " + Arrays.toString(columnNames));
		return new LogPreparedStatement(conn.prepareStatement(sql, columnNames));
	}

	public Clob createClob() throws SQLException {
		logger.info("createClob");
		return conn.createClob();
	}

	public Blob createBlob() throws SQLException {
		logger.info("createBlob");
		return conn.createBlob();
	}

	public NClob createNClob() throws SQLException {
		logger.info("createNClob");
		return conn.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		logger.info("createSQLXML");
		return conn.createSQLXML();
	}

	public boolean isValid(int timeout) throws SQLException {
		logger.info("isValid " + timeout);
		return conn.isValid(timeout);
	}

	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		logger.info("setClientInfo " + name + " " + value);
		conn.setClientInfo(name, value);
	}

	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		logger.info("setClientInfo " + properties);
		conn.setClientInfo(properties);
	}

	public String getClientInfo(String name) throws SQLException {
		logger.info("getClientInfo " + name);
		return conn.getClientInfo(name);
	}

	public Properties getClientInfo() throws SQLException {
		logger.info("getClientInfo");
		return conn.getClientInfo();
	}

	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		logger.info("createArrayOf " + typeName + " " + Arrays.toString(elements));
		return conn.createArrayOf(typeName, elements);
	}

	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		logger.info("createArrayOf " + typeName + " " + Arrays.toString(attributes));
		return conn.createStruct(typeName, attributes);
	}

	public void setSchema(String schema) throws SQLException {
		logger.info("setSchema " + schema);
		conn.setSchema(schema);
	}

	public String getSchema() throws SQLException {
		logger.info("getSchema");
		return conn.getSchema();
	}

	public void abort(Executor executor) throws SQLException {
		logger.info("abort " + executor);
		conn.abort(executor);
	}

	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		logger.info("setNetworkTimeout " + executor + " " + milliseconds);
		conn.setNetworkTimeout(executor, milliseconds);
	}

	public int getNetworkTimeout() throws SQLException {
		logger.info("getNetworkTimeout");
		return conn.getNetworkTimeout();
	}

	public void beginRequest() throws SQLException {
		logger.info("beginRequest");
		conn.beginRequest();
	}

	public void endRequest() throws SQLException {
		logger.info("endRequest");
		conn.endRequest();
	}

	public boolean setShardingKeyIfValid(ShardingKey shardingKey, ShardingKey superShardingKey, int timeout)
			throws SQLException {
		logger.info("setShardingKeyIfValid " + shardingKey + " " + superShardingKey + " " + timeout);
		return conn.setShardingKeyIfValid(shardingKey, superShardingKey, timeout);
	}

	public boolean setShardingKeyIfValid(ShardingKey shardingKey, int timeout) throws SQLException {
		logger.info("setShardingKeyIfValid " + shardingKey + " " + timeout);
		return conn.setShardingKeyIfValid(shardingKey, timeout);
	}

	public void setShardingKey(ShardingKey shardingKey, ShardingKey superShardingKey) throws SQLException {
		logger.info("setShardingKeyIfValid " + shardingKey + " " + superShardingKey);
		conn.setShardingKey(shardingKey, superShardingKey);
	}

	public void setShardingKey(ShardingKey shardingKey) throws SQLException {
		logger.info("setShardingKeyIfValid " + shardingKey);
		conn.setShardingKey(shardingKey);
	}
}
