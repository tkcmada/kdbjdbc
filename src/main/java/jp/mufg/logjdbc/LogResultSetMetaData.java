package jp.mufg.logjdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogResultSetMetaData implements ResultSetMetaData {
private static final Logger logger = FileLogger.getLogger(LogResultSetMetaData.class);
	private final ResultSetMetaData meta;

	public LogResultSetMetaData(ResultSetMetaData meta) {
		super();
		this.meta = meta;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException { logger.info("unwrap");
		return meta.unwrap(iface);
	}

	public int getColumnCount() throws SQLException { //logger.info("getColumnCount");
		return meta.getColumnCount();
	}

	public boolean isAutoIncrement(int column) throws SQLException { logger.info("isAutoIncrement");
		return meta.isAutoIncrement(column);
	}

	public boolean isCaseSensitive(int column) throws SQLException { logger.info("isCaseSensitive");
		return meta.isCaseSensitive(column);
	}

	public boolean isSearchable(int column) throws SQLException { logger.info("isSearchable");
		return meta.isSearchable(column);
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException { logger.info("isWrapperFor");
		return meta.isWrapperFor(iface);
	}

	public boolean isCurrency(int column) throws SQLException { logger.info("isCurrency");
		return meta.isCurrency(column);
	}

	public int isNullable(int column) throws SQLException {
        int result = meta.isNullable(column);
        logger.info("isNullable(" + column + ") -> " + result);
		return result;
	}

	public boolean isSigned(int column) throws SQLException { logger.info("isSigned");
		return meta.isSigned(column);
	}

	public int getColumnDisplaySize(int column) throws SQLException {
        int result = meta.getColumnDisplaySize(column);
        logger.info("getColumnDisplaySize(" + column + ") -> " + result);
		return result;
    }

	public String getColumnLabel(int column) throws SQLException {
        String result = meta.getColumnLabel(column);
        logger.info("getColumnLabel(" + column + ") -> " + result);
		return result;
	}

	public String getColumnName(int column) throws SQLException { //logger.info("getColumnName");
		return meta.getColumnName(column);
	}

	public String getSchemaName(int column) throws SQLException { logger.info("getSchemaName");
		return meta.getSchemaName(column);
	}

	public int getPrecision(int column) throws SQLException {
        int result = meta.getPrecision(column);
        logger.info("getPrecision(" + column + ") -> " + result);
		return result;
	}

	public int getScale(int column) throws SQLException {
        int result = meta.getScale(column);
        logger.info("getScale(" + column + ") -> " + result);
		return result;

	}

	public String getTableName(int column) throws SQLException { logger.info("getTableName");
		return meta.getTableName(column);
	}

	public String getCatalogName(int column) throws SQLException { logger.info("getCatalogName");
		return meta.getCatalogName(column);
	}

	public int getColumnType(int column) throws SQLException {
        int result = meta.getColumnType(column);
        logger.info("getColumnType(" + column + ") -> " + result);
        return result;
	}

	public String getColumnTypeName(int column) throws SQLException {
        String result = meta.getColumnTypeName(column);
        logger.info("getColumnTypeName(" + column + ") -> " + result);
		return result;
	}

	public boolean isReadOnly(int column) throws SQLException { logger.info("isReadOnly");
		return meta.isReadOnly(column);
	}

	public boolean isWritable(int column) throws SQLException { logger.info("isWritable");
		return meta.isWritable(column);
	}

	public boolean isDefinitelyWritable(int column) throws SQLException { logger.info("isDefinitelyWritable");
		return meta.isDefinitelyWritable(column);
	}

	public String getColumnClassName(int column) throws SQLException { logger.info("getColumnClassName");
		return meta.getColumnClassName(column);
	}
	
	
	
	
}
