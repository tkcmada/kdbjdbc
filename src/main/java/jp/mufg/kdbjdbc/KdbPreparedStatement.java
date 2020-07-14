package jp.mufg.kdbjdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.LoggerFactory;

public class KdbPreparedStatement extends KdbStatement implements PreparedStatement {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KdbPreparedStatement.class);

    private String sql;
    private String q;
    private LinkedHashMap<String, KdbDatabaseMetaData.ColumnAndType> colnametype2;
    private ColumnInfo[] cols;
    private ResultSet rs;

    KdbPreparedStatement(String sql, Statement kdbstmt, KdbDatabaseMetaData meta) throws SQLException {
        super(kdbstmt, meta);
        prepare(sql);
    }

    KdbPreparedStatement(Statement kdbstmt, KdbDatabaseMetaData meta) throws SQLException {
        super(kdbstmt, meta);
    }

    @Override
    public final void close() throws SQLException {
        target.close();
        this.rs = null;
    }

    @Override
    public final boolean isClosed() throws SQLException {
        return target.isClosed();
    }

    private void prepare(String sql) throws SQLException {
        this.sql = sql;
        SqlSelectToQscriptTranslator sqltoq = new SqlSelectToQscriptTranslator(sql);
        sqltoq.convertLiteralType(meta);
        this.q = sqltoq.toQscript();
        logger.info("converted q-script>>>" + q + "<<<");
        this.colnametype2 = meta.getColumnAndType("(" + q + ")");

        List<ColumnInfo> cols = new ArrayList<ColumnInfo>();
        int actualColumnNumber = 0;
        for(KdbDatabaseMetaData.ColumnAndType e : colnametype2.values()) {
            actualColumnNumber++;
            String colname = SqlSelectToQscriptTranslator.dequoteColumnName(e.name);
            Character coltypeobj = e.type;
            if(! colname.startsWith(SqlExprs.DUMMY_COLUMN_PREFIX)) {
                cols.add(new ColumnInfo(colname, coltypeobj.toString(), true, actualColumnNumber));
            }
        }
        this.cols = cols.toArray(new ColumnInfo[cols.size()]);
    }

    private void setDummyResultSet() throws SQLException {
        ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(new ColumnInfo("dummy", "text", true, 1));
        this.rs = new ResultSetImpl(meta);
    }

    @Override
    public final boolean execute(String sql) throws SQLException {
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
                    prepare(sql);
                    return execute();
                }
                throw new SQLException("general SQL is not support " + sql);
            }
        }
        catch(SQLException ex) {
            logger.info("Q execution error:error=" + ex.getMessage() + " sql=" + sql + " q=" + q, ex);
            throw new SQLException("Q execution error:error=" + ex.getMessage() + " sql=" + sql + " q=" + q, ex);
        }
    }

    @Override
	public final ResultSet getResultSet() throws SQLException {
    	return rs;
	}

	@Override
	public ResultSet executeQuery() throws SQLException {
        this.execute();
        return this.getResultSet();
	}

	@Override
	public int executeUpdate() throws SQLException {
        throw new UnsupportedOperationException();
	}

	@Override
	public boolean execute() throws SQLException {
        final String qscript = "q) " + q;
        logger.info("execute on kdb+...>>>" + qscript + "<<<");
        ResultSet rs = target.executeQuery(qscript);
        this.rs = new ResultSetWrapper(getMetaData(), rs);
        return true;
	}

	@Override
	public void setNull(int parameterIndex, int sqlType) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBoolean(int parameterIndex, boolean x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setByte(int parameterIndex, byte x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setShort(int parameterIndex, short x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setInt(int parameterIndex, int x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setLong(int parameterIndex, long x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setFloat(int parameterIndex, float x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setDouble(int parameterIndex, double x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setString(int parameterIndex, String x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBytes(int parameterIndex, byte[] x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setDate(int parameterIndex, Date x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setTime(int parameterIndex, Time x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void clearParameters() throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setObject(int parameterIndex, Object x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void addBatch() throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setRef(int parameterIndex, Ref x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBlob(int parameterIndex, Blob x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setClob(int parameterIndex, Clob x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setArray(int parameterIndex, Array x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public ResultSetMetaDataImpl getMetaData() throws SQLException {
        return new ResultSetMetaDataImpl(cols);
	}

	@Override
	public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setURL(int parameterIndex, URL x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public ParameterMetaData getParameterMetaData() throws SQLException {
		throw new SQLException("not support");
	}

	@Override
	public void setRowId(int parameterIndex, RowId x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNString(int parameterIndex, String value) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNClob(int parameterIndex, NClob value) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setClob(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		throw new SQLException("not support");
		
	}

	@Override
	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
		throw new SQLException("not support");
		
	}

    
}