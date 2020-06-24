package jp.mufg.logjdbc;

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
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogPreparedStatement extends LogStatement implements PreparedStatement {
	private static final Logger logger = FileLogger.getLogger(LogPreparedStatement.class);
	private final PreparedStatement pstmt;

	public LogPreparedStatement(PreparedStatement pstmt) {
		super(pstmt);
		this.pstmt = pstmt;
	}

	public final ResultSet executeQuery() throws SQLException {
		logger.info("executeQuery");
		return pstmt.executeQuery();
	}

	public final int executeUpdate() throws SQLException {
		logger.info("executeUpdate");
		return pstmt.executeUpdate();
	}

	public final void setNull(int parameterIndex, int sqlType) throws SQLException {
		pstmt.setNull(parameterIndex, sqlType);
	}

	public final void setBoolean(int parameterIndex, boolean x) throws SQLException {
		pstmt.setBoolean(parameterIndex, x);
	}

	public final void setByte(int parameterIndex, byte x) throws SQLException {
		pstmt.setByte(parameterIndex, x);
	}

	public final void setShort(int parameterIndex, short x) throws SQLException {
		pstmt.setShort(parameterIndex, x);
	}

	public final void setInt(int parameterIndex, int x) throws SQLException {
		pstmt.setInt(parameterIndex, x);
	}

	public final void setLong(int parameterIndex, long x) throws SQLException {
		pstmt.setLong(parameterIndex, x);
	}

	public final void setFloat(int parameterIndex, float x) throws SQLException {
		pstmt.setFloat(parameterIndex, x);
	}

	public final void setDouble(int parameterIndex, double x) throws SQLException {
		pstmt.setDouble(parameterIndex, x);
	}

	public final void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
		pstmt.setBigDecimal(parameterIndex, x);
	}

	public final void setString(int parameterIndex, String x) throws SQLException {
		pstmt.setString(parameterIndex, x);
	}

	public final void setBytes(int parameterIndex, byte[] x) throws SQLException {
		pstmt.setBytes(parameterIndex, x);
	}

	public final void setDate(int parameterIndex, Date x) throws SQLException {
		pstmt.setDate(parameterIndex, x);
	}

	public final void setTime(int parameterIndex, Time x) throws SQLException {
		pstmt.setTime(parameterIndex, x);
	}

	public final void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
		pstmt.setTimestamp(parameterIndex, x);
	}

	public final void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
		pstmt.setAsciiStream(parameterIndex, x, length);
	}

	public final void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
		pstmt.setUnicodeStream(parameterIndex, x, length);
	}

	public final void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
		pstmt.setBinaryStream(parameterIndex, x, length);
	}

	public final void clearParameters() throws SQLException {
		pstmt.clearParameters();
	}

	public final void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
		pstmt.setObject(parameterIndex, x, targetSqlType);
	}

	public final void setObject(int parameterIndex, Object x) throws SQLException {
		pstmt.setObject(parameterIndex, x);
	}

	public final boolean execute() throws SQLException {
		logger.info("execute");
		return pstmt.execute();
	}

	public final void addBatch() throws SQLException {
		pstmt.addBatch();
	}

	public final void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
		pstmt.setCharacterStream(parameterIndex, reader, length);
	}

	public final void setRef(int parameterIndex, Ref x) throws SQLException {
		pstmt.setRef(parameterIndex, x);
	}

	public final void setBlob(int parameterIndex, Blob x) throws SQLException {
		pstmt.setBlob(parameterIndex, x);
	}

	public final void setClob(int parameterIndex, Clob x) throws SQLException {
		pstmt.setClob(parameterIndex, x);
	}

	public final void setArray(int parameterIndex, Array x) throws SQLException {
		pstmt.setArray(parameterIndex, x);
	}

	public final ResultSetMetaData getMetaData() throws SQLException {
		return pstmt.getMetaData();
	}

	public final void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
		pstmt.setDate(parameterIndex, x, cal);
	}

	public final void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
		pstmt.setTime(parameterIndex, x, cal);
	}

	public final void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
		pstmt.setTimestamp(parameterIndex, x, cal);
	}

	public final void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
		pstmt.setNull(parameterIndex, sqlType, typeName);
	}

	public final void setURL(int parameterIndex, URL x) throws SQLException {
		pstmt.setURL(parameterIndex, x);
	}

	public final ParameterMetaData getParameterMetaData() throws SQLException {
		logger.info("getParameterMetaData");
		return pstmt.getParameterMetaData();
	}

	public final void setRowId(int parameterIndex, RowId x) throws SQLException {
		pstmt.setRowId(parameterIndex, x);
	}

	public final void setNString(int parameterIndex, String value) throws SQLException {
		pstmt.setNString(parameterIndex, value);
	}

	public final void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
		pstmt.setNCharacterStream(parameterIndex, value, length);
	}

	public final void setNClob(int parameterIndex, NClob value) throws SQLException {
		pstmt.setNClob(parameterIndex, value);
	}

	public final void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
		pstmt.setClob(parameterIndex, reader, length);
	}

	public final void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
		pstmt.setBlob(parameterIndex, inputStream, length);
	}

	public final void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
		pstmt.setNClob(parameterIndex, reader, length);
	}

	public final void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
		pstmt.setSQLXML(parameterIndex, xmlObject);
	}

	public final void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
		pstmt.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	public final void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
		pstmt.setAsciiStream(parameterIndex, x, length);
	}

	public final void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
		pstmt.setBinaryStream(parameterIndex, x, length);
	}

	public final void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
		pstmt.setCharacterStream(parameterIndex, reader, length);
	}

	public final void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
		pstmt.setAsciiStream(parameterIndex, x);
	}

	public final void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
		pstmt.setBinaryStream(parameterIndex, x);
	}

	public final void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
		pstmt.setCharacterStream(parameterIndex, reader);
	}

	public final void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
		pstmt.setNCharacterStream(parameterIndex, value);
	}

	public final void setClob(int parameterIndex, Reader reader) throws SQLException {
		pstmt.setClob(parameterIndex, reader);
	}

	public final void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
		pstmt.setBlob(parameterIndex, inputStream);
	}

	public final void setNClob(int parameterIndex, Reader reader) throws SQLException {
		pstmt.setNClob(parameterIndex, reader);
	}

	public final void setObject(int parameterIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
		pstmt.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
	}

	public final void setObject(int parameterIndex, Object x, SQLType targetSqlType) throws SQLException {
		pstmt.setObject(parameterIndex, x, targetSqlType);
	}

	public final long executeLargeUpdate() throws SQLException {
		logger.info("executeLargeUpdate");
		return pstmt.executeLargeUpdate();
	}
	
	
}
