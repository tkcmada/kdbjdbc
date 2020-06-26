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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogResultSet implements ResultSet {
	private static final Logger logger = FileLogger.getLogger(LogResultSet.class);

	private final ResultSet rs;

	public LogResultSet(ResultSet rs) {
		super();
		this.rs = rs;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
        logger.info("unrwap");
		return rs.unwrap(iface);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
        logger.info("isWrapperFor");
		return rs.isWrapperFor(iface);
	}

	public boolean next() throws SQLException {
		boolean result = rs.next();
		logger.info("next() -> " + result);
		if(result) {
			logger.info("----");
			ResultSetMetaData meta = getMetaData();
			int n = meta.getColumnCount();
			for(int i = 1; i <= n; i++) {
                Object value = getObject(i);
				logger.info(i + ":" + meta.getColumnName(i) + ":" + value + "(" + (value == null ? "null" : value.getClass().getName()) + ")");
			}
			logger.info("----");
		}
		return result;
	}

	public void close() throws SQLException {
        logger.info("close");
        rs.close();
	}

	public boolean wasNull() throws SQLException {
        logger.info("wasNull");
		return rs.wasNull();
	}

	public String getString(int columnIndex) throws SQLException {
        logger.info("getString" + columnIndex);
		return rs.getString(columnIndex);
	}

	public boolean getBoolean(int columnIndex) throws SQLException {
        logger.info("getBoolean" + columnIndex);
		return rs.getBoolean(columnIndex);
	}

	public byte getByte(int columnIndex) throws SQLException {
        logger.info("getByte" + columnIndex);
		return rs.getByte(columnIndex);
	}

	public short getShort(int columnIndex) throws SQLException {
        logger.info("getShort" + columnIndex);
		return rs.getShort(columnIndex);
	}

	public int getInt(int columnIndex) throws SQLException {
        logger.info("getInt" + columnIndex);
		return rs.getInt(columnIndex);
	}

	public long getLong(int columnIndex) throws SQLException {
        logger.info("getLong" + columnIndex);
		return rs.getLong(columnIndex);
	}

	public float getFloat(int columnIndex) throws SQLException {
        logger.info("getFloat" + columnIndex);
		return rs.getFloat(columnIndex);
	}

	public double getDouble(int columnIndex) throws SQLException {
        logger.info("getDouble" + columnIndex);
		return rs.getDouble(columnIndex);
	}

	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        logger.info("getBigDecimal" + columnIndex + " " + scale);
		return rs.getBigDecimal(columnIndex, scale);
	}

	public byte[] getBytes(int columnIndex) throws SQLException {
        logger.info("getBytes" + columnIndex);
		return rs.getBytes(columnIndex);
	}

	public Date getDate(int columnIndex) throws SQLException {
        logger.info("getDate" + columnIndex);
		return rs.getDate(columnIndex);
	}

	public Time getTime(int columnIndex) throws SQLException {
        logger.info("getTime" + columnIndex);
		return rs.getTime(columnIndex);
	}

	public Timestamp getTimestamp(int columnIndex) throws SQLException {
        logger.info("getTimestamp" + columnIndex);
		return rs.getTimestamp(columnIndex);
	}

	public InputStream getAsciiStream(int columnIndex) throws SQLException {
        logger.info("getAsciiStream" + columnIndex);
		return rs.getAsciiStream(columnIndex);
	}

	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        logger.info("getUnicodeStream" + columnIndex);
		return rs.getUnicodeStream(columnIndex);
	}

	public InputStream getBinaryStream(int columnIndex) throws SQLException {
        logger.info("getBinaryStream" + columnIndex);
		return rs.getBinaryStream(columnIndex);
	}

	public String getString(String columnLabel) throws SQLException {
        logger.info("getString " + columnLabel);
		return rs.getString(columnLabel);
	}

	public boolean getBoolean(String columnLabel) throws SQLException {
        logger.info("getBoolean " + columnLabel);
		return rs.getBoolean(columnLabel);
	}

	public byte getByte(String columnLabel) throws SQLException {
        logger.info("getByte " + columnLabel);
		return rs.getByte(columnLabel);
	}

	public short getShort(String columnLabel) throws SQLException {
        logger.info("getShort " + columnLabel);
		return rs.getShort(columnLabel);
	}

	public int getInt(String columnLabel) throws SQLException {
        logger.info("getInt " + columnLabel);
		return rs.getInt(columnLabel);
	}

	public long getLong(String columnLabel) throws SQLException {
        logger.info("getLong " + columnLabel);
		return rs.getLong(columnLabel);
	}

	public float getFloat(String columnLabel) throws SQLException {
        logger.info("getFloat " + columnLabel);
		return rs.getFloat(columnLabel);
	}

	public double getDouble(String columnLabel) throws SQLException {
        logger.info("getDouble " + columnLabel);
		return rs.getDouble(columnLabel);
	}

	public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        logger.info("getBigDecimal " + columnLabel + " " + scale);
		return rs.getBigDecimal(columnLabel, scale);
	}

	public byte[] getBytes(String columnLabel) throws SQLException {
        logger.info("getBytes " + columnLabel);
		return rs.getBytes(columnLabel);
	}

	public Date getDate(String columnLabel) throws SQLException {
        logger.info("getDate " + columnLabel);
		return rs.getDate(columnLabel);
	}

	public Time getTime(String columnLabel) throws SQLException {
        logger.info("getTime " + columnLabel);
		return rs.getTime(columnLabel);
	}

	public Timestamp getTimestamp(String columnLabel) throws SQLException {
        logger.info("getTimestamp " + columnLabel);
		return rs.getTimestamp(columnLabel);
	}

	public InputStream getAsciiStream(String columnLabel) throws SQLException {
        logger.info("getAsciiStream " + columnLabel);
		return rs.getAsciiStream(columnLabel);
	}

	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        logger.info("getUnicodeStream " + columnLabel);
		return rs.getUnicodeStream(columnLabel);
	}

	public InputStream getBinaryStream(String columnLabel) throws SQLException {
        logger.info("getBinaryStream " + columnLabel);
		return rs.getBinaryStream(columnLabel);
	}

	public SQLWarning getWarnings() throws SQLException {
        logger.info("getWarnings");
		return rs.getWarnings();
	}

	public void clearWarnings() throws SQLException {
        logger.info("clearWarnings");
		rs.clearWarnings();
	}

	public String getCursorName() throws SQLException {
        logger.info("getCursorName");
		return rs.getCursorName();
	}

	public ResultSetMetaData getMetaData() throws SQLException {
        logger.info("getMetaData for ResultSetMetaData");
		return new LogResultSetMetaData(rs.getMetaData());
	}

	public Object getObject(int columnIndex) throws SQLException {
        logger.info("getObject " + columnIndex);
		return rs.getObject(columnIndex);
	}

	public Object getObject(String columnLabel) throws SQLException {
        logger.info("getObject " + columnLabel);
		return rs.getObject(columnLabel);
	}

	public int findColumn(String columnLabel) throws SQLException {
        logger.info("findColumn " + columnLabel);
		return rs.findColumn(columnLabel);
	}

	public Reader getCharacterStream(int columnIndex) throws SQLException {
        logger.info("getCharacterStream " + columnIndex);
		return rs.getCharacterStream(columnIndex);
	}

	public Reader getCharacterStream(String columnLabel) throws SQLException {
        logger.info("getCharacterStream " + columnLabel);
		return rs.getCharacterStream(columnLabel);
	}

	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        logger.info("getBigDecimal " + columnIndex);
		return rs.getBigDecimal(columnIndex);
	}

	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        logger.info("getBigDecimal " + columnLabel);
		return rs.getBigDecimal(columnLabel);
	}

	public boolean isBeforeFirst() throws SQLException {
        logger.info("isBeforeFirst");
		return rs.isBeforeFirst();
	}

	public boolean isAfterLast() throws SQLException {
        logger.info("isAfterLast");
		return rs.isAfterLast();
	}

	public boolean isFirst() throws SQLException {
        logger.info("isFirst");
		return rs.isFirst();
	}

	public boolean isLast() throws SQLException {
        logger.info("isLast");
		return rs.isLast();
	}

	public void beforeFirst() throws SQLException {
        logger.info("beforeFirst");
		rs.beforeFirst();
	}

	public void afterLast() throws SQLException {
        logger.info("afterLast");
		rs.afterLast();
	}

	public boolean first() throws SQLException {
        logger.info("first");
		return rs.first();
	}

	public boolean last() throws SQLException {
        logger.info("last");
		return rs.last();
	}

	public int getRow() throws SQLException {
        logger.info("getRow");
		return rs.getRow();
	}

	public boolean absolute(int row) throws SQLException {
        logger.info("absolute");
		return rs.absolute(row);
	}

	public boolean relative(int rows) throws SQLException {
        logger.info("relative");
		return rs.relative(rows);
	}

	public boolean previous() throws SQLException {
        logger.info("previous");
		return rs.previous();
	}

	public void setFetchDirection(int direction) throws SQLException {
        logger.info("setFetchDirection");
		rs.setFetchDirection(direction);
	}

	public int getFetchDirection() throws SQLException {
        logger.info("getFetchDirection");
		return rs.getFetchDirection();
	}

	public void setFetchSize(int rows) throws SQLException {
        logger.info("setFetchSize");
		rs.setFetchSize(rows);
	}

	public int getFetchSize() throws SQLException {
        logger.info("getFetchSize");
		return rs.getFetchSize();
	}

	public int getType() throws SQLException {
        logger.info("getType");
		return rs.getType();
	}

	public int getConcurrency() throws SQLException {
        logger.info("getConcurrency");
		return rs.getConcurrency();
	}

	public boolean rowUpdated() throws SQLException {
        logger.info("rowUpdated");
		return rs.rowUpdated();
	}

	public boolean rowInserted() throws SQLException {
        logger.info("rowInserted");
		return rs.rowInserted();
	}

	public boolean rowDeleted() throws SQLException {
        logger.info("rowDeleted");
		return rs.rowDeleted();
	}

	public void updateNull(int columnIndex) throws SQLException {
        logger.info("updateNull");
		rs.updateNull(columnIndex);
	}

	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		rs.updateBoolean(columnIndex, x);
	}

	public void updateByte(int columnIndex, byte x) throws SQLException {
		rs.updateByte(columnIndex, x);
	}

	public void updateShort(int columnIndex, short x) throws SQLException {
		rs.updateShort(columnIndex, x);
	}

	public void updateInt(int columnIndex, int x) throws SQLException {
		rs.updateInt(columnIndex, x);
	}

	public void updateLong(int columnIndex, long x) throws SQLException {
		rs.updateLong(columnIndex, x);
	}

	public void updateFloat(int columnIndex, float x) throws SQLException {
		rs.updateFloat(columnIndex, x);
	}

	public void updateDouble(int columnIndex, double x) throws SQLException {
		rs.updateDouble(columnIndex, x);
	}

	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		rs.updateBigDecimal(columnIndex, x);
	}

	public void updateString(int columnIndex, String x) throws SQLException {
		rs.updateString(columnIndex, x);
	}

	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		rs.updateBytes(columnIndex, x);
	}

	public void updateDate(int columnIndex, Date x) throws SQLException {
		rs.updateDate(columnIndex, x);
	}

	public void updateTime(int columnIndex, Time x) throws SQLException {
		rs.updateTime(columnIndex, x);
	}

	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		rs.updateTimestamp(columnIndex, x);
	}

	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		rs.updateAsciiStream(columnIndex, x, length);
	}

	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		rs.updateBinaryStream(columnIndex, x, length);
	}

	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		rs.updateCharacterStream(columnIndex, x, length);
	}

	public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		rs.updateObject(columnIndex, x, scaleOrLength);
	}

	public void updateObject(int columnIndex, Object x) throws SQLException {
		rs.updateObject(columnIndex, x);
	}

	public void updateNull(String columnLabel) throws SQLException {
		rs.updateNull(columnLabel);
	}

	public void updateBoolean(String columnLabel, boolean x) throws SQLException {
		rs.updateBoolean(columnLabel, x);
	}

	public void updateByte(String columnLabel, byte x) throws SQLException {
		rs.updateByte(columnLabel, x);
	}

	public void updateShort(String columnLabel, short x) throws SQLException {
		rs.updateShort(columnLabel, x);
	}

	public void updateInt(String columnLabel, int x) throws SQLException {
		rs.updateInt(columnLabel, x);
	}

	public void updateLong(String columnLabel, long x) throws SQLException {
		rs.updateLong(columnLabel, x);
	}

	public void updateFloat(String columnLabel, float x) throws SQLException {
		rs.updateFloat(columnLabel, x);
	}

	public void updateDouble(String columnLabel, double x) throws SQLException {
		rs.updateDouble(columnLabel, x);
	}

	public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		rs.updateBigDecimal(columnLabel, x);
	}

	public void updateString(String columnLabel, String x) throws SQLException {
		rs.updateString(columnLabel, x);
	}

	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		rs.updateBytes(columnLabel, x);
	}

	public void updateDate(String columnLabel, Date x) throws SQLException {
		rs.updateDate(columnLabel, x);
	}

	public void updateTime(String columnLabel, Time x) throws SQLException {
		rs.updateTime(columnLabel, x);
	}

	public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		rs.updateTimestamp(columnLabel, x);
	}

	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		rs.updateAsciiStream(columnLabel, x, length);
	}

	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		rs.updateBinaryStream(columnLabel, x, length);
	}

	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		rs.updateCharacterStream(columnLabel, reader, length);
	}

	public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		rs.updateObject(columnLabel, x, scaleOrLength);
	}

	public void updateObject(String columnLabel, Object x) throws SQLException {
		rs.updateObject(columnLabel, x);
	}

	public void insertRow() throws SQLException {
		rs.insertRow();
	}

	public void updateRow() throws SQLException {
		rs.updateRow();
	}

	public void deleteRow() throws SQLException {
		rs.deleteRow();
	}

	public void refreshRow() throws SQLException {
		rs.refreshRow();
	}

	public void cancelRowUpdates() throws SQLException {
		rs.cancelRowUpdates();
	}

	public void moveToInsertRow() throws SQLException {
		rs.moveToInsertRow();
	}

	public void moveToCurrentRow() throws SQLException {
		rs.moveToCurrentRow();
	}

	public Statement getStatement() throws SQLException {
        logger.info("getStatement");
		return rs.getStatement();
	}

	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        logger.info("getObject " + columnIndex + " " + map);
		return rs.getObject(columnIndex, map);
	}

	public Ref getRef(int columnIndex) throws SQLException {
        logger.info("getRef " + columnIndex);
		return rs.getRef(columnIndex);
	}

	public Blob getBlob(int columnIndex) throws SQLException {
        logger.info("getBlob " + columnIndex);
		return rs.getBlob(columnIndex);
	}

	public Clob getClob(int columnIndex) throws SQLException {
        logger.info("getClob " + columnIndex);
		return rs.getClob(columnIndex);
	}

	public Array getArray(int columnIndex) throws SQLException {
        logger.info("getArray " + columnIndex);
		return rs.getArray(columnIndex);
	}

	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        logger.info("getObject " + columnLabel + " " + map);
		return rs.getObject(columnLabel, map);
	}

	public Ref getRef(String columnLabel) throws SQLException {
        logger.info("getRef " + columnLabel);
		return rs.getRef(columnLabel);
	}

	public Blob getBlob(String columnLabel) throws SQLException {
        logger.info("getBlob " + columnLabel);
		return rs.getBlob(columnLabel);
	}

	public Clob getClob(String columnLabel) throws SQLException {
        logger.info("getClob " + columnLabel);
		return rs.getClob(columnLabel);
	}

	public Array getArray(String columnLabel) throws SQLException {
        logger.info("getArray " + columnLabel);
		return rs.getArray(columnLabel);
	}

	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        logger.info("getDate " + columnIndex + " " + cal);
		return rs.getDate(columnIndex, cal);
	}

	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        logger.info("getDate " + columnLabel + " " + cal);
		return rs.getDate(columnLabel, cal);
	}

	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        logger.info("getTime " + columnIndex + " " + cal);
		return rs.getTime(columnIndex, cal);
	}

	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        logger.info("getTime " + columnLabel + " " + cal);
		return rs.getTime(columnLabel, cal);
	}

	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnIndex + " " + cal);
		return rs.getTimestamp(columnIndex, cal);
	}

	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnLabel + " " + cal);
		return rs.getTimestamp(columnLabel, cal);
	}

	public URL getURL(int columnIndex) throws SQLException {
        logger.info("getURL " + columnIndex);
		return rs.getURL(columnIndex);
	}

	public URL getURL(String columnLabel) throws SQLException {
        logger.info("getURL " + columnLabel);
		return rs.getURL(columnLabel);
	}

	public void updateRef(int columnIndex, Ref x) throws SQLException {
		rs.updateRef(columnIndex, x);
	}

	public void updateRef(String columnLabel, Ref x) throws SQLException {
		rs.updateRef(columnLabel, x);
	}

	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		rs.updateBlob(columnIndex, x);
	}

	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		rs.updateBlob(columnLabel, x);
	}

	public void updateClob(int columnIndex, Clob x) throws SQLException {
		rs.updateClob(columnIndex, x);
	}

	public void updateClob(String columnLabel, Clob x) throws SQLException {
		rs.updateClob(columnLabel, x);
	}

	public void updateArray(int columnIndex, Array x) throws SQLException {
		rs.updateArray(columnIndex, x);
	}

	public void updateArray(String columnLabel, Array x) throws SQLException {
		rs.updateArray(columnLabel, x);
	}

	public RowId getRowId(int columnIndex) throws SQLException {
        logger.info("getRowId " + columnIndex);
		return rs.getRowId(columnIndex);
	}

	public RowId getRowId(String columnLabel) throws SQLException {
        logger.info("getRowId " + columnLabel);
		return rs.getRowId(columnLabel);
	}

	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		rs.updateRowId(columnIndex, x);
	}

	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		rs.updateRowId(columnLabel, x);
	}

	public int getHoldability() throws SQLException {
        logger.info("getHoldability");
		return rs.getHoldability();
	}

	public boolean isClosed() throws SQLException {
        logger.info("isClosed");
		return rs.isClosed();
	}

	public void updateNString(int columnIndex, String nString) throws SQLException {
		rs.updateNString(columnIndex, nString);
	}

	public void updateNString(String columnLabel, String nString) throws SQLException {
		rs.updateNString(columnLabel, nString);
	}

	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		rs.updateNClob(columnIndex, nClob);
	}

	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		rs.updateNClob(columnLabel, nClob);
	}

	public NClob getNClob(int columnIndex) throws SQLException {
        logger.info("getNClob " + columnIndex);
		return rs.getNClob(columnIndex);
	}

	public NClob getNClob(String columnLabel) throws SQLException {
        logger.info("getNClob " + columnLabel);
		return rs.getNClob(columnLabel);
	}

	public SQLXML getSQLXML(int columnIndex) throws SQLException {
        logger.info("getSQLXML " + columnIndex);
		return rs.getSQLXML(columnIndex);
	}

	public SQLXML getSQLXML(String columnLabel) throws SQLException {
        logger.info("getSQLXML " + columnLabel);
		return rs.getSQLXML(columnLabel);
	}

	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		rs.updateSQLXML(columnIndex, xmlObject);
	}

	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		rs.updateSQLXML(columnLabel, xmlObject);
	}

	public String getNString(int columnIndex) throws SQLException {
        logger.info("getNString " + columnIndex);
		return rs.getNString(columnIndex);
	}

	public String getNString(String columnLabel) throws SQLException {
        logger.info("getNString " + columnLabel);
		return rs.getNString(columnLabel);
	}

	public Reader getNCharacterStream(int columnIndex) throws SQLException {
        logger.info("getNCharacterStream " + columnIndex);
		return rs.getNCharacterStream(columnIndex);
	}

	public Reader getNCharacterStream(String columnLabel) throws SQLException {
        logger.info("getNCharacterStream " + columnLabel);
		return rs.getNCharacterStream(columnLabel);
	}

	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		rs.updateNCharacterStream(columnIndex, x, length);
	}

	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		rs.updateNCharacterStream(columnLabel, reader, length);
	}

	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		rs.updateAsciiStream(columnIndex, x, length);
	}

	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		rs.updateBinaryStream(columnIndex, x, length);
	}

	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		rs.updateCharacterStream(columnIndex, x, length);
	}

	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		rs.updateAsciiStream(columnLabel, x, length);
	}

	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		rs.updateBinaryStream(columnLabel, x, length);
	}

	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		rs.updateCharacterStream(columnLabel, reader, length);
	}

	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		rs.updateBlob(columnIndex, inputStream, length);
	}

	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		rs.updateBlob(columnLabel, inputStream, length);
	}

	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		rs.updateClob(columnIndex, reader, length);
	}

	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		rs.updateClob(columnLabel, reader, length);
	}

	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		rs.updateNClob(columnIndex, reader, length);
	}

	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		rs.updateNClob(columnLabel, reader, length);
	}

	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		rs.updateNCharacterStream(columnIndex, x);
	}

	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		rs.updateNCharacterStream(columnLabel, reader);
	}

	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		rs.updateAsciiStream(columnIndex, x);
	}

	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		rs.updateBinaryStream(columnIndex, x);
	}

	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		rs.updateCharacterStream(columnIndex, x);
	}

	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		rs.updateAsciiStream(columnLabel, x);
	}

	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		rs.updateBinaryStream(columnLabel, x);
	}

	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		rs.updateCharacterStream(columnLabel, reader);
	}

	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		rs.updateBlob(columnIndex, inputStream);
	}

	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		rs.updateBlob(columnLabel, inputStream);
	}

	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		rs.updateClob(columnIndex, reader);
	}

	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		rs.updateClob(columnLabel, reader);
	}

	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		rs.updateNClob(columnIndex, reader);
	}

	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		rs.updateNClob(columnLabel, reader);
	}

	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        logger.info("getObject " + columnIndex + " type:" + type);
		return rs.getObject(columnIndex, type);
	}

	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        logger.info("getObject " + columnLabel + " type:" + type);
		return rs.getObject(columnLabel, type);
	}

	public void updateObject(int columnIndex, Object x, SQLType targetSqlType, int scaleOrLength) throws SQLException {
		rs.updateObject(columnIndex, x, targetSqlType, scaleOrLength);
	}

	public void updateObject(String columnLabel, Object x, SQLType targetSqlType, int scaleOrLength)
			throws SQLException {
		rs.updateObject(columnLabel, x, targetSqlType, scaleOrLength);
	}

	public void updateObject(int columnIndex, Object x, SQLType targetSqlType) throws SQLException {
		rs.updateObject(columnIndex, x, targetSqlType);
	}

	public void updateObject(String columnLabel, Object x, SQLType targetSqlType) throws SQLException {
		rs.updateObject(columnLabel, x, targetSqlType);
	}	
}
