package jp.mufg.kdbjdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public abstract class ResultSetBase implements ResultSet {
	private static final Logger logger = FileLogger.getLogger(ResultSetBase.class);

    private final ResultSetMetaData meta;
    private final Map<String, Integer> label2index;
    private boolean wasnull = false;

    protected ResultSetBase(final ResultSetMetaData meta) throws SQLException {
        this.meta = meta;
        final int n = meta.getColumnCount();
        this.label2index = new HashMap<String, Integer>(n);
		for(int i = 1; i <= n; i++) {
            label2index.put(meta.getColumnName(i), i);
		}
    }

	public abstract Object getObjectImpl(int columnIndex) throws SQLException;

	@Override
	public final <T> T unwrap(final Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new SQLException("ResultSetImpl.unwrap is not supported");
		
	}

	@Override
	public final boolean isWrapperFor(final Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new SQLException("ResultSetImpl.isWrapperFor is not supported");
		
	}

	@Override
	public final boolean wasNull() throws SQLException {
        return wasnull;
	}

	@Override
	public final String getString(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
		return val == null ? null : val.toString();
	}

	@Override
	public final boolean getBoolean(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
		return val == null ? false : val.toString().equals("true");
	}

	@Override
	public final byte getByte(final int columnIndex) throws SQLException {
        final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).byteValue();		
	}

	@Override
	public final short getShort(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).shortValue();		
	}

	@Override
	public final int getInt(final int columnIndex) throws SQLException {
        final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).intValue();		
	}

	@Override
	public final long getLong(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).longValue();		
	}

	@Override
	public final float getFloat(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).floatValue();		
	}

	@Override
	public final double getDouble(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
        if(val == null)
            return 0;
		return ((Number)val).doubleValue();				
	}

	@Override
	public final BigDecimal getBigDecimal(final int columnIndex, final int scale) throws SQLException {
		final Object val = getObject(columnIndex);
		return (BigDecimal)val;	
	}

	@Override
	public final byte[] getBytes(final int columnIndex) throws SQLException {
		logger.info("getBytes");
		throw new SQLException("ResultSetImpl.getBytes is not supported");
		
	}

	@Override
	public final Date getDate(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
		return (Date)val;	
	}

	@Override
	public final Time getTime(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
		return (Time)val;	
	}

	@Override
	public final Timestamp getTimestamp(final int columnIndex) throws SQLException {
		final Object val = getObject(columnIndex);
		return (Timestamp)val;	
	}

	@Override
	public final InputStream getAsciiStream(final int columnIndex) throws SQLException {
		logger.info("getAsciiStream");
		throw new SQLException("ResultSetImpl.getAsciiStream is not supported");
		
	}

	@Override
	public final InputStream getUnicodeStream(final int columnIndex) throws SQLException {
		logger.info("getUnicodeStream");
		throw new SQLException("ResultSetImpl.getUnicodeStream is not supported");
		
	}

	@Override
	public final InputStream getBinaryStream(final int columnIndex) throws SQLException {
		logger.info("getBinaryStream");
		throw new SQLException("ResultSetImpl.getBinaryStream is not supported");
		
	}

	@Override
	public final String getString(final String columnLabel) throws SQLException {
		return getString(findColumn(columnLabel));
	}

	@Override
	public final boolean getBoolean(final String columnLabel) throws SQLException {
		return getBoolean(findColumn(columnLabel));		
	}

	@Override
	public final byte getByte(final String columnLabel) throws SQLException {
		return getByte(findColumn(columnLabel));
	}

	@Override
	public final short getShort(final String columnLabel) throws SQLException {
		return getShort(findColumn(columnLabel));
	}

	@Override
	public final int getInt(final String columnLabel) throws SQLException {
		return getInt(findColumn(columnLabel));
	}

	@Override
	public final long getLong(final String columnLabel) throws SQLException {
		return getLong(findColumn(columnLabel));		
	}

	@Override
	public final float getFloat(final String columnLabel) throws SQLException {
		return getFloat(findColumn(columnLabel));		
	}

	@Override
	public final double getDouble(final String columnLabel) throws SQLException {
		return getDouble(findColumn(columnLabel));		
	}

	@Override
	public final BigDecimal getBigDecimal(final String columnLabel, final int scale) throws SQLException {
		return getBigDecimal(findColumn(columnLabel));		
	}

	@Override
	public final byte[] getBytes(final String columnLabel) throws SQLException {
		logger.info("getBytes");
		throw new SQLException("ResultSetImpl.getBytes is not supported");
		
	}

	@Override
	public final Date getDate(final String columnLabel) throws SQLException {
		return getDate(findColumn(columnLabel));				
	}

	@Override
	public final Time getTime(final String columnLabel) throws SQLException {
		return getTime(findColumn(columnLabel));				
	}

	@Override
	public final Timestamp getTimestamp(final String columnLabel) throws SQLException {
		return getTimestamp(findColumn(columnLabel));				
	}

	@Override
	public final InputStream getAsciiStream(final String columnLabel) throws SQLException {
		logger.info("getAsciiStream");
		throw new SQLException("ResultSetImpl.getAsciiStream is not supported");
		
	}

	@Override
	public final InputStream getUnicodeStream(final String columnLabel) throws SQLException {
		logger.info("getUnicodeStream");
		throw new SQLException("ResultSetImpl.getUnicodeStream is not supported");
		
	}

	@Override
	public final InputStream getBinaryStream(final String columnLabel) throws SQLException {
		logger.info("getBinaryStream");
		throw new SQLException("ResultSetImpl.getBinaryStream is not supported");
		
	}

	@Override
	public final SQLWarning getWarnings() throws SQLException {
		logger.info("getWarnings");
		throw new SQLException("ResultSetImpl.getWarnings is not supported");
		
	}

	@Override
	public final void clearWarnings() throws SQLException {
		logger.info("clearWarnings");
		throw new SQLException("ResultSetImpl.clearWarnings is not supported");
		
	}

	@Override
	public final String getCursorName() throws SQLException {
		logger.info("getCursorName");
		throw new SQLException("ResultSetImpl.getCursorName is not supported");
		
	}

	@Override
	public final ResultSetMetaData getMetaData() throws SQLException {
		return meta;
	}

	@Override
	public final Object getObject(int columnIndex) throws SQLException {
        Object val = getObjectImpl(columnIndex);
        wasnull = val == null;
        return val;
	}

	@Override
	public final Object getObject(final String columnLabel) throws SQLException {
		return getObject(findColumn(columnLabel));
	}

	@Override
	public final int findColumn(final String columnLabel) throws SQLException {
        final Integer idx = label2index.get(columnLabel);
        if(idx == null)
            throw new SQLException("No column is found. " + columnLabel);		
        return idx;
	}

	@Override
	public final Reader getCharacterStream(final int columnIndex) throws SQLException {
		logger.info("getCharacterStream");
		throw new SQLException("ResultSetImpl.getCharacterStream is not supported");
		
	}

	@Override
	public final Reader getCharacterStream(final String columnLabel) throws SQLException {
		logger.info("getCharacterStream");
		throw new SQLException("ResultSetImpl.getCharacterStream is not supported");
		
	}

	@Override
	public final BigDecimal getBigDecimal(final int columnIndex) throws SQLException {
		return (BigDecimal)getObject(columnIndex);
	}

	@Override
	public final BigDecimal getBigDecimal(final String columnLabel) throws SQLException {
		return getBigDecimal(findColumn(columnLabel));		
	}

	@Override
	public final boolean isBeforeFirst() throws SQLException {
		logger.info("isBeforeFirst");
		throw new SQLException("ResultSetImpl.isBeforeFirst is not supported");
		
	}

	@Override
	public final boolean isAfterLast() throws SQLException {
		logger.info("isAfterLast");
		throw new SQLException("ResultSetImpl.isAfterLast is not supported");
		
	}

	@Override
	public final boolean isFirst() throws SQLException {
		logger.info("isFirst");
		throw new SQLException("ResultSetImpl.isFirst is not supported");
		
	}

	@Override
	public final boolean isLast() throws SQLException {
		logger.info("isLast");
		throw new SQLException("ResultSetImpl.isLast is not supported");
		
	}

	@Override
	public final void beforeFirst() throws SQLException {
		logger.info("beforeFirst");
		throw new SQLException("ResultSetImpl.beforeFirst is not supported");
		
	}

	@Override
	public final void afterLast() throws SQLException {
		logger.info("afterLast");
		throw new SQLException("ResultSetImpl.afterLast is not supported");
		
	}

	@Override
	public final boolean first() throws SQLException {
		logger.info("first");
		throw new SQLException("ResultSetImpl.first is not supported");
		
	}

	@Override
	public final boolean last() throws SQLException {
		logger.info("last");
		throw new SQLException("ResultSetImpl.last is not supported");
		
	}

	@Override
	public final int getRow() throws SQLException {
		logger.info("getRow");
		throw new SQLException("ResultSetImpl.getRow is not supported");
		
	}

	@Override
	public final boolean absolute(final int row) throws SQLException {
		logger.info("absolute");
		throw new SQLException("ResultSetImpl.absolute is not supported");
		
	}

	@Override
	public final boolean relative(final int rows) throws SQLException {
		logger.info("relative");
		throw new SQLException("ResultSetImpl.relative is not supported");
		
	}

	@Override
	public final boolean previous() throws SQLException {
		logger.info("previous");
		throw new SQLException("ResultSetImpl.previous is not supported");
		
	}

	@Override
	public final void setFetchDirection(final int direction) throws SQLException {
		logger.info("setFetchDirection");
		throw new SQLException("ResultSetImpl.setFetchDirection is not supported");
		
	}

	@Override
	public final int getFetchDirection() throws SQLException {
		logger.info("getFetchDirection");
		throw new SQLException("ResultSetImpl.getFetchDirection is not supported");
		
	}

	@Override
	public final void setFetchSize(final int rows) throws SQLException {
		logger.info("setFetchSize");
		throw new SQLException("ResultSetImpl.setFetchSize is not supported");
		
	}

	@Override
	public final int getFetchSize() throws SQLException {
		logger.info("getFetchSize");
		throw new SQLException("ResultSetImpl.getFetchSize is not supported");
		
	}

	@Override
	public final int getType() throws SQLException {
		logger.info("getType");
		throw new SQLException("ResultSetImpl.getType is not supported");
		
	}

	@Override
	public final int getConcurrency() throws SQLException {
		logger.info("getConcurrency");
		throw new SQLException("ResultSetImpl.getConcurrency is not supported");
		
	}

	@Override
	public final boolean rowUpdated() throws SQLException {
		logger.info("rowUpdated");
		throw new SQLException("ResultSetImpl.rowUpdated is not supported");
		
	}

	@Override
	public final boolean rowInserted() throws SQLException {
		logger.info("rowInserted");
		throw new SQLException("ResultSetImpl.rowInserted is not supported");
		
	}

	@Override
	public final boolean rowDeleted() throws SQLException {
		logger.info("rowDeleted");
		throw new SQLException("ResultSetImpl.rowDeleted is not supported");
		
	}

	@Override
	public final void updateNull(final int columnIndex) throws SQLException {
		logger.info("updateNull");
		throw new SQLException("ResultSetImpl.updateNull is not supported");
		
	}

	@Override
	public final void updateBoolean(final int columnIndex, final boolean x) throws SQLException {
		logger.info("updateBoolean");
		throw new SQLException("ResultSetImpl.updateBoolean is not supported");
		
	}

	@Override
	public final void updateByte(final int columnIndex, final byte x) throws SQLException {
		logger.info("updateByte");
		throw new SQLException("ResultSetImpl.updateByte is not supported");
		
	}

	@Override
	public final void updateShort(final int columnIndex, final short x) throws SQLException {
		logger.info("updateShort");
		throw new SQLException("ResultSetImpl.updateShort is not supported");
		
	}

	@Override
	public final void updateInt(final int columnIndex, final int x) throws SQLException {
		logger.info("updateInt");
		throw new SQLException("ResultSetImpl.updateInt is not supported");
		
	}

	@Override
	public final void updateLong(final int columnIndex, final long x) throws SQLException {
		logger.info("updateLong");
		throw new SQLException("ResultSetImpl.updateLong is not supported");
		
	}

	@Override
	public final void updateFloat(final int columnIndex, final float x) throws SQLException {
		logger.info("updateFloat");
		throw new SQLException("ResultSetImpl.updateFloat is not supported");
		
	}

	@Override
	public final void updateDouble(final int columnIndex, final double x) throws SQLException {
		logger.info("updateDouble");
		throw new SQLException("ResultSetImpl.updateDouble is not supported");
		
	}

	@Override
	public final void updateBigDecimal(final int columnIndex, final BigDecimal x) throws SQLException {
		logger.info("updateBigDecimal");
		throw new SQLException("ResultSetImpl.updateBigDecimal is not supported");
		
	}

	@Override
	public final void updateString(final int columnIndex, final String x) throws SQLException {
		logger.info("updateString");
		throw new SQLException("ResultSetImpl.updateString is not supported");
		
	}

	@Override
	public final void updateBytes(final int columnIndex, final byte[] x) throws SQLException {
		logger.info("updateBytes");
		throw new SQLException("ResultSetImpl.updateBytes is not supported");
		
	}

	@Override
	public final void updateDate(final int columnIndex, final Date x) throws SQLException {
		logger.info("updateDate");
		throw new SQLException("ResultSetImpl.updateDate is not supported");
		
	}

	@Override
	public final void updateTime(final int columnIndex, final Time x) throws SQLException {
		logger.info("updateTime");
		throw new SQLException("ResultSetImpl.updateTime is not supported");
		
	}

	@Override
	public final void updateTimestamp(final int columnIndex, final Timestamp x) throws SQLException {
		logger.info("updateTimestamp");
		throw new SQLException("ResultSetImpl.updateTimestamp is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final int columnIndex, final InputStream x, final int length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final int columnIndex, final Reader x, final int length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateObject(final int columnIndex, final Object x, final int scaleOrLength) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public final void updateObject(final int columnIndex, final Object x) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public final void updateNull(final String columnLabel) throws SQLException {
		logger.info("updateNull");
		throw new SQLException("ResultSetImpl.updateNull is not supported");
		
	}

	@Override
	public final void updateBoolean(final String columnLabel, final boolean x) throws SQLException {
		logger.info("updateBoolean");
		throw new SQLException("ResultSetImpl.updateBoolean is not supported");
		
	}

	@Override
	public final void updateByte(final String columnLabel, final byte x) throws SQLException {
		logger.info("updateByte");
		throw new SQLException("ResultSetImpl.updateByte is not supported");
		
	}

	@Override
	public final void updateShort(final String columnLabel, final short x) throws SQLException {
		logger.info("updateShort");
		throw new SQLException("ResultSetImpl.updateShort is not supported");
		
	}

	@Override
	public final void updateInt(final String columnLabel, final int x) throws SQLException {
		logger.info("updateInt");
		throw new SQLException("ResultSetImpl.updateInt is not supported");
		
	}

	@Override
	public final void updateLong(final String columnLabel, final long x) throws SQLException {
		logger.info("updateLong");
		throw new SQLException("ResultSetImpl.updateLong is not supported");
		
	}

	@Override
	public final void updateFloat(final String columnLabel, final float x) throws SQLException {
		logger.info("updateFloat");
		throw new SQLException("ResultSetImpl.updateFloat is not supported");
		
	}

	@Override
	public final void updateDouble(final String columnLabel, final double x) throws SQLException {
		logger.info("updateDouble");
		throw new SQLException("ResultSetImpl.updateDouble is not supported");
		
	}

	@Override
	public final void updateBigDecimal(final String columnLabel, final BigDecimal x) throws SQLException {
		logger.info("updateBigDecimal");
		throw new SQLException("ResultSetImpl.updateBigDecimal is not supported");
		
	}

	@Override
	public final void updateString(final String columnLabel, final String x) throws SQLException {
		logger.info("updateString");
		throw new SQLException("ResultSetImpl.updateString is not supported");
		
	}

	@Override
	public final void updateBytes(final String columnLabel, final byte[] x) throws SQLException {
		logger.info("updateBytes");
		throw new SQLException("ResultSetImpl.updateBytes is not supported");
		
	}

	@Override
	public final void updateDate(final String columnLabel, final Date x) throws SQLException {
		logger.info("updateDate");
		throw new SQLException("ResultSetImpl.updateDate is not supported");
		
	}

	@Override
	public final void updateTime(final String columnLabel, final Time x) throws SQLException {
		logger.info("updateTime");
		throw new SQLException("ResultSetImpl.updateTime is not supported");
		
	}

	@Override
	public final void updateTimestamp(final String columnLabel, final Timestamp x) throws SQLException {
		logger.info("updateTimestamp");
		throw new SQLException("ResultSetImpl.updateTimestamp is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final String columnLabel, final InputStream x, final int length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final String columnLabel, final Reader reader, final int length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateObject(final String columnLabel, final Object x, final int scaleOrLength) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public final void updateObject(final String columnLabel, final Object x) throws SQLException {
		logger.info("updateObject");
		throw new SQLException("ResultSetImpl.updateObject is not supported");
		
	}

	@Override
	public final void insertRow() throws SQLException {
		logger.info("insertRow");
		throw new SQLException("ResultSetImpl.insertRow is not supported");
		
	}

	@Override
	public final void updateRow() throws SQLException {
		logger.info("updateRow");
		throw new SQLException("ResultSetImpl.updateRow is not supported");
		
	}

	@Override
	public final void deleteRow() throws SQLException {
		logger.info("deleteRow");
		throw new SQLException("ResultSetImpl.deleteRow is not supported");
		
	}

	@Override
	public final void refreshRow() throws SQLException {
		logger.info("refreshRow");
		throw new SQLException("ResultSetImpl.refreshRow is not supported");
		
	}

	@Override
	public final void cancelRowUpdates() throws SQLException {
		logger.info("cancelRowUpdates");
		throw new SQLException("ResultSetImpl.cancelRowUpdates is not supported");
		
	}

	@Override
	public final void moveToInsertRow() throws SQLException {
		logger.info("moveToInsertRow");
		throw new SQLException("ResultSetImpl.moveToInsertRow is not supported");
		
	}

	@Override
	public final void moveToCurrentRow() throws SQLException {
		logger.info("moveToCurrentRow");
		throw new SQLException("ResultSetImpl.moveToCurrentRow is not supported");
		
	}

	@Override
	public final Statement getStatement() throws SQLException {
		logger.info("getStatement");
		throw new SQLException("ResultSetImpl.getStatement is not supported");
		
	}

	@Override
	public final Object getObject(final int columnIndex, final Map<String, Class<?>> map) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public final Ref getRef(final int columnIndex) throws SQLException {
		logger.info("getRef");
		throw new SQLException("ResultSetImpl.getRef is not supported");
		
	}

	@Override
	public final Blob getBlob(final int columnIndex) throws SQLException {
		logger.info("getBlob");
		throw new SQLException("ResultSetImpl.getBlob is not supported");
		
	}

	@Override
	public final Clob getClob(final int columnIndex) throws SQLException {
		logger.info("getClob");
		throw new SQLException("ResultSetImpl.getClob is not supported");
		
	}

	@Override
	public final Array getArray(final int columnIndex) throws SQLException {
		logger.info("getArray");
		throw new SQLException("ResultSetImpl.getArray is not supported");
		
	}

	@Override
	public final Object getObject(final String columnLabel, final Map<String, Class<?>> map) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public final Ref getRef(final String columnLabel) throws SQLException {
		logger.info("getRef");
		throw new SQLException("ResultSetImpl.getRef is not supported");
		
	}

	@Override
	public final Blob getBlob(final String columnLabel) throws SQLException {
		logger.info("getBlob");
		throw new SQLException("ResultSetImpl.getBlob is not supported");
		
	}

	@Override
	public final Clob getClob(final String columnLabel) throws SQLException {
		logger.info("getClob");
		throw new SQLException("ResultSetImpl.getClob is not supported");
		
	}

	@Override
	public final Array getArray(final String columnLabel) throws SQLException {
		logger.info("getArray");
		throw new SQLException("ResultSetImpl.getArray is not supported");
		
	}

	@Override
	public final Date getDate(final int columnIndex, final Calendar cal) throws SQLException {
		logger.info("getDate");
		throw new SQLException("ResultSetImpl.getDate is not supported");
		
	}

	@Override
	public final Date getDate(final String columnLabel, final Calendar cal) throws SQLException {
		logger.info("getDate");
		throw new SQLException("ResultSetImpl.getDate is not supported");
		
	}

	@Override
	public final Time getTime(final int columnIndex, final Calendar cal) throws SQLException {
		logger.info("getTime");
		throw new SQLException("ResultSetImpl.getTime is not supported");
		
	}

	@Override
	public final Time getTime(final String columnLabel, final Calendar cal) throws SQLException {
		logger.info("getTime");
		throw new SQLException("ResultSetImpl.getTime is not supported");
		
	}

	@Override
	public final Timestamp getTimestamp(final int columnIndex, final Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnIndex + " calendar=" + cal);
        return (Timestamp) getObject(columnIndex);
	}

	@Override
	public final Timestamp getTimestamp(final String columnLabel, final Calendar cal) throws SQLException {
        logger.info("getTimestamp " + columnLabel + " calendar=" + cal);
        return (Timestamp) getObject(columnLabel);
	}

	@Override
	public final URL getURL(final int columnIndex) throws SQLException {
		logger.info("getURL");
		throw new SQLException("ResultSetImpl.getURL is not supported");
		
	}

	@Override
	public final URL getURL(final String columnLabel) throws SQLException {
		logger.info("getURL");
		throw new SQLException("ResultSetImpl.getURL is not supported");
		
	}

	@Override
	public final void updateRef(final int columnIndex, final Ref x) throws SQLException {
		logger.info("updateRef");
		throw new SQLException("ResultSetImpl.updateRef is not supported");
		
	}

	@Override
	public final void updateRef(final String columnLabel, final Ref x) throws SQLException {
		logger.info("updateRef");
		throw new SQLException("ResultSetImpl.updateRef is not supported");
		
	}

	@Override
	public final void updateBlob(final int columnIndex, final Blob x) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateBlob(final String columnLabel, final Blob x) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateClob(final int columnIndex, final Clob x) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateClob(final String columnLabel, final Clob x) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateArray(final int columnIndex, final Array x) throws SQLException {
		logger.info("updateArray");
		throw new SQLException("ResultSetImpl.updateArray is not supported");
		
	}

	@Override
	public final void updateArray(final String columnLabel, final Array x) throws SQLException {
		logger.info("updateArray");
		throw new SQLException("ResultSetImpl.updateArray is not supported");
		
	}

	@Override
	public final RowId getRowId(final int columnIndex) throws SQLException {
		logger.info("getRowId");
		throw new SQLException("ResultSetImpl.getRowId is not supported");
		
	}

	@Override
	public final RowId getRowId(final String columnLabel) throws SQLException {
		logger.info("getRowId");
		throw new SQLException("ResultSetImpl.getRowId is not supported");
		
	}

	@Override
	public final void updateRowId(final int columnIndex, final RowId x) throws SQLException {
		logger.info("updateRowId");
		throw new SQLException("ResultSetImpl.updateRowId is not supported");
		
	}

	@Override
	public final void updateRowId(final String columnLabel, final RowId x) throws SQLException {
		logger.info("updateRowId");
		throw new SQLException("ResultSetImpl.updateRowId is not supported");
		
	}

	@Override
	public final int getHoldability() throws SQLException {
		logger.info("getHoldability");
		throw new SQLException("ResultSetImpl.getHoldability is not supported");
		
	}

	@Override
	public final boolean isClosed() throws SQLException {
		logger.info("isClosed");
		throw new SQLException("ResultSetImpl.isClosed is not supported");
		
	}

	@Override
	public final void updateNString(final int columnIndex, final String nString) throws SQLException {
		logger.info("updateNString");
		throw new SQLException("ResultSetImpl.updateNString is not supported");
		
	}

	@Override
	public final void updateNString(final String columnLabel, final String nString) throws SQLException {
		logger.info("updateNString");
		throw new SQLException("ResultSetImpl.updateNString is not supported");
		
	}

	@Override
	public final void updateNClob(final int columnIndex, final NClob nClob) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final void updateNClob(final String columnLabel, final NClob nClob) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final NClob getNClob(final int columnIndex) throws SQLException {
		logger.info("getNClob");
		throw new SQLException("ResultSetImpl.getNClob is not supported");
		
	}

	@Override
	public final NClob getNClob(final String columnLabel) throws SQLException {
		logger.info("getNClob");
		throw new SQLException("ResultSetImpl.getNClob is not supported");
		
	}

	@Override
	public final SQLXML getSQLXML(final int columnIndex) throws SQLException {
		logger.info("getSQLXML");
		throw new SQLException("ResultSetImpl.getSQLXML is not supported");
		
	}

	@Override
	public final SQLXML getSQLXML(final String columnLabel) throws SQLException {
		logger.info("getSQLXML");
		throw new SQLException("ResultSetImpl.getSQLXML is not supported");
		
	}

	@Override
	public final void updateSQLXML(final int columnIndex, final SQLXML xmlObject) throws SQLException {
		logger.info("updateSQLXML");
		throw new SQLException("ResultSetImpl.updateSQLXML is not supported");
		
	}

	@Override
	public final void updateSQLXML(final String columnLabel, final SQLXML xmlObject) throws SQLException {
		logger.info("updateSQLXML");
		throw new SQLException("ResultSetImpl.updateSQLXML is not supported");
		
	}

	@Override
	public final String getNString(final int columnIndex) throws SQLException {
		logger.info("getNString");
		throw new SQLException("ResultSetImpl.getNString is not supported");
		
	}

	@Override
	public final String getNString(final String columnLabel) throws SQLException {
		logger.info("getNString");
		throw new SQLException("ResultSetImpl.getNString is not supported");
		
	}

	@Override
	public final Reader getNCharacterStream(final int columnIndex) throws SQLException {
		logger.info("getNCharacterStream");
		throw new SQLException("ResultSetImpl.getNCharacterStream is not supported");
		
	}

	@Override
	public final Reader getNCharacterStream(final String columnLabel) throws SQLException {
		logger.info("getNCharacterStream");
		throw new SQLException("ResultSetImpl.getNCharacterStream is not supported");
		
	}

	@Override
	public final void updateNCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public final void updateNCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final int columnIndex, final InputStream x, final long length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final int columnIndex, final Reader x, final long length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final String columnLabel, final InputStream x, final long length) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final String columnLabel, final Reader reader, final long length) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateBlob(final int columnIndex, final InputStream inputStream, final long length) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateBlob(final String columnLabel, final InputStream inputStream, final long length) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateNClob(final int columnIndex, final Reader reader, final long length) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final void updateNClob(final String columnLabel, final Reader reader, final long length) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final void updateNCharacterStream(final int columnIndex, final Reader x) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public final void updateNCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
		logger.info("updateNCharacterStream");
		throw new SQLException("ResultSetImpl.updateNCharacterStream is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final int columnIndex, final InputStream x) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final int columnIndex, final InputStream x) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final int columnIndex, final Reader x) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateAsciiStream(final String columnLabel, final InputStream x) throws SQLException {
		logger.info("updateAsciiStream");
		throw new SQLException("ResultSetImpl.updateAsciiStream is not supported");
		
	}

	@Override
	public final void updateBinaryStream(final String columnLabel, final InputStream x) throws SQLException {
		logger.info("updateBinaryStream");
		throw new SQLException("ResultSetImpl.updateBinaryStream is not supported");
		
	}

	@Override
	public final void updateCharacterStream(final String columnLabel, final Reader reader) throws SQLException {
		logger.info("updateCharacterStream");
		throw new SQLException("ResultSetImpl.updateCharacterStream is not supported");
		
	}

	@Override
	public final void updateBlob(final int columnIndex, final InputStream inputStream) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateBlob(final String columnLabel, final InputStream inputStream) throws SQLException {
		logger.info("updateBlob");
		throw new SQLException("ResultSetImpl.updateBlob is not supported");
		
	}

	@Override
	public final void updateClob(final int columnIndex, final Reader reader) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateClob(final String columnLabel, final Reader reader) throws SQLException {
		logger.info("updateClob");
		throw new SQLException("ResultSetImpl.updateClob is not supported");
		
	}

	@Override
	public final void updateNClob(final int columnIndex, final Reader reader) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final void updateNClob(final String columnLabel, final Reader reader) throws SQLException {
		logger.info("updateNClob");
		throw new SQLException("ResultSetImpl.updateNClob is not supported");
		
	}

	@Override
	public final <T> T getObject(final int columnIndex, final Class<T> type) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}

	@Override
	public final <T> T getObject(final String columnLabel, final Class<T> type) throws SQLException {
		logger.info("getObject");
		throw new SQLException("ResultSetImpl.getObject is not supported");
		
	}
}