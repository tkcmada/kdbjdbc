package jp.mufg.kdbjdbc;

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
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import jp.mufg.slf4j.FileLogger;

public class KdbConnection implements Connection {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(KdbConnection.class); //LoggerFactory.getLogger(KdbConnection.class);
    // private final Connection conn;

    public KdbConnection() {
        // this.conn = conn;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return new KdbStatement(); //conn.createStatement());
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        throw new UnsupportedOperationException("prepareStatement " + sql);
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        throw new UnsupportedOperationException("setAutoCommit");
    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        throw new UnsupportedOperationException("getAutoCommit");
    }

    @Override
    public void commit() throws SQLException {
        throw new UnsupportedOperationException("commit");
    }

    @Override
    public void rollback() throws SQLException {
        throw new UnsupportedOperationException("rollback");
    }

    @Override
    public void close() throws SQLException {
        // conn.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException("isClosed");
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        logger.info("getMetaData");
        return new KdbDatabaseMetaData();
    }

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new UnsupportedOperationException("KdbConnection.unwrap is not supported");
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new UnsupportedOperationException("KdbConnection.isWrapperFor is not supported");
		
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		logger.info("prepareCall");
		throw new UnsupportedOperationException("KdbConnection.prepareCall is not supported");
		
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		logger.info("nativeSQL");
		throw new UnsupportedOperationException("KdbConnection.nativeSQL is not supported");
		
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		logger.info("setReadOnly");
		throw new UnsupportedOperationException("KdbConnection.setReadOnly is not supported");
		
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		logger.info("isReadOnly");
		throw new UnsupportedOperationException("KdbConnection.isReadOnly is not supported");
		
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		logger.info("setCatalog");
		throw new UnsupportedOperationException("KdbConnection.setCatalog is not supported");
		
	}

	@Override
	public String getCatalog() throws SQLException {
		logger.info("getCatalog");
		throw new UnsupportedOperationException("KdbConnection.getCatalog is not supported");
		
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		logger.info("setTransactionIsolation");
		throw new UnsupportedOperationException("KdbConnection.setTransactionIsolation is not supported");
		
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		logger.info("getTransactionIsolation");
		throw new UnsupportedOperationException("KdbConnection.getTransactionIsolation is not supported");
		
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		logger.info("getWarnings");
		throw new UnsupportedOperationException("KdbConnection.getWarnings is not supported");
		
	}

	@Override
	public void clearWarnings() throws SQLException {
		logger.info("clearWarnings");
		throw new UnsupportedOperationException("KdbConnection.clearWarnings is not supported");
		
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		logger.info("createStatement");
		throw new UnsupportedOperationException("KdbConnection.createStatement is not supported");
		
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		logger.info("prepareStatement");
		throw new UnsupportedOperationException("KdbConnection.prepareStatement is not supported");
		
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		logger.info("prepareCall");
		throw new UnsupportedOperationException("KdbConnection.prepareCall is not supported");
		
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		logger.info("getTypeMap");
		throw new UnsupportedOperationException("KdbConnection.getTypeMap is not supported");
		
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		logger.info("setTypeMap");
		throw new UnsupportedOperationException("KdbConnection.setTypeMap is not supported");
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		logger.info("setHoldability");
		throw new UnsupportedOperationException("KdbConnection.setHoldability is not supported");
		
	}

	@Override
	public int getHoldability() throws SQLException {
		logger.info("getHoldability");
		throw new UnsupportedOperationException("KdbConnection.getHoldability is not supported");
		
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		logger.info("setSavepoint");
		throw new UnsupportedOperationException("KdbConnection.setSavepoint is not supported");
		
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		logger.info("setSavepoint");
		throw new UnsupportedOperationException("KdbConnection.setSavepoint is not supported");
		
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		logger.info("rollback");
		throw new UnsupportedOperationException("KdbConnection.rollback is not supported");
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		logger.info("releaseSavepoint");
		throw new UnsupportedOperationException("KdbConnection.releaseSavepoint is not supported");
		
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		logger.info("createStatement");
		throw new UnsupportedOperationException("KdbConnection.createStatement is not supported");
		
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		logger.info("prepareStatement");
		throw new UnsupportedOperationException("KdbConnection.prepareStatement is not supported");
		
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		logger.info("prepareCall");
		throw new UnsupportedOperationException("KdbConnection.prepareCall is not supported");
		
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		logger.info("prepareStatement");
		throw new UnsupportedOperationException("KdbConnection.prepareStatement is not supported");
		
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		logger.info("prepareStatement");
		throw new UnsupportedOperationException("KdbConnection.prepareStatement is not supported");
		
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		logger.info("prepareStatement");
		throw new UnsupportedOperationException("KdbConnection.prepareStatement is not supported");
		
	}

	@Override
	public Clob createClob() throws SQLException {
		logger.info("createClob");
		throw new UnsupportedOperationException("KdbConnection.createClob is not supported");
		
	}

	@Override
	public Blob createBlob() throws SQLException {
		logger.info("createBlob");
		throw new UnsupportedOperationException("KdbConnection.createBlob is not supported");
		
	}

	@Override
	public NClob createNClob() throws SQLException {
		logger.info("createNClob");
		throw new UnsupportedOperationException("KdbConnection.createNClob is not supported");
		
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		logger.info("createSQLXML");
		throw new UnsupportedOperationException("KdbConnection.createSQLXML is not supported");
		
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		logger.info("isValid");
		return true;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		logger.info("setClientInfo");
		throw new UnsupportedOperationException("KdbConnection.setClientInfo is not supported");
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		logger.info("setClientInfo");
		throw new UnsupportedOperationException("KdbConnection.setClientInfo is not supported");
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		logger.info("getClientInfo");
		throw new UnsupportedOperationException("KdbConnection.getClientInfo is not supported");
		
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		logger.info("getClientInfo");
		throw new UnsupportedOperationException("KdbConnection.getClientInfo is not supported");
		
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		logger.info("createArrayOf");
		throw new UnsupportedOperationException("KdbConnection.createArrayOf is not supported");
		
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		logger.info("createStruct");
		throw new UnsupportedOperationException("KdbConnection.createStruct is not supported");
		
	}

	@Override
	public void setSchema(String schema) throws SQLException {
		logger.info("setSchema");
		throw new UnsupportedOperationException("KdbConnection.setSchema is not supported");
		
	}

	@Override
	public String getSchema() throws SQLException {
		logger.info("getSchema");
		throw new UnsupportedOperationException("KdbConnection.getSchema is not supported");
		
	}

	@Override
	public void abort(Executor executor) throws SQLException {
		logger.info("abort");
		throw new UnsupportedOperationException("KdbConnection.abort is not supported");
		
	}

	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		logger.info("setNetworkTimeout");
		throw new UnsupportedOperationException("KdbConnection.setNetworkTimeout is not supported");
		
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		logger.info("getNetworkTimeout");
		throw new UnsupportedOperationException("KdbConnection.getNetworkTimeout is not supported");
		
	}
}