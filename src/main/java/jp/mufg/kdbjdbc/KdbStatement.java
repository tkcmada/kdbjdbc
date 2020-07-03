package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import jp.mufg.kdbjdbc.KdbDatabaseMetaData.ColumnAndType;
import jp.mufg.slf4j.FileLogger;

public class KdbStatement implements Statement {
    private static final org.slf4j.Logger logger = FileLogger.getLogger(KdbStatement.class);
    private final Statement target;
    private final KdbDatabaseMetaData meta;
    private ResultSet rs;

    KdbStatement(Statement target, KdbDatabaseMetaData meta) {
        this.target = target;
        this.meta = meta;
    }

    private void setDummyResultSet() {
        ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(new ColumnInfo("dummy", "text", true));
        this.rs = new ResultSetImpl(meta);
    }

    @Override
    public void close() throws SQLException {
        target.close();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return target.isClosed();
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        String pure_q = null;
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
                    logger.info("converting sql..." + sql);
                    SqlSelectToQscriptTranslator sqltoq = new SqlSelectToQscriptTranslator(sql);
                    java.util.List<Object[]> rows = new ArrayList<Object[]>();

                    sqltoq.convertLiteralType(meta);
                    pure_q = sqltoq.toQscript();
                    logger.info("converted q-script>>>" + pure_q + "<<<");
                    final LinkedHashMap<String, ColumnAndType> colnametype2 = this.meta.getColumnAndType("(" + pure_q + ")");

                    // if(! pure_q.contains(" where date ")) {
                    //     throw new SQLException("date condition should be required. sql=" + sql + " q=" + pure_q);
                    // }
                    final String q = "q) " + pure_q;
                    logger.info("execute on kdb+...>>>" + q + "<<<");
                    ResultSet rs = target.executeQuery(q);
                    List<ColumnInfo> cols = new ArrayList<ColumnInfo>();
                    for(ColumnAndType e : colnametype2.values()) {
                        String colname = SqlSelectToQscriptTranslator.dequoteColumnName(e.name);
                        Character coltypeobj = e.type;
                        // if(SqlSelectToQscriptTranslator.isDummyColumn(colname))
                        //     continue;
                        cols.add(new ColumnInfo(colname, coltypeobj.toString(), true));
                    }
                    ResultSetMetaDataImpl meta = new ResultSetMetaDataImpl(cols.toArray(new ColumnInfo[cols.size()]));
                    while(rs.next()) {
                        Object[] row = new Object[cols.size()];
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
                    this.rs = new ResultSetImpl(meta, rows);
                    return true;
                }
                throw new SQLException("general SQL is not support " + sql);
            }
        }
        catch(SQLException ex) {
            logger.info("Q execution error:" + ex.getMessage() + " sql=" + sql + " q=" + pure_q, ex);
            throw new SQLException("Q execution error:" + ex.getMessage() + " sql=" + sql + " q=" + pure_q, ex);
        }
    }

    @Override
	public ResultSet getResultSet() throws SQLException {
    	return rs;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		logger.info("unwrap");
		throw new SQLException("KdbStatement.unwrap is not supported");
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		logger.info("isWrapperFor");
		throw new SQLException("KdbStatement.isWrapperFor is not supported");
		
	}

	@Override
	public ResultSet executeQuery(String sql) throws SQLException {
        logger.info("executeQuery");
        execute(sql);
        return getResultSet();
	}

	@Override
	public int executeUpdate(String sql) throws SQLException {
		logger.info("executeUpdate");
		throw new SQLException("KdbStatement.executeUpdate is not supported");
		
	}

	@Override
    public int getMaxFieldSize() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getMaxRows() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getQueryTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void cancel() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setCursorName(String name) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getUpdateCount() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFetchDirection() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getFetchSize() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getResultSetType() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void clearBatch() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int[] executeBatch() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isPoolable() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
    
}