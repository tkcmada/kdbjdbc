package jp.mufg.kdbjdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ResultSetWrapper extends ResultSetBase {
    private ResultSet rs;
    private boolean closed = false;

    public ResultSetWrapper(ResultSetMetaData meta, ResultSet rs) throws SQLException {
        super(meta);
        this.rs = rs;
    }

    @Override
    public Object getObjectImpl(int columnIndex) throws SQLException {
        if(closed)
            throw new SQLException("already closed");
        char coltype = meta.getColumnTypeName(columnIndex).charAt(0);
        return getObjectImpl(columnIndex, coltype);
    }

    @Override
    public void close() throws SQLException {
        rs.close();
        rs = null;
        closed = true;
    }

    @Override
    public boolean next() throws SQLException {
        if(closed)
            throw new SQLException("already closed");
        return rs.next();
    }

    private Object getObjectImpl(int i, char coltype) throws SQLException {
        // logger.info("ResultSet get value..." + i + " coltype:" + coltype + " value=" + obj + "(" + (obj == null ? "null" : obj.getClass().getName()) + ")");
        switch(coltype) {
            case 'b':
                return rs.getBoolean(i);
            case 'x':
                return rs.getByte(i);
            case 'h':
                return rs.getShort(i);
            case 'i':
                return rs.getInt(i);
            case 'j':
                return rs.getLong(i);
            case 'e':
                return rs.getFloat(i);
            case 'f':
                return rs.getDouble(i);
            case 'p':
                return (Timestamp)rs.getObject(i); //KdbUtil.toVarChar(tsval);
            case 'C':
                return rs.getString(i);
            // case 'B':
            //     boolean[] abl = (boolean[]) rs.getObject(i);
            //     row[i-1] = KdbUtil.toVarChar(abl);
            //     break;
            case 'X':
                byte[] ab = (byte[]) rs.getObject(i);
                return KdbUtil.toVarChar(ab);
            // case 'H':
            //     short[] as = (short[]) rs.getObject(i);
            //     row[i-1] = KdbUtil.toVarChar(as);
            //     break;
            case 'I':
                int[] ai = (int[]) rs.getObject(i);
                return KdbUtil.toVarChar(ai);
            case 'J':
                long[] al = (long[]) rs.getObject(i);
                return KdbUtil.toVarChar(al);
            // case 'E':
            //     float[] ae = (float[]) rs.getObject(i);
            //     row[i-1] = KdbUtil.toVarChar(ae);
            //     break;
            case 'F':
                double[] ad = (double[]) rs.getObject(i);
                return KdbUtil.toVarChar(ad);
            case 'S': //list of symbol
                String[] as = (String[]) rs.getObject(i);
                return KdbUtil.toVarChar(as);
            case 'P': //list of timestamp
                Timestamp[] ats = (Timestamp[]) rs.getObject(i);
                return KdbUtil.toVarChar(ats);
            // case 'G':
            //     Object[] ag = (Object[]) rs.getObject(i);
            //     row[i-1] = Arrays.toString(ag);
            //     break;
            default:
                Object val = rs.getObject(i);
                // logger.info("getObject " + i + " " + val + "(" + (val == null ? "null" : val.getClass().getName()) + ")");
                return val == null ? null : val.toString();
        }

    }
}