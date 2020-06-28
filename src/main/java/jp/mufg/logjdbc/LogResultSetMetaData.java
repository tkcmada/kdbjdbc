package jp.mufg.logjdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogResultSetMetaData implements ResultSetMetaData {
private static final Logger logger = FileLogger.getLogger(LogResultSetMetaData.class);
	private final ResultSetMetaData target;

	public LogResultSetMetaData(ResultSetMetaData target) {
		super();
		this.target = target;
	}

    //==========================================
public boolean isReadOnly(int arg0) throws java.sql.SQLException {
	logger.info("isReadOnly" + " , " + arg0 );
	boolean result = target.isReadOnly(arg0);
	logger.info("isReadOnly result is " + result);
	return result;
}

public boolean isDefinitelyWritable(int arg0) throws java.sql.SQLException {
	logger.info("isDefinitelyWritable" + " , " + arg0 );
	boolean result = target.isDefinitelyWritable(arg0);
	logger.info("isDefinitelyWritable result is " + result);
	return result;
}

public int getColumnDisplaySize(int arg0) throws java.sql.SQLException {
	logger.info("getColumnDisplaySize" + " , " + arg0 );
	int result = target.getColumnDisplaySize(arg0);
	logger.info("getColumnDisplaySize result is " + result);
	return result;
}

public boolean isAutoIncrement(int arg0) throws java.sql.SQLException {
	logger.info("isAutoIncrement" + " , " + arg0 );
	boolean result = target.isAutoIncrement(arg0);
	logger.info("isAutoIncrement result is " + result);
	return result;
}

public int getColumnType(int arg0) throws java.sql.SQLException {
	logger.info("getColumnType" + " , " + arg0 );
	int result = target.getColumnType(arg0);
	logger.info("getColumnType result is " + result);
	return result;
}

public String getColumnTypeName(int arg0) throws java.sql.SQLException {
	logger.info("getColumnTypeName" + " , " + arg0 );
	String result = target.getColumnTypeName(arg0);
	logger.info("getColumnTypeName result is " + result);
	return result;
}

public boolean isSearchable(int arg0) throws java.sql.SQLException {
	logger.info("isSearchable" + " , " + arg0 );
	boolean result = target.isSearchable(arg0);
	logger.info("isSearchable result is " + result);
	return result;
}

public int getColumnCount() throws java.sql.SQLException {
	// logger.info("getColumnCount");
	int result = target.getColumnCount();
	// logger.info("getColumnCount result is " + result);
	return result;
}

public int getPrecision(int arg0) throws java.sql.SQLException {
	logger.info("getPrecision" + " , " + arg0 );
	int result = target.getPrecision(arg0);
	logger.info("getPrecision result is " + result);
	return result;
}

public String getCatalogName(int arg0) throws java.sql.SQLException {
	logger.info("getCatalogName" + " , " + arg0 );
	String result = target.getCatalogName(arg0);
	logger.info("getCatalogName result is " + result);
	return result;
}

public int getScale(int arg0) throws java.sql.SQLException {
	logger.info("getScale" + " , " + arg0 );
	int result = target.getScale(arg0);
	logger.info("getScale result is " + result);
	return result;
}

public String getColumnName(int arg0) throws java.sql.SQLException {
	// logger.info("getColumnName" + " , " + arg0 );
	String result = target.getColumnName(arg0);
	// logger.info("getColumnName result is " + result);
	return result;
}

public String getColumnLabel(int arg0) throws java.sql.SQLException {
	// logger.info("getColumnLabel" + " , " + arg0 );
	String result = target.getColumnLabel(arg0);
	// logger.info("getColumnLabel result is " + result);
	return result;
}

public String getColumnClassName(int arg0) throws java.sql.SQLException {
	logger.info("getColumnClassName" + " , " + arg0 );
	String result = target.getColumnClassName(arg0);
	logger.info("getColumnClassName result is " + result);
	return result;
}

public boolean isCaseSensitive(int arg0) throws java.sql.SQLException {
	logger.info("isCaseSensitive" + " , " + arg0 );
	boolean result = target.isCaseSensitive(arg0);
	logger.info("isCaseSensitive result is " + result);
	return result;
}

public String getTableName(int arg0) throws java.sql.SQLException {
	logger.info("getTableName" + " , " + arg0 );
	String result = target.getTableName(arg0);
	logger.info("getTableName result is " + result);
	return result;
}

public boolean isWritable(int arg0) throws java.sql.SQLException {
	logger.info("isWritable" + " , " + arg0 );
	boolean result = target.isWritable(arg0);
	logger.info("isWritable result is " + result);
	return result;
}

public int isNullable(int arg0) throws java.sql.SQLException {
	logger.info("isNullable" + " , " + arg0 );
	int result = target.isNullable(arg0);
	logger.info("isNullable result is " + result);
	return result;
}

public boolean isCurrency(int arg0) throws java.sql.SQLException {
	logger.info("isCurrency" + " , " + arg0 );
	boolean result = target.isCurrency(arg0);
	logger.info("isCurrency result is " + result);
	return result;
}

public boolean isSigned(int arg0) throws java.sql.SQLException {
	logger.info("isSigned" + " , " + arg0 );
	boolean result = target.isSigned(arg0);
	logger.info("isSigned result is " + result);
	return result;
}

public String getSchemaName(int arg0) throws java.sql.SQLException {
	logger.info("getSchemaName" + " , " + arg0 );
	String result = target.getSchemaName(arg0);
	logger.info("getSchemaName result is " + result);
	return result;
}


public <T> T unwrap(java.lang.Class<T> arg0) throws java.sql.SQLException {
	logger.info("unwrap" + " , " + arg0 );
	T result = target.unwrap(arg0);
	logger.info("unwrap result is " + result);
	return result;
}

public boolean isWrapperFor(java.lang.Class<?> arg0) throws java.sql.SQLException {
	logger.info("isWrapperFor" + " , " + arg0 );
	boolean result = target.isWrapperFor(arg0);
	logger.info("isWrapperFor result is " + result);
	return result;
}


	
	
}
