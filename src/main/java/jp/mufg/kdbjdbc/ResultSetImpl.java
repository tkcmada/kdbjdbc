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
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class ResultSetImpl implements ResultSet {
	private static final Logger logger = FileLogger.getLogger(ResultSetImpl.class);
	private final ResultSetMetaData meta;
	private final List<Object[]> rows;
    private int cursor = -1;
    private boolean wasnull = false;

	public ResultSetImpl(ResultSetMetaData meta, List<Object[]> rows) {
		super();
		this.meta = meta;
		this.rows = rows;
	}

	public ResultSetImpl(ResultSetMetaData meta) {
		super();
		this.meta = meta;
		this.rows = new LinkedList<Object[]>();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new SQLException("ResultSetImpl.unwrap is not supported");
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new SQLException("ResultSetImpl.isWrapperFor is not supported");
		
	}

	@Override
	public boolean next() throws SQLException {
        // logger.info("next cursor=" + cursor + " size=" + rows.size());
		if(cursor >= rows.size())
			return false;
		cursor++;
		return cursor < rows.size();
	}

	@Override
	public void close() throws SQLException {
		//do nothing
	}

	@Override
	public boolean wasNull() throws SQLException {
        return wasnull;
	}

	@Override
	public String getString(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
		return val == null ? null : val.toString();
	}

	@Override
	public boolean getBoolean(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
		return val == null ? false : val.toString().equals("true");
	}

	@Override
	public byte getByte(int columnIndex) throws SQLException {
        Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).byteValue();		
	}

	@Override
	public short getShort(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).shortValue();		
	}

	@Override
	public int getInt(int columnIndex) throws SQLException {
        Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).intValue();		
	}

	@Override
	public long getLong(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).longValue();		
	}

	@Override
	public float getFloat(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).floatValue();		
	}

	@Override
	public double getDouble(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).doubleValue();				
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
		Object val = getObject(columnIndex);
		return (BigDecimal)val;	
	}

	@Override
	public byte[] getBytes(int columnIndex) throws SQLException {
		logger.info("getBytes");
		throw new SQLException("ResultSetImpl.getBytes is not supported");
		
	}

	@Override
	public Date getDate(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
		return (Date)val;	
	}

	@Override
	public Time getTime(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
		return (Time)val;	
	}

	@Override
	public Timestamp getTimestamp(int columnIndex) throws SQLException {
		Object val = getObject(columnIndex);
		return (Timestamp)val;	
	}

	@Override
	public InputStream getAsciiStream(int columnIndex) throws SQLException {
		logger.info("getAsciiStream");
		throw new SQLException("ResultSetImpl.getAsciiStream is not supported");
		
	}

	@Override
	public InputStream getUnicodeStream(int columnIndex) throws SQLException {
		logger.info("getUnicodeStream");
		throw new SQLException("ResultSetImpl.getUnicodeStream is not supported");
		
	}

	@Override
	public InputStream getBinaryStream(int columnIndex) throws SQLException {
		logger.info("getBinaryStream");
		throw new SQLException("ResultSetImpl.getBinaryStream is not supported");
		
	}

	@Override
	public String getString(String columnLabel) throws SQLException {
		return getString(findColumn(columnLabel));
	}

	@Override
	public boolean getBoolean(String columnLabel) throws SQLException {
		return getBoolean(findColumn(columnLabel));		
	}

	@Override
	public byte getByte(String columnLabel) throws SQLException {
		return getByte(findColumn(columnLabel));
	}

	@Override
	public short getShort(String columnLabel) throws SQLException {
		return getShort(findColumn(columnLabel));
	}

	@Override
	public int getInt(String columnLabel) throws SQLException {
		return getInt(findColumn(columnLabel));
	}

	@Override
	public long getLong(String columnLabel) throws SQLException {
		return getLong(findColumn(columnLabel));		
	}

	@Override
	public float getFloat(String columnLabel) throws SQLException {
		return getFloat(findColumn(columnLabel));		
	}

	@Override
	public double getDouble(String columnLabel) throws SQLException {
		return getDouble(findColumn(columnLabel));		
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
		return getBigDecimal(findColumn(columnLabel));		
	}

	@Override
	public byte[] getBytes(String columnLabel) throws SQLException {
		logger.info("getBytes");
		throw new SQLException("ResultSetImpl.getBytes is not supported");
		
	}

	@Override
	public Date getDate(String columnLabel) throws SQLException {
		return getDate(findColumn(columnLabel));				
	}

	@Override
	public Time getTime(String columnLabel) throws SQLException {
		return getTime(findColumn(columnLabel));				
	}

	@Override
	public Timestamp getTimestamp(String columnLabel) throws SQLException {
		return getTimestamp(findColumn(columnLabel));				
	}

	@Override
	public InputStream getAsciiStream(String columnLabel) throws SQLException {
		logger.info("getAsciiStream");
		throw new SQLException("ResultSetImpl.getAsciiStream is not supported");
		
	}

	@Override
	public InputStream getUnicodeStream(String columnLabel) throws SQLException {
		logger.info("getUnicodeStream");
		throw new SQLException("ResultSetImpl.getUnicodeStream is not supported");
		
	}

	@Override
	public InputStream getBinaryStream(String columnLabel) throws SQLException {
		logger.info("getBinaryStream");
		throw new SQLException("ResultSetImpl.getBinaryStream is not supported");
		
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		logger.info("getWarnings");
		throw new SQLException("ResultSetImpl.getWarnings is not supported");
		
	}

	@Override
	public void clearWarnings() throws SQLException {
		logger.info("clearWarnings");
		throw new SQLException("ResultSetImpl.clearWarnings is not supported");
		
	}

	@Override
	public String getCursorName() throws SQLException {
		logger.info("getCursorName");
		throw new SQLException("ResultSetImpl.getCursorName is not supported");
		
	}

	@Override
	public ResultSetMetaData getMetaData() throws SQLException {
		return meta;
	}

	@Override
	public Object getObject(int columnIndex) throws SQLException {
        Object val = rows.get(cursor)[columnIndex-1];
        wasnull = val == null;
        return val;
	}

	@Override
	public Object getObject(String columnLabel) throws SQLException {
		return getObject(findColumn(columnLabel));
	}

	@Override
	public int findColumn(String columnLabel) throws SQLException {
		for(int i = 1; i <= meta.getColumnCount(); i++) {
			if(meta.getColumnName(i).equals(columnLabel))
				return i;
		}
		throw new SQLException("No column is found. " + columnLabel);		
	}

	@Override
	public Reader getCharacterStream(int columnIndex) throws SQLException {
		logger.info("getCharacterStream");
		throw new SQLException("ResultSetImpl.getCharacterStream is not supported");
		
	}

	@Override
	public Reader getCharacterStream(String columnLabel) throws SQLException {
		logger.info("getCharacterStream");
		throw new SQLException("ResultSetImpl.getCharacterStream is not supported");
		
	}

	@Override
	public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
		return (BigDecimal)getObject(columnIndex);
	}

	@Override
	public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
		return getBigDecimal(findColumn(columnLabel));		
	}

	@Override
	public boolean isBeforeFirst() throws SQLException {
		logger.info("isBeforeFirst");
		throw new SQLException("ResultSetImpl.isBeforeFirst is not supported");
		
	}

	@Override
	public boolean isAfterLast() throws SQLException {
		logger.info("isAfterLast");
		throw new SQLException("ResultSetImpl.isAfterLast is not supported");
		
	}

	@Override
	public boolean isFirst() throws SQLException {
		logger.info("isFirst");
		throw new SQLException("ResultSetImpl.isFirst is not supported");
		
	}

	@Override
	public boolean isLast() throws SQLException {
		logger.info("isLast");
		throw new SQLException("ResultSetImpl.isLast is not supported");
		
	}

	@Override
	public void beforeFirst() throws SQLException {
		logger.info("beforeFirst");
		throw new SQLException("ResultSetImpl.beforeFirst is not supported");
		
	}

	@Override
	public void afterLast() throws SQLException {
		logger.info("afterLast");
		throw new SQLException("ResultSetImpl.afterLast is not supported");
		
	}

	@Override
	public boolean first() throws SQLException {
		logger.info("first");
		throw new SQLException("ResultSetImpl.first is not supported");
		
	}

	@Override
	public boolean last() throws SQLException {
		logger.info("last");
		throw new SQLException("ResultSetImpl.last is not supported");
		
	}

	@Override
	public int getRow() throws SQLException {
		logger.info("getRow");
		throw new SQLException("ResultSetImpl.getRow is not supported");
		
	}

	@Override
	public boolean absolute(int row) throws SQLException {
		logger.info("absolute");
		throw new SQLException("ResultSetImpl.absolute is not supported");
		
	}

	@Override
	public boolean relative(int rows) throws SQLException {
		logger.info("relative");
		throw new SQLException("ResultSetImpl.relative is not supported");
		
	}

	@Override
	public boolean previous() throws SQLException {
		logger.info("previous");
		throw new SQLException("ResultSetImpl.previous is not supported");
		
	}

	@Override
	public void setFetchDirection(int direction) throws SQLException {
		logger.info("setFetchDirection");
		throw new SQLException("ResultSetImpl.setFetchDirection is not supported");
		
	}

	@Override
	public int getFetchDirection() throws SQLException {
		logger.info("getFetchDirection");
		throw new SQLException("ResultSetImpl.getFetchDirection is not supported");
		
	}

	@Override
	public void setFetchSize(int rows) throws SQLException {
		logger.info("setFetchSize");
		throw new SQLException("ResultSetImpl.setFetchSize is not supported");
		
	}

	@Override
	public int getFetchSize() throws SQLException {
		logger.info("getFetchSize");
		throw new SQLException("ResultSetImpl.getFetchSize is not supported");
		
	}

	@Override
	public int getType() throws SQLException {
		logger.info("getType");
		throw new SQLException("ResultSetImpl.getType is not supported");
		
	}

	@Override
	public int getConcurrency() throws SQLException {
		logger.info("getConcurrency");
		throw new SQLException("ResultSetImpl.getConcurrency is not supported");
		
	}

	@Override
	public boolean rowUpdated() throws SQLException {
		logger.info("rowUpdated");
		throw new SQLException("ResultSetImpl.rowUpdated is not supported");
		
	}

	@Override
	public boolean rowInserted() throws SQLException {
		logger.info("rowInserted");
		throw new SQLException("ResultSetImpl.rowInserted is not supported");
		
	}

	@Override
	public boolean rowDeleted() throws SQLException {
		logger.info("rowDeleted");
		throw new SQLException("ResultSetImpl.rowDeleted is not supported");
		
	}

	@Override
	public void updateNull(int columnIndex) throws SQLException {
		logger.info("updateNull");
		throw new SQLException("ResultSetImpl.updateNull is not supported");
		
	}

	@Override
	public void updateBoolean(int columnIndex, boolean x) throws SQLException {
		logger.info("updateBoolean");
		throw new SQLException("ResultSetImpl.updateBoolean is not supported");
		
	}

	@Override
	public void updateByte(int columnIndex, byte x) throws SQLException {
		logger.info("updateByte");
		throw new SQLException("ResultSetImpl.updateByte is not supported");
		
	}

	@Override
	public void updateShort(int columnIndex, short x) throws SQLException {
		logger.info("updateShort");
		throw new SQLException("ResultSetImpl.updateShort is not supported");
		
	}

	@Override
	public void updateInt(int columnIndex, int x) throws SQLException {
		logger.info("updateInt");
		throw new SQLException("ResultSetImpl.updateInt is not supported");
		
	}

	@Override
	public void updateLong(int columnIndex, long x) throws SQLException {
		logger.info("updateLong");
		throw new SQLException("ResultSetImpl.updateLong is not supported");
		
	}

	@Override
	public void updateFloat(int columnIndex, float x) throws SQLException {
		logger.info("updateFloat");
		throw new SQLException("ResultSetImpl.updateFloat is not supported");
		
	}

	@Override
	public void updateDouble(int columnIndex, double x) throws SQLException {
		logger.info("updateDouble");
		throw new SQLException("ResultSetImpl.updateDouble is not supported");
		
	}

	@Override
	public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
		logger.info("updateBigDecimal");
		throw new SQLException("ResultSetImpl.updateBigDecimal is not supported");
		
	}

	@Override
	public void updateString(int columnIndex, String x) throws SQLException {
		logger.info("updateString");
		throw new SQLException("ResultSetImpl.updateString is not supported");
		
	}

	@Override
	public void updateBytes(int columnIndex, byte[] x) throws SQLException {
		logger.info("updateBytes");
		throw new SQLException("ResultSetImpl.updateBytes is not supported");
		
	}

	@Override
	public void updateDate(int columnIndex, Date x) throws SQLException {
		logger.info("updateDate");
		throw new SQLException("ResultSetImpl.updateDate is not supported");
		
	}

	@Override
	public void updateTime(int columnIndex, Time x) throws SQLException {
		logger.info("updateTime");
		throw new SQLException("ResultSetImpl.updateTime is not supported");
		
	}

	@Override
	public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
		logger.info("updateTimestamp");
		throw new SQLException("ResultSetImpl.updateTimestamp is not supported");
		
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public void updateObject(int columnIndex, Object x) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public void updateNull(String columnLabel) throws SQLException {
		logger.info("updateNull");
		throw new SQLException("ResultSetImpl.updateNull is not supported");
		
	}

	@Override
	public void updateBoolean(String columnLabel, boolean x) throws SQLException {
		logger.info("updateBoolean");
		throw new SQLException("ResultSetImpl.updateBoolean is not supported");
		
	}

	@Override
	public void updateByte(String columnLabel, byte x) throws SQLException {
		logger.info("updateByte");
		throw new SQLException("ResultSetImpl.updateByte is not supported");
		
	}

	@Override
	public void updateShort(String columnLabel, short x) throws SQLException {
		logger.info("updateShort");
		throw new SQLException("ResultSetImpl.updateShort is not supported");
		
	}

	@Override
	public void updateInt(String columnLabel, int x) throws SQLException {
		logger.info("updateInt");
		throw new SQLException("ResultSetImpl.updateInt is not supported");
		
	}

	@Override
	public void updateLong(String columnLabel, long x) throws SQLException {
		logger.info("updateLong");
		throw new SQLException("ResultSetImpl.updateLong is not supported");
		
	}

	@Override
	public void updateFloat(String columnLabel, float x) throws SQLException {
		logger.info("updateFloat");
		throw new SQLException("ResultSetImpl.updateFloat is not supported");
		
	}

	@Override
	public void updateDouble(String columnLabel, double x) throws SQLException {
		logger.info("updateDouble");
		throw new SQLException("ResultSetImpl.updateDouble is not supported");
		
	}

	@Override
	public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
		logger.info("updateBigDecimal");
		throw new SQLException("ResultSetImpl.updateBigDecimal is not supported");
		
	}

	@Override
	public void updateString(String columnLabel, String x) throws SQLException {
		logger.info("updateString");
		throw new SQLException("ResultSetImpl.updateString is not supported");
		
	}

	@Override
	public void updateBytes(String columnLabel, byte[] x) throws SQLException {
		logger.info("updateBytes");
		throw new SQLException("ResultSetImpl.updateBytes is not supported");
		
	}

	@Override
	public void updateDate(String columnLabel, Date x) throws SQLException {
		logger.info("updateDate");
		throw new SQLException("ResultSetImpl.updateDate is not supported");
		
	}

	@Override
	public void updateTime(String columnLabel, Time x) throws SQLException {
		logger.info("updateTime");
		throw new SQLException("ResultSetImpl.updateTime is not supported");
		
	}

	@Override
	public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
		logger.info("updateTimestamp");
		throw new SQLException("ResultSetImpl.updateTimestamp is not supported");
		
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public void updateObject(String columnLabel, Object x) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public void insertRow() throws SQLException {
		logger.info("insertRow");
		throw new SQLException("ResultSetImpl.insertRow is not supported");
		
	}

	@Override
	public void updateRow() throws SQLException {
		logger.info("updateRow");
		throw new SQLException("ResultSetImpl.updateRow is not supported");
		
	}

	@Override
	public void deleteRow() throws SQLException {
		logger.info("deleteRow");
		throw new SQLException("ResultSetImpl.deleteRow is not supported");
		
	}

	@Override
	public void refreshRow() throws SQLException {
		logger.info("refreshRow");
		throw new SQLException("ResultSetImpl.refreshRow is not supported");
		
	}

	@Override
	public void cancelRowUpdates() throws SQLException {
		logger.info("cancelRowUpdates");
		throw new SQLException("ResultSetImpl.cancelRowUpdates is not supported");
		
	}

	@Override
	public void moveToInsertRow() throws SQLException {
		logger.info("moveToInsertRow");
		throw new SQLException("ResultSetImpl.moveToInsertRow is not supported");
		
	}

	@Override
	public void moveToCurrentRow() throws SQLException {
		logger.info("moveToCurrentRow");
		throw new SQLException("ResultSetImpl.moveToCurrentRow is not supported");
		
	}

	@Override
	public Statement getStatement() throws SQLException {
		logger.info("getStatement");
		throw new SQLException("ResultSetImpl.getStatement is not supported");
		
	}

	@Override
	public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public Ref getRef(int columnIndex) throws SQLException {
		logger.info("getRef");
		throw new SQLException("ResultSetImpl.getRef is not supported");
		
	}

	@Override
	public Blob getBlob(int columnIndex) throws SQLException {
		logger.info("getBlob");
		throw new SQLException("ResultSetImpl.getBlob is not supported");
		
	}

	@Override
	public Clob getClob(int columnIndex) throws SQLException {
		logger.info("getClob");
		throw new SQLException("ResultSetImpl.getClob is not supported");
		
	}

	@Override
	public Array getArray(int columnIndex) throws SQLException {
		logger.info("getArray");
		throw new SQLException("ResultSetImpl.getArray is not supported");
		
	}

	@Override
	public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public Ref getRef(String columnLabel) throws SQLException {
		logger.info("getRef");
		throw new SQLException("ResultSetImpl.getRef is not supported");
		
	}

	@Override
	public Blob getBlob(String columnLabel) throws SQLException {
		logger.info("getBlob");
		throw new SQLException("ResultSetImpl.getBlob is not supported");
		
	}

	@Override
	public Clob getClob(String columnLabel) throws SQLException {
		logger.info("getClob");
		throw new SQLException("ResultSetImpl.getClob is not supported");
		
	}

	@Override
	public Array getArray(String columnLabel) throws SQLException {
		logger.info("getArray");
		throw new SQLException("ResultSetImpl.getArray is not supported");
		
	}

	@Override
	public Date getDate(int columnIndex, Calendar cal) throws SQLException {
		logger.info("getDate");
		throw new SQLException("ResultSetImpl.getDate is not supported");
		
	}

	@Override
	public Date getDate(String columnLabel, Calendar cal) throws SQLException {
		logger.info("getDate");
		throw new SQLException("ResultSetImpl.getDate is not supported");
		
	}

	@Override
	public Time getTime(int columnIndex, Calendar cal) throws SQLException {
		logger.info("getTime");
		throw new SQLException("ResultSetImpl.getTime is not supported");
		
	}

	@Override
	public Time getTime(String columnLabel, Calendar cal) throws SQLException {
		logger.info("getTime");
		throw new SQLException("ResultSetImpl.getTime is not supported");
		
	}

	@Override
	public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnIndex + " calendar=" + cal);
        return (Timestamp) getObject(columnIndex);
	}

	@Override
	public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnLabel + " calendar=" + cal);
        return (Timestamp) getObject(columnLabel);
	}

	@Override
	public URL getURL(int columnIndex) throws SQLException {
		logger.info("getURL");
		throw new SQLException("ResultSetImpl.getURL is not supported");
		
	}

	@Override
	public URL getURL(String columnLabel) throws SQLException {
		logger.info("getURL");
		throw new SQLException("ResultSetImpl.getURL is not supported");
		
	}

	@Override
	public void updateRef(int columnIndex, Ref x) throws SQLException {
		logger.info("updateRef");
		throw new SQLException("ResultSetImpl.updateRef is not supported");
		
	}

	@Override
	public void updateRef(String columnLabel, Ref x) throws SQLException {
		logger.info("updateRef");
		throw new SQLException("ResultSetImpl.updateRef is not supported");
		
	}

	@Override
	public void updateBlob(int columnIndex, Blob x) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateBlob(String columnLabel, Blob x) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateClob(int columnIndex, Clob x) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateClob(String columnLabel, Clob x) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateArray(int columnIndex, Array x) throws SQLException {
		logger.info("updateArray");
		throw new SQLException("ResultSetImpl.updateArray is not supported");
		
	}

	@Override
	public void updateArray(String columnLabel, Array x) throws SQLException {
		logger.info("updateArray");
		throw new SQLException("ResultSetImpl.updateArray is not supported");
		
	}

	@Override
	public RowId getRowId(int columnIndex) throws SQLException {
		logger.info("getRowId");
		throw new SQLException("ResultSetImpl.getRowId is not supported");
		
	}

	@Override
	public RowId getRowId(String columnLabel) throws SQLException {
		logger.info("getRowId");
		throw new SQLException("ResultSetImpl.getRowId is not supported");
		
	}

	@Override
	public void updateRowId(int columnIndex, RowId x) throws SQLException {
		logger.info("updateRowId");
		throw new SQLException("ResultSetImpl.updateRowId is not supported");
		
	}

	@Override
	public void updateRowId(String columnLabel, RowId x) throws SQLException {
		logger.info("updateRowId");
		throw new SQLException("ResultSetImpl.updateRowId is not supported");
		
	}

	@Override
	public int getHoldability() throws SQLException {
		logger.info("getHoldability");
		throw new SQLException("ResultSetImpl.getHoldability is not supported");
		
	}

	@Override
	public boolean isClosed() throws SQLException {
		logger.info("isClosed");
		throw new SQLException("ResultSetImpl.isClosed is not supported");
		
	}

	@Override
	public void updateNString(int columnIndex, String nString) throws SQLException {
		logger.info("updateNString");
		throw new SQLException("ResultSetImpl.updateNString is not supported");
		
	}

	@Override
	public void updateNString(String columnLabel, String nString) throws SQLException {
		logger.info("updateNString");
		throw new SQLException("ResultSetImpl.updateNString is not supported");
		
	}

	@Override
	public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public NClob getNClob(int columnIndex) throws SQLException {
		logger.info("getNClob");
		throw new SQLException("ResultSetImpl.getNClob is not supported");
		
	}

	@Override
	public NClob getNClob(String columnLabel) throws SQLException {
		logger.info("getNClob");
		throw new SQLException("ResultSetImpl.getNClob is not supported");
		
	}

	@Override
	public SQLXML getSQLXML(int columnIndex) throws SQLException {
		logger.info("getSQLXML");
		throw new SQLException("ResultSetImpl.getSQLXML is not supported");
		
	}

	@Override
	public SQLXML getSQLXML(String columnLabel) throws SQLException {
		logger.info("getSQLXML");
		throw new SQLException("ResultSetImpl.getSQLXML is not supported");
		
	}

	@Override
	public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
		logger.info("updateSQLXML");
		throw new SQLException("ResultSetImpl.updateSQLXML is not supported");
		
	}

	@Override
	public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
		logger.info("updateSQLXML");
		throw new SQLException("ResultSetImpl.updateSQLXML is not supported");
		
	}

	@Override
	public String getNString(int columnIndex) throws SQLException {
		logger.info("getNString");
		throw new SQLException("ResultSetImpl.getNString is not supported");
		
	}

	@Override
	public String getNString(String columnLabel) throws SQLException {
		logger.info("getNString");
		throw new SQLException("ResultSetImpl.getNString is not supported");
		
	}

	@Override
	public Reader getNCharacterStream(int columnIndex) throws SQLException {
		logger.info("getNCharacterStream");
		throw new SQLException("ResultSetImpl.getNCharacterStream is not supported");
		
	}

	@Override
	public Reader getNCharacterStream(String columnLabel) throws SQLException {
		logger.info("getNCharacterStream");
		throw new SQLException("ResultSetImpl.getNCharacterStream is not supported");
		
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public void updateClob(int columnIndex, Reader reader) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateClob(String columnLabel, Reader reader) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public void updateNClob(int columnIndex, Reader reader) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public void updateNClob(String columnLabel, Reader reader) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}
}
