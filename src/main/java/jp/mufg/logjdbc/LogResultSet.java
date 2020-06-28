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

    private final ResultSet rs, target;

    public LogResultSet(ResultSet rs) {
        super();
        this.target = this.rs = rs;
    }

    public boolean next() throws SQLException {
        boolean result = rs.next();
        logger.info("next() -> " + result);
        if (result) {
            logger.info("----");
            ResultSetMetaData meta = getMetaData();
            int n = meta.getColumnCount();
            for (int i = 1; i <= n; i++) {
                Object value = getObject(i);
                logger.info(i + ":" + meta.getColumnName(i) + ":" + value + "("
                        + (value == null ? "null" : value.getClass().getName()) + ")");
            }
            logger.info("----");
        }
        return result;
    }

    // ==============================


public boolean absolute(int arg0) throws java.sql.SQLException {
	logger.info("absolute" + " , " + arg0 );
	boolean result = target.absolute(arg0);
	logger.info("result is " + result);
	return result;
}

public String getString(String arg0) throws java.sql.SQLException {
	logger.info("getString" + " , " + arg0 );
	String result = target.getString(arg0);
	logger.info("result is " + result);
	return result;
}

public String getString(int arg0) throws java.sql.SQLException {
	logger.info("getString" + " , " + arg0 );
	String result = target.getString(arg0);
	logger.info("result is " + result);
	return result;
}

public java.net.URL getURL(String arg0) throws java.sql.SQLException {
	logger.info("getURL" + " , " + arg0 );
	java.net.URL result = target.getURL(arg0);
	logger.info("result is " + result);
	return result;
}

public java.net.URL getURL(int arg0) throws java.sql.SQLException {
	logger.info("getURL" + " , " + arg0 );
	java.net.URL result = target.getURL(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Array getArray(String arg0) throws java.sql.SQLException {
	logger.info("getArray" + " , " + arg0 );
	java.sql.Array result = target.getArray(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Array getArray(int arg0) throws java.sql.SQLException {
	logger.info("getArray" + " , " + arg0 );
	java.sql.Array result = target.getArray(arg0);
	logger.info("result is " + result);
	return result;
}


public void updateBytes(String arg0, byte[] arg1) throws java.sql.SQLException {
	logger.info("updateBytes" + " , " + arg0  + " , " + arg1 );
target.updateBytes(arg0, arg1);
}

public void updateBytes(int arg0, byte[] arg1) throws java.sql.SQLException {
	logger.info("updateBytes" + " , " + arg0  + " , " + arg1 );
target.updateBytes(arg0, arg1);
}

public Object getObject(String arg0, java.util.Map<String, Class<?>> arg1) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0  + " , " + arg1 );
	Object result = target.getObject(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public Object getObject(int arg0, java.util.Map<String, Class<?>> arg1) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0  + " , " + arg1 );
	Object result = target.getObject(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public <T> T getObject(String arg0, Class<T> arg1) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0  + " , " + arg1 );
	T result = target.getObject(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public Object getObject(int arg0) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0 );
	Object result = target.getObject(arg0);
	logger.info("result is " + result);
	return result;
}

public Object getObject(String arg0) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0 );
	Object result = target.getObject(arg0);
	logger.info("result is " + result);
	return result;
}

public <T> T getObject(int arg0, Class<T> arg1) throws java.sql.SQLException {
	logger.info("getObject" + " , " + arg0  + " , " + arg1 );
	T result = target.getObject(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public boolean getBoolean(int arg0) throws java.sql.SQLException {
	logger.info("getBoolean" + " , " + arg0 );
	boolean result = target.getBoolean(arg0);
	logger.info("result is " + result);
	return result;
}

public boolean getBoolean(String arg0) throws java.sql.SQLException {
	logger.info("getBoolean" + " , " + arg0 );
	boolean result = target.getBoolean(arg0);
	logger.info("result is " + result);
	return result;
}

public byte getByte(int arg0) throws java.sql.SQLException {
	logger.info("getByte" + " , " + arg0 );
	byte result = target.getByte(arg0);
	logger.info("result is " + result);
	return result;
}

public byte getByte(String arg0) throws java.sql.SQLException {
	logger.info("getByte" + " , " + arg0 );
	byte result = target.getByte(arg0);
	logger.info("result is " + result);
	return result;
}

public short getShort(String arg0) throws java.sql.SQLException {
	logger.info("getShort" + " , " + arg0 );
	short result = target.getShort(arg0);
	logger.info("result is " + result);
	return result;
}

public short getShort(int arg0) throws java.sql.SQLException {
	logger.info("getShort" + " , " + arg0 );
	short result = target.getShort(arg0);
	logger.info("result is " + result);
	return result;
}

public int getInt(int arg0) throws java.sql.SQLException {
	logger.info("getInt" + " , " + arg0 );
	int result = target.getInt(arg0);
	logger.info("result is " + result);
	return result;
}

public int getInt(String arg0) throws java.sql.SQLException {
	logger.info("getInt" + " , " + arg0 );
	int result = target.getInt(arg0);
	logger.info("result is " + result);
	return result;
}

public long getLong(int arg0) throws java.sql.SQLException {
	logger.info("getLong" + " , " + arg0 );
	long result = target.getLong(arg0);
	logger.info("result is " + result);
	return result;
}

public long getLong(String arg0) throws java.sql.SQLException {
	logger.info("getLong" + " , " + arg0 );
	long result = target.getLong(arg0);
	logger.info("result is " + result);
	return result;
}

public float getFloat(String arg0) throws java.sql.SQLException {
	logger.info("getFloat" + " , " + arg0 );
	float result = target.getFloat(arg0);
	logger.info("result is " + result);
	return result;
}

public float getFloat(int arg0) throws java.sql.SQLException {
	logger.info("getFloat" + " , " + arg0 );
	float result = target.getFloat(arg0);
	logger.info("result is " + result);
	return result;
}

public double getDouble(String arg0) throws java.sql.SQLException {
	logger.info("getDouble" + " , " + arg0 );
	double result = target.getDouble(arg0);
	logger.info("result is " + result);
	return result;
}

public double getDouble(int arg0) throws java.sql.SQLException {
	logger.info("getDouble" + " , " + arg0 );
	double result = target.getDouble(arg0);
	logger.info("result is " + result);
	return result;
}

public byte[] getBytes(String arg0) throws java.sql.SQLException {
	logger.info("getBytes" + " , " + arg0 );
	byte[] result = target.getBytes(arg0);
	logger.info("result is " + result);
	return result;
}

public byte[] getBytes(int arg0) throws java.sql.SQLException {
	logger.info("getBytes" + " , " + arg0 );
	byte[] result = target.getBytes(arg0);
	logger.info("result is " + result);
	return result;
}

public boolean last() throws java.sql.SQLException {
	logger.info("last");
	boolean result = target.last();
	logger.info("result is " + result);
	return result;
}

// public boolean next() throws java.sql.SQLException {
// 	logger.info("next");
// 	boolean result = target.next();
// 	logger.info("result is " + result);
// 	return result;
// }

public boolean first() throws java.sql.SQLException {
	logger.info("first");
	boolean result = target.first();
	logger.info("result is " + result);
	return result;
}

public void close() throws java.sql.SQLException {
	logger.info("close");
target.close();
}

public int getType() throws java.sql.SQLException {
	logger.info("getType");
	int result = target.getType();
	logger.info("result is " + result);
	return result;
}

public <T> T unwrap(Class<T> arg0) throws java.sql.SQLException {
	logger.info("unwrap" + " , " + arg0 );
	T result = target.unwrap(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Ref getRef(int arg0) throws java.sql.SQLException {
	logger.info("getRef" + " , " + arg0 );
	java.sql.Ref result = target.getRef(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Ref getRef(String arg0) throws java.sql.SQLException {
	logger.info("getRef" + " , " + arg0 );
	java.sql.Ref result = target.getRef(arg0);
	logger.info("result is " + result);
	return result;
}

public boolean previous() throws java.sql.SQLException {
	logger.info("previous");
	boolean result = target.previous();
	logger.info("result is " + result);
	return result;
}

public java.sql.ResultSetMetaData getMetaData() throws java.sql.SQLException {
	logger.info("getMetaData");
	java.sql.ResultSetMetaData result = new LogResultSetMetaData(target.getMetaData());
	logger.info("getMetaData result is " + result);
	return result;
}

public boolean wasNull() throws java.sql.SQLException {
	logger.info("wasNull");
	boolean result = target.wasNull();
	logger.info("wasNull result is " + result);
	return result;
}

public java.math.BigDecimal getBigDecimal(String arg0) throws java.sql.SQLException {
	logger.info("getBigDecimal" + " , " + arg0 );
	java.math.BigDecimal result = target.getBigDecimal(arg0);
	logger.info("result is " + result);
	return result;
}

public java.math.BigDecimal getBigDecimal(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("getBigDecimal" + " , " + arg0  + " , " + arg1 );
	java.math.BigDecimal result = target.getBigDecimal(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.math.BigDecimal getBigDecimal(int arg0, int arg1) throws java.sql.SQLException {
	logger.info("getBigDecimal" + " , " + arg0  + " , " + arg1 );
	java.math.BigDecimal result = target.getBigDecimal(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.math.BigDecimal getBigDecimal(int arg0) throws java.sql.SQLException {
	logger.info("getBigDecimal" + " , " + arg0 );
	java.math.BigDecimal result = target.getBigDecimal(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Date getDate(String arg0) throws java.sql.SQLException {
	logger.info("getDate" + " , " + arg0 );
	java.sql.Date result = target.getDate(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Date getDate(int arg0) throws java.sql.SQLException {
	logger.info("getDate" + " , " + arg0 );
	java.sql.Date result = target.getDate(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Date getDate(int arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getDate" + " , " + arg0  + " , " + arg1 );
	java.sql.Date result = target.getDate(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Date getDate(String arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getDate" + " , " + arg0  + " , " + arg1 );
	java.sql.Date result = target.getDate(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Time getTime(String arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getTime" + " , " + arg0  + " , " + arg1 );
	java.sql.Time result = target.getTime(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Time getTime(String arg0) throws java.sql.SQLException {
	logger.info("getTime" + " , " + arg0 );
	java.sql.Time result = target.getTime(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Time getTime(int arg0) throws java.sql.SQLException {
	logger.info("getTime" + " , " + arg0 );
	java.sql.Time result = target.getTime(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Time getTime(int arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getTime" + " , " + arg0  + " , " + arg1 );
	java.sql.Time result = target.getTime(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Timestamp getTimestamp(String arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getTimestamp" + " , " + arg0  + " , " + arg1 );
	java.sql.Timestamp result = target.getTimestamp(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Timestamp getTimestamp(String arg0) throws java.sql.SQLException {
	logger.info("getTimestamp" + " , " + arg0 );
	java.sql.Timestamp result = target.getTimestamp(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Timestamp getTimestamp(int arg0, java.util.Calendar arg1) throws java.sql.SQLException {
	logger.info("getTimestamp" + " , " + arg0  + " , " + arg1 );
	java.sql.Timestamp result = target.getTimestamp(arg0, arg1);
	logger.info("result is " + result);
	return result;
}

public java.sql.Timestamp getTimestamp(int arg0) throws java.sql.SQLException {
	logger.info("getTimestamp" + " , " + arg0 );
	java.sql.Timestamp result = target.getTimestamp(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getAsciiStream(int arg0) throws java.sql.SQLException {
	logger.info("getAsciiStream" + " , " + arg0 );
	java.io.InputStream result = target.getAsciiStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getAsciiStream(String arg0) throws java.sql.SQLException {
	logger.info("getAsciiStream" + " , " + arg0 );
	java.io.InputStream result = target.getAsciiStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getUnicodeStream(String arg0) throws java.sql.SQLException {
	logger.info("getUnicodeStream" + " , " + arg0 );
	java.io.InputStream result = target.getUnicodeStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getUnicodeStream(int arg0) throws java.sql.SQLException {
	logger.info("getUnicodeStream" + " , " + arg0 );
	java.io.InputStream result = target.getUnicodeStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getBinaryStream(String arg0) throws java.sql.SQLException {
	logger.info("getBinaryStream" + " , " + arg0 );
	java.io.InputStream result = target.getBinaryStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.InputStream getBinaryStream(int arg0) throws java.sql.SQLException {
	logger.info("getBinaryStream" + " , " + arg0 );
	java.io.InputStream result = target.getBinaryStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.SQLWarning getWarnings() throws java.sql.SQLException {
	logger.info("getWarnings");
	java.sql.SQLWarning result = target.getWarnings();
	logger.info("result is " + result);
	return result;
}

public void clearWarnings() throws java.sql.SQLException {
	logger.info("clearWarnings");
target.clearWarnings();
}

public String getCursorName() throws java.sql.SQLException {
	logger.info("getCursorName");
	String result = target.getCursorName();
	logger.info("result is " + result);
	return result;
}

public int findColumn(String arg0) throws java.sql.SQLException {
	logger.info("findColumn" + " , " + arg0 );
	int result = target.findColumn(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.Reader getCharacterStream(int arg0) throws java.sql.SQLException {
	logger.info("getCharacterStream" + " , " + arg0 );
	java.io.Reader result = target.getCharacterStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.Reader getCharacterStream(String arg0) throws java.sql.SQLException {
	logger.info("getCharacterStream" + " , " + arg0 );
	java.io.Reader result = target.getCharacterStream(arg0);
	logger.info("result is " + result);
	return result;
}

public boolean isBeforeFirst() throws java.sql.SQLException {
	logger.info("isBeforeFirst");
	boolean result = target.isBeforeFirst();
	logger.info("result is " + result);
	return result;
}

public boolean isAfterLast() throws java.sql.SQLException {
	logger.info("isAfterLast");
	boolean result = target.isAfterLast();
	logger.info("result is " + result);
	return result;
}

public boolean isFirst() throws java.sql.SQLException {
	logger.info("isFirst");
	boolean result = target.isFirst();
	logger.info("result is " + result);
	return result;
}

public boolean isLast() throws java.sql.SQLException {
	logger.info("isLast");
	boolean result = target.isLast();
	logger.info("result is " + result);
	return result;
}

public void beforeFirst() throws java.sql.SQLException {
	logger.info("beforeFirst");
target.beforeFirst();
}

public void afterLast() throws java.sql.SQLException {
	logger.info("afterLast");
target.afterLast();
}

public int getRow() throws java.sql.SQLException {
	logger.info("getRow");
	int result = target.getRow();
	logger.info("result is " + result);
	return result;
}

public boolean relative(int arg0) throws java.sql.SQLException {
	logger.info("relative" + " , " + arg0 );
	boolean result = target.relative(arg0);
	logger.info("result is " + result);
	return result;
}

public void setFetchDirection(int arg0) throws java.sql.SQLException {
	logger.info("setFetchDirection" + " , " + arg0 );
target.setFetchDirection(arg0);
}

public int getFetchDirection() throws java.sql.SQLException {
	logger.info("getFetchDirection");
	int result = target.getFetchDirection();
	logger.info("result is " + result);
	return result;
}

public void setFetchSize(int arg0) throws java.sql.SQLException {
	logger.info("setFetchSize" + " , " + arg0 );
target.setFetchSize(arg0);
}

public int getFetchSize() throws java.sql.SQLException {
	logger.info("getFetchSize");
	int result = target.getFetchSize();
	logger.info("result is " + result);
	return result;
}

public int getConcurrency() throws java.sql.SQLException {
	logger.info("getConcurrency");
	int result = target.getConcurrency();
	logger.info("result is " + result);
	return result;
}

public boolean rowUpdated() throws java.sql.SQLException {
	logger.info("rowUpdated");
	boolean result = target.rowUpdated();
	logger.info("result is " + result);
	return result;
}

public boolean rowInserted() throws java.sql.SQLException {
	logger.info("rowInserted");
	boolean result = target.rowInserted();
	logger.info("result is " + result);
	return result;
}

public boolean rowDeleted() throws java.sql.SQLException {
	logger.info("rowDeleted");
	boolean result = target.rowDeleted();
	logger.info("result is " + result);
	return result;
}

public void updateNull(int arg0) throws java.sql.SQLException {
	logger.info("updateNull" + " , " + arg0 );
target.updateNull(arg0);
}

public void updateNull(String arg0) throws java.sql.SQLException {
	logger.info("updateNull" + " , " + arg0 );
target.updateNull(arg0);
}

public void updateBoolean(String arg0, boolean arg1) throws java.sql.SQLException {
	logger.info("updateBoolean" + " , " + arg0  + " , " + arg1 );
target.updateBoolean(arg0, arg1);
}

public void updateBoolean(int arg0, boolean arg1) throws java.sql.SQLException {
	logger.info("updateBoolean" + " , " + arg0  + " , " + arg1 );
target.updateBoolean(arg0, arg1);
}

public void updateByte(int arg0, byte arg1) throws java.sql.SQLException {
	logger.info("updateByte" + " , " + arg0  + " , " + arg1 );
target.updateByte(arg0, arg1);
}

public void updateByte(String arg0, byte arg1) throws java.sql.SQLException {
	logger.info("updateByte" + " , " + arg0  + " , " + arg1 );
target.updateByte(arg0, arg1);
}

public void updateShort(int arg0, short arg1) throws java.sql.SQLException {
	logger.info("updateShort" + " , " + arg0  + " , " + arg1 );
target.updateShort(arg0, arg1);
}

public void updateShort(String arg0, short arg1) throws java.sql.SQLException {
	logger.info("updateShort" + " , " + arg0  + " , " + arg1 );
target.updateShort(arg0, arg1);
}

public void updateInt(int arg0, int arg1) throws java.sql.SQLException {
	logger.info("updateInt" + " , " + arg0  + " , " + arg1 );
target.updateInt(arg0, arg1);
}

public void updateInt(String arg0, int arg1) throws java.sql.SQLException {
	logger.info("updateInt" + " , " + arg0  + " , " + arg1 );
target.updateInt(arg0, arg1);
}

public void updateLong(int arg0, long arg1) throws java.sql.SQLException {
	logger.info("updateLong" + " , " + arg0  + " , " + arg1 );
target.updateLong(arg0, arg1);
}

public void updateLong(String arg0, long arg1) throws java.sql.SQLException {
	logger.info("updateLong" + " , " + arg0  + " , " + arg1 );
target.updateLong(arg0, arg1);
}

public void updateFloat(String arg0, float arg1) throws java.sql.SQLException {
	logger.info("updateFloat" + " , " + arg0  + " , " + arg1 );
target.updateFloat(arg0, arg1);
}

public void updateFloat(int arg0, float arg1) throws java.sql.SQLException {
	logger.info("updateFloat" + " , " + arg0  + " , " + arg1 );
target.updateFloat(arg0, arg1);
}

public void updateDouble(int arg0, double arg1) throws java.sql.SQLException {
	logger.info("updateDouble" + " , " + arg0  + " , " + arg1 );
target.updateDouble(arg0, arg1);
}

public void updateDouble(String arg0, double arg1) throws java.sql.SQLException {
	logger.info("updateDouble" + " , " + arg0  + " , " + arg1 );
target.updateDouble(arg0, arg1);
}

public void updateBigDecimal(String arg0, java.math.BigDecimal arg1) throws java.sql.SQLException {
	logger.info("updateBigDecimal" + " , " + arg0  + " , " + arg1 );
target.updateBigDecimal(arg0, arg1);
}

public void updateBigDecimal(int arg0, java.math.BigDecimal arg1) throws java.sql.SQLException {
	logger.info("updateBigDecimal" + " , " + arg0  + " , " + arg1 );
target.updateBigDecimal(arg0, arg1);
}

public void updateString(int arg0, String arg1) throws java.sql.SQLException {
	logger.info("updateString" + " , " + arg0  + " , " + arg1 );
target.updateString(arg0, arg1);
}

public void updateString(String arg0, String arg1) throws java.sql.SQLException {
	logger.info("updateString" + " , " + arg0  + " , " + arg1 );
target.updateString(arg0, arg1);
}

public void updateDate(String arg0, java.sql.Date arg1) throws java.sql.SQLException {
	logger.info("updateDate" + " , " + arg0  + " , " + arg1 );
target.updateDate(arg0, arg1);
}

public void updateDate(int arg0, java.sql.Date arg1) throws java.sql.SQLException {
	logger.info("updateDate" + " , " + arg0  + " , " + arg1 );
target.updateDate(arg0, arg1);
}

public void updateTime(int arg0, java.sql.Time arg1) throws java.sql.SQLException {
	logger.info("updateTime" + " , " + arg0  + " , " + arg1 );
target.updateTime(arg0, arg1);
}

public void updateTime(String arg0, java.sql.Time arg1) throws java.sql.SQLException {
	logger.info("updateTime" + " , " + arg0  + " , " + arg1 );
target.updateTime(arg0, arg1);
}

public void updateTimestamp(int arg0, java.sql.Timestamp arg1) throws java.sql.SQLException {
	logger.info("updateTimestamp" + " , " + arg0  + " , " + arg1 );
target.updateTimestamp(arg0, arg1);
}

public void updateTimestamp(String arg0, java.sql.Timestamp arg1) throws java.sql.SQLException {
	logger.info("updateTimestamp" + " , " + arg0  + " , " + arg1 );
target.updateTimestamp(arg0, arg1);
}

public void updateAsciiStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateAsciiStream(arg0, arg1, arg2);
}

public void updateAsciiStream(String arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1 );
target.updateAsciiStream(arg0, arg1);
}

public void updateAsciiStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1 );
target.updateAsciiStream(arg0, arg1);
}

public void updateAsciiStream(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateAsciiStream(arg0, arg1, arg2);
}

public void updateAsciiStream(String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateAsciiStream(arg0, arg1, arg2);
}

public void updateAsciiStream(String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateAsciiStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateAsciiStream(arg0, arg1, arg2);
}

public void updateBinaryStream(String arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1 );
target.updateBinaryStream(arg0, arg1);
}

public void updateBinaryStream(String arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBinaryStream(arg0, arg1, arg2);
}

public void updateBinaryStream(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBinaryStream(arg0, arg1, arg2);
}

public void updateBinaryStream(String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBinaryStream(arg0, arg1, arg2);
}

public void updateBinaryStream(int arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1 );
target.updateBinaryStream(arg0, arg1);
}

public void updateBinaryStream(int arg0, java.io.InputStream arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateBinaryStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBinaryStream(arg0, arg1, arg2);
}

public void updateCharacterStream(String arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateCharacterStream(arg0, arg1, arg2);
}

public void updateCharacterStream(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateCharacterStream(arg0, arg1, arg2);
}

public void updateCharacterStream(String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateCharacterStream(arg0, arg1, arg2);
}

public void updateCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1 );
target.updateCharacterStream(arg0, arg1);
}

public void updateCharacterStream(int arg0, java.io.Reader arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateCharacterStream(arg0, arg1, arg2);
}

public void updateCharacterStream(String arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateCharacterStream" + " , " + arg0  + " , " + arg1 );
target.updateCharacterStream(arg0, arg1);
}

public void updateObject(String arg0, Object arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateObject(arg0, arg1, arg2);
}

public void updateObject(int arg0, Object arg1) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1 );
target.updateObject(arg0, arg1);
}

public void updateObject(String arg0, Object arg1, java.sql.SQLType arg2) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateObject(arg0, arg1, arg2);
}

public void updateObject(int arg0, Object arg1, java.sql.SQLType arg2) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateObject(arg0, arg1, arg2);
}

public void updateObject(String arg0, Object arg1, java.sql.SQLType arg2, int arg3) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
target.updateObject(arg0, arg1, arg2, arg3);
}

public void updateObject(int arg0, Object arg1, java.sql.SQLType arg2, int arg3) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2  + " , " + arg3 );
target.updateObject(arg0, arg1, arg2, arg3);
}

public void updateObject(int arg0, Object arg1, int arg2) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateObject(arg0, arg1, arg2);
}

public void updateObject(String arg0, Object arg1) throws java.sql.SQLException {
	logger.info("updateObject" + " , " + arg0  + " , " + arg1 );
target.updateObject(arg0, arg1);
}

public void insertRow() throws java.sql.SQLException {
	logger.info("insertRow");
target.insertRow();
}

public void updateRow() throws java.sql.SQLException {
	logger.info("updateRow");
target.updateRow();
}

public void deleteRow() throws java.sql.SQLException {
	logger.info("deleteRow");
target.deleteRow();
}

public void refreshRow() throws java.sql.SQLException {
	logger.info("refreshRow");
target.refreshRow();
}

public void cancelRowUpdates() throws java.sql.SQLException {
	logger.info("cancelRowUpdates");
target.cancelRowUpdates();
}

public void moveToInsertRow() throws java.sql.SQLException {
	logger.info("moveToInsertRow");
target.moveToInsertRow();
}

public void moveToCurrentRow() throws java.sql.SQLException {
	logger.info("moveToCurrentRow");
target.moveToCurrentRow();
}

public java.sql.Statement getStatement() throws java.sql.SQLException {
	logger.info("getStatement");
	java.sql.Statement result = target.getStatement();
	logger.info("result is " + result);
	return result;
}

public java.sql.Blob getBlob(int arg0) throws java.sql.SQLException {
	logger.info("getBlob" + " , " + arg0 );
	java.sql.Blob result = target.getBlob(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Blob getBlob(String arg0) throws java.sql.SQLException {
	logger.info("getBlob" + " , " + arg0 );
	java.sql.Blob result = target.getBlob(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Clob getClob(int arg0) throws java.sql.SQLException {
	logger.info("getClob" + " , " + arg0 );
	java.sql.Clob result = target.getClob(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.Clob getClob(String arg0) throws java.sql.SQLException {
	logger.info("getClob" + " , " + arg0 );
	java.sql.Clob result = target.getClob(arg0);
	logger.info("result is " + result);
	return result;
}

public void updateRef(int arg0, java.sql.Ref arg1) throws java.sql.SQLException {
	logger.info("updateRef" + " , " + arg0  + " , " + arg1 );
target.updateRef(arg0, arg1);
}

public void updateRef(String arg0, java.sql.Ref arg1) throws java.sql.SQLException {
	logger.info("updateRef" + " , " + arg0  + " , " + arg1 );
target.updateRef(arg0, arg1);
}

public void updateBlob(int arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBlob(arg0, arg1, arg2);
}

public void updateBlob(String arg0, java.sql.Blob arg1) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1 );
target.updateBlob(arg0, arg1);
}

public void updateBlob(int arg0, java.sql.Blob arg1) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1 );
target.updateBlob(arg0, arg1);
}

public void updateBlob(String arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1 );
target.updateBlob(arg0, arg1);
}

public void updateBlob(int arg0, java.io.InputStream arg1) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1 );
target.updateBlob(arg0, arg1);
}

public void updateBlob(String arg0, java.io.InputStream arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateBlob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateBlob(arg0, arg1, arg2);
}

public void updateClob(String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateClob(arg0, arg1, arg2);
}

public void updateClob(String arg0, java.sql.Clob arg1) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1 );
target.updateClob(arg0, arg1);
}

public void updateClob(String arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1 );
target.updateClob(arg0, arg1);
}

public void updateClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateClob(arg0, arg1, arg2);
}

public void updateClob(int arg0, java.sql.Clob arg1) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1 );
target.updateClob(arg0, arg1);
}

public void updateClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateClob" + " , " + arg0  + " , " + arg1 );
target.updateClob(arg0, arg1);
}

public void updateArray(int arg0, java.sql.Array arg1) throws java.sql.SQLException {
	logger.info("updateArray" + " , " + arg0  + " , " + arg1 );
target.updateArray(arg0, arg1);
}

public void updateArray(String arg0, java.sql.Array arg1) throws java.sql.SQLException {
	logger.info("updateArray" + " , " + arg0  + " , " + arg1 );
target.updateArray(arg0, arg1);
}

public java.sql.RowId getRowId(int arg0) throws java.sql.SQLException {
	logger.info("getRowId" + " , " + arg0 );
	java.sql.RowId result = target.getRowId(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.RowId getRowId(String arg0) throws java.sql.SQLException {
	logger.info("getRowId" + " , " + arg0 );
	java.sql.RowId result = target.getRowId(arg0);
	logger.info("result is " + result);
	return result;
}

public void updateRowId(String arg0, java.sql.RowId arg1) throws java.sql.SQLException {
	logger.info("updateRowId" + " , " + arg0  + " , " + arg1 );
target.updateRowId(arg0, arg1);
}

public void updateRowId(int arg0, java.sql.RowId arg1) throws java.sql.SQLException {
	logger.info("updateRowId" + " , " + arg0  + " , " + arg1 );
target.updateRowId(arg0, arg1);
}

public int getHoldability() throws java.sql.SQLException {
	logger.info("getHoldability");
	int result = target.getHoldability();
	logger.info("result is " + result);
	return result;
}

public boolean isClosed() throws java.sql.SQLException {
	logger.info("isClosed");
	boolean result = target.isClosed();
	logger.info("result is " + result);
	return result;
}

public void updateNString(int arg0, String arg1) throws java.sql.SQLException {
	logger.info("updateNString" + " , " + arg0  + " , " + arg1 );
target.updateNString(arg0, arg1);
}

public void updateNString(String arg0, String arg1) throws java.sql.SQLException {
	logger.info("updateNString" + " , " + arg0  + " , " + arg1 );
target.updateNString(arg0, arg1);
}

public void updateNClob(String arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1 );
target.updateNClob(arg0, arg1);
}

public void updateNClob(String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateNClob(arg0, arg1, arg2);
}

public void updateNClob(int arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1 );
target.updateNClob(arg0, arg1);
}

public void updateNClob(String arg0, java.sql.NClob arg1) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1 );
target.updateNClob(arg0, arg1);
}

public void updateNClob(int arg0, java.sql.NClob arg1) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1 );
target.updateNClob(arg0, arg1);
}

public void updateNClob(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateNClob" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateNClob(arg0, arg1, arg2);
}

public java.sql.NClob getNClob(String arg0) throws java.sql.SQLException {
	logger.info("getNClob" + " , " + arg0 );
	java.sql.NClob result = target.getNClob(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.NClob getNClob(int arg0) throws java.sql.SQLException {
	logger.info("getNClob" + " , " + arg0 );
	java.sql.NClob result = target.getNClob(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.SQLXML getSQLXML(int arg0) throws java.sql.SQLException {
	logger.info("getSQLXML" + " , " + arg0 );
	java.sql.SQLXML result = target.getSQLXML(arg0);
	logger.info("result is " + result);
	return result;
}

public java.sql.SQLXML getSQLXML(String arg0) throws java.sql.SQLException {
	logger.info("getSQLXML" + " , " + arg0 );
	java.sql.SQLXML result = target.getSQLXML(arg0);
	logger.info("result is " + result);
	return result;
}

public void updateSQLXML(int arg0, java.sql.SQLXML arg1) throws java.sql.SQLException {
	logger.info("updateSQLXML" + " , " + arg0  + " , " + arg1 );
target.updateSQLXML(arg0, arg1);
}

public void updateSQLXML(String arg0, java.sql.SQLXML arg1) throws java.sql.SQLException {
	logger.info("updateSQLXML" + " , " + arg0  + " , " + arg1 );
target.updateSQLXML(arg0, arg1);
}

public String getNString(String arg0) throws java.sql.SQLException {
	logger.info("getNString" + " , " + arg0 );
	String result = target.getNString(arg0);
	logger.info("result is " + result);
	return result;
}

public String getNString(int arg0) throws java.sql.SQLException {
	logger.info("getNString" + " , " + arg0 );
	String result = target.getNString(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.Reader getNCharacterStream(int arg0) throws java.sql.SQLException {
	logger.info("getNCharacterStream" + " , " + arg0 );
	java.io.Reader result = target.getNCharacterStream(arg0);
	logger.info("result is " + result);
	return result;
}

public java.io.Reader getNCharacterStream(String arg0) throws java.sql.SQLException {
	logger.info("getNCharacterStream" + " , " + arg0 );
	java.io.Reader result = target.getNCharacterStream(arg0);
	logger.info("result is " + result);
	return result;
}

public void updateNCharacterStream(int arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateNCharacterStream" + " , " + arg0  + " , " + arg1 );
target.updateNCharacterStream(arg0, arg1);
}

public void updateNCharacterStream(String arg0, java.io.Reader arg1) throws java.sql.SQLException {
	logger.info("updateNCharacterStream" + " , " + arg0  + " , " + arg1 );
target.updateNCharacterStream(arg0, arg1);
}

public void updateNCharacterStream(int arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateNCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateNCharacterStream(arg0, arg1, arg2);
}

public void updateNCharacterStream(String arg0, java.io.Reader arg1, long arg2) throws java.sql.SQLException {
	logger.info("updateNCharacterStream" + " , " + arg0  + " , " + arg1  + " , " + arg2 );
target.updateNCharacterStream(arg0, arg1, arg2);
}

public boolean isWrapperFor(Class<?> arg0) throws java.sql.SQLException {
	logger.info("isWrapperFor" + " , " + arg0 );
	boolean result = target.isWrapperFor(arg0);
	logger.info("result is " + result);
	return result;
}



}
