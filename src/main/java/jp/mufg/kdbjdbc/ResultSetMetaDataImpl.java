package jp.mufg.kdbjdbc;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;

import jp.mufg.slf4j.FileLogger;

public class ResultSetMetaDataImpl implements ResultSetMetaData {
	private static final Logger logger = FileLogger.getLogger(ResultSetMetaDataImpl.class);
	public static final int MAX = 2147483647;
	
	private final ColumnInfo[] columns;
	
	public ResultSetMetaDataImpl(ColumnInfo...columns) {
		super();
		this.columns =  columns;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.unwrap is not supported");
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isWrapperFor is not supported");
		
	}

	@Override
	public int getColumnCount() throws SQLException {
		return columns.length;
	}

	@Override
	public boolean isAutoIncrement(int column) throws SQLException {
		logger.info("isAutoIncrement");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isAutoIncrement is not supported");
		
	}

	@Override
	public boolean isCaseSensitive(int column) throws SQLException {
		logger.info("isCaseSensitive");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isCaseSensitive is not supported");
		
	}

	@Override
	public boolean isSearchable(int column) throws SQLException {
		logger.info("isSearchable");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isSearchable is not supported");
		
	}

	@Override
	public boolean isCurrency(int column) throws SQLException {
		logger.info("isCurrency");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isCurrency is not supported");
		
	}

	@Override
	public int isNullable(int column) throws SQLException {
		return columns[column-1].isNullable();
	}

	@Override
	public boolean isSigned(int column) throws SQLException {
		logger.info("isSigned");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isSigned is not supported");
		
	}

	@Override
	public int getColumnDisplaySize(int column) throws SQLException {
		return columns[column-1].getColumnDisplaySize();
	}

	@Override
	public String getColumnLabel(int column) throws SQLException {
		return columns[column-1].getColumnLabel();
	}

	@Override
	public String getColumnName(int column) throws SQLException {
		return columns[column-1].getColumnName();
	}

	@Override
	public String getSchemaName(int column) throws SQLException {
		logger.info("getSchemaName");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.getSchemaName is not supported");
		
	}

	@Override
	public int getPrecision(int column) throws SQLException {
		return columns[column-1].getPrecision();
	}

	@Override
	public int getScale(int column) throws SQLException {
		return columns[column-1].getScale();
	}

	@Override
	public String getTableName(int column) throws SQLException {
		logger.info("getTableName");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.getTableName is not supported");
		
	}

	@Override
	public String getCatalogName(int column) throws SQLException {
		logger.info("getCatalogName");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.getCatalogName is not supported");
		
	}

	@Override
	public int getColumnType(int column) throws SQLException {
		return columns[column-1].getColumnType();
	}

	@Override
	public String getColumnTypeName(int column) throws SQLException {
		return columns[column-1].getColumnTypeName();
	}

	@Override
	public boolean isReadOnly(int column) throws SQLException {
		logger.info("isReadOnly");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isReadOnly is not supported");
		
	}

	@Override
	public boolean isWritable(int column) throws SQLException {
		logger.info("isWritable");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isWritable is not supported");
		
	}

	@Override
	public boolean isDefinitelyWritable(int column) throws SQLException {
		logger.info("isDefinitelyWritable");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.isDefinitelyWritable is not supported");
		
	}

	@Override
	public String getColumnClassName(int column) throws SQLException {
		logger.info("getColumnClassName");
		throw new UnsupportedOperationException("ResultSetMetaDataImpl.getColumnClassName is not supported");
		
	}

}
