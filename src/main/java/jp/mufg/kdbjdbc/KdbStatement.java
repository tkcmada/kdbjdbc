package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

import jp.mufg.slf4j.FileLogger;

public class KdbStatement implements Statement {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(KdbStatement.class);
    protected final Statement target;
    private final KdbDatabaseMetaData meta;
    protected ResultSet rs;

    KdbStatement(Statement target, KdbDatabaseMetaData meta) {
        this.target = target;
        this.meta = meta;
    }

    private void setDummyResultSet() throws SQLException {
        ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(new ColumnInfo("dummy", "text", true));
        this.rs = new ResultSetImpl(meta);
    }

    @Override
    public final void close() throws SQLException {
        target.close();
    }

    @Override
    public final boolean isClosed() throws SQLException {
        return target.isClosed();
    }

    @Override
    public final boolean execute(String sql) throws SQLException {
        String pure_q = null;
        try {
            logger.info("execute:" + String.valueOf(sql));
            setDummyResultSet();
            if(sql.startsWith("q)")) {
                rs = target.executeQuery(sql);
                return true;
            }
            else {
                if(sql.contains(" TEMPORARY ") || sql.contains("DROP TABLE")) {
                    logger.info("This sql is not supported. " + sql);
                    throw new SQLException("temp table is not supported. " + sql);
                }
                else if(sql.startsWith("SELECT ")) {
                    KdbPreparedStatement pstmt = new KdbPreparedStatement(sql, target, meta);
                    try {
                        pstmt.execute();
                        this.rs = pstmt.getResultSet();
                        return true;
                    } finally {
                        pstmt.close();
                    }
                }
                throw new SQLException("general SQL is not support " + sql);
            }
        }
        catch(SQLException ex) {
            logger.info("Q execution error:error=" + ex.getMessage() + " sql=" + sql + " q=" + pure_q, ex);
            throw new SQLException("Q execution error:error=" + ex.getMessage() + " sql=" + sql + " q=" + pure_q, ex);
        }
    }

    @Override
	public final ResultSet getResultSet() throws SQLException {
    	return rs;
	}

	@Override
	public final <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new SQLException("KdbStatement.unwrap is not supported");
		
	}

	@Override
	public final boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new SQLException("KdbStatement.isWrapperFor is not supported");
		
	}

	@Override
	public final ResultSet executeQuery(String sql) throws SQLException {
        logger.info("executeQuery");
        execute(sql);
        return getResultSet();
	}

	@Override
	public final int executeUpdate(String sql) throws SQLException {
		logger.info("executeUpdate");
		throw new SQLException("KdbStatement.executeUpdate is not supported");
		
	}

	@Override
    public final int getMaxFieldSize() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void setMaxFieldSize(int max) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int getMaxRows() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void setMaxRows(int max) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final void setEscapeProcessing(boolean enable) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int getQueryTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void setQueryTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final void cancel() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final SQLWarning getWarnings() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final void clearWarnings() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final void setCursorName(String name) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int getUpdateCount() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final boolean getMoreResults() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final void setFetchDirection(int direction) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int getFetchDirection() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void setFetchSize(int rows) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int getFetchSize() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final int getResultSetConcurrency() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final int getResultSetType() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void addBatch(String sql) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final void clearBatch() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final int[] executeBatch() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final boolean getMoreResults(int current) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final ResultSet getGeneratedKeys() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public final int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final int executeUpdate(String sql, String[] columnNames) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final boolean execute(String sql, int[] columnIndexes) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final boolean execute(String sql, String[] columnNames) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final int getResultSetHoldability() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public final void setPoolable(boolean poolable) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final boolean isPoolable() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public final void closeOnCompletion() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public final boolean isCloseOnCompletion() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}