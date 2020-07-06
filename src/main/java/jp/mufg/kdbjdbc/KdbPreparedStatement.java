package jp.mufg.kdbjdbc;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;

import jp.mufg.kdbjdbc.KdbDatabaseMetaData.ColumnAndType;
import jp.mufg.slf4j.FileLogger;

public class KdbPreparedStatement extends KdbStatement implements PreparedStatement {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(KdbPreparedStatement.class);

    private final String sql;
    private final String q;
    private final LinkedHashMap<String, KdbDatabaseMetaData.ColumnAndType> colnametype2;
    private final ColumnInfo[] cols;
    // private final ResultSetMetaDataImpl rsmeta;

    KdbPreparedStatement(String sql, Statement kdbstmt, KdbDatabaseMetaData metadata) throws SQLException {
        super(kdbstmt, metadata);
        this.sql = sql;
        logger.info("converting sql..." + sql);
        SqlSelectToQscriptTranslator sqltoq = new SqlSelectToQscriptTranslator(sql);

        sqltoq.convertLiteralType(metadata);
        this.q = sqltoq.toQscript();
        logger.info("converted q-script>>>" + q + "<<<");
        this.colnametype2 = metadata.getColumnAndType("(" + q + ")");

        List<ColumnInfo> cols = new ArrayList<ColumnInfo>();
        for(KdbDatabaseMetaData.ColumnAndType e : colnametype2.values()) {
            String colname = SqlSelectToQscriptTranslator.dequoteColumnName(e.name);
            Character coltypeobj = e.type;
            cols.add(new ColumnInfo(colname, coltypeobj.toString(), true));
        }
        this.cols = cols.toArray(new ColumnInfo[cols.size()]);
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
        java.util.List<Object[]> rows = new ArrayList<Object[]>();

        final String qscript = "q) " + q;
        logger.info("execute on kdb+...>>>" + qscript + "<<<");
        ResultSet rs = target.executeQuery(qscript);
        while(rs.next()) {
            Object[] row = new Object[cols.length];
            int i = 1;
            for(ColumnAndType e : colnametype2.values()) {
                char coltype = e.type;
                Object obj = rs.getObject(i);
                logger.info("ResultSet get value..." + i + " coltype:" + coltype + " value=" + obj + "(" + (obj == null ? "null" : obj.getClass().getName()) + ")");
                switch(coltype) {
                    case 'b':
                        boolean blval = rs.getBoolean(i);
                        row[i-1] = blval;
                        break;
                    case 'x':
                        byte btval = rs.getByte(i);
                        row[i-1] = btval;
                        break;
                    case 'h':
                        short stval = rs.getShort(i);
                        row[i-1] = stval;
                        break;
                    case 'i':
                        int ival = rs.getInt(i);
                        row[i-1] = ival;
                        break;
                    case 'j':
                        long lgval = rs.getLong(i);
                        row[i-1] = lgval;
                        break;
                    case 'e':
                        float realval = rs.getFloat(i);
                        row[i-1] = realval;
                        break;
                    case 'f':
                        double dblval = rs.getDouble(i);
                        row[i-1] = dblval;
                        break;
                    case 'p':
                        Timestamp tsval = (Timestamp)rs.getObject(i);
                        row[i-1] = tsval; //KdbUtil.toVarChar(tsval);
                        break;
                    case 'C':
                        row[i-1] = rs.getString(i);
                        break;
                    // case 'B':
                    //     boolean[] abl = (boolean[]) rs.getObject(i);
                    //     row[i-1] = KdbUtil.toVarChar(abl);
                    //     break;
                    case 'X':
                        byte[] ab = (byte[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(ab);
                        break;
                    // case 'H':
                    //     short[] as = (short[]) rs.getObject(i);
                    //     row[i-1] = KdbUtil.toVarChar(as);
                    //     break;
                    case 'I':
                        int[] ai = (int[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(ai);
                        break;
                    case 'J':
                        long[] al = (long[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(al);
                        break;
                    // case 'E':
                    //     float[] ae = (float[]) rs.getObject(i);
                    //     row[i-1] = KdbUtil.toVarChar(ae);
                    //     break;
                    case 'F':
                        double[] ad = (double[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(ad);
                        break;
                    case 'S': //list of symbol
                        String[] as = (String[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(as);
                        break;
                    case 'P': //list of timestamp
                        Timestamp[] ats = (Timestamp[]) rs.getObject(i);
                        row[i-1] = KdbUtil.toVarChar(ats);
                        break;
                    // case 'G':
                    //     Object[] ag = (Object[]) rs.getObject(i);
                    //     row[i-1] = Arrays.toString(ag);
                    //     break;
                    default:
                        Object val = rs.getObject(i);
                        logger.info("getObject " + i + " " + val + "(" + (val == null ? "null" : val.getClass().getName()) + ")");
                        row[i-1] = val == null ? null : val.toString();
                }
                i++;
            }
            rows.add(row);
        }
        this.rs = new ResultSetImpl(getMetaData(), rows);
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
	public ResultSetMetaData getMetaData() throws SQLException {
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