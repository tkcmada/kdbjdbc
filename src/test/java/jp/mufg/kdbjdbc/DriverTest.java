package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class DriverTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DriverTest.class);

    @Test
    public void test_DatabaseMetadata_columns() throws ClassNotFoundException, SQLException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Properties props = new Properties();
        props.put("user", "user_dummy");
        props.put("password", "password_dummy");
        props.put("logdir", ".");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001", props);
        DatabaseMetaData meta = h.getMetaData();
        ResultSet rs = meta.getColumns(null, "public", "t2", null);
        while(rs.next()) {
            logger.info("column:{}", rs.getString("COLUMN_NAME")); //need to wrap result to offer getString(String)
        }
        rs.close();
        h.close();
    }

    @Test
    public void test_arithmatic() throws ClassNotFoundException, SQLException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        Statement e = h.createStatement();
        e.execute("q) flip ( `name`lg ! (`abc`def; 1 2) )");
        ResultSet rs = e.getResultSet();
        Assert.assertTrue(rs.next());
        Assert.assertEquals("abc", rs.getString("name"));
        Assert.assertEquals(1L   , rs.getLong("lg"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("def", rs.getString("name"));
        Assert.assertEquals(2L   , rs.getLong("lg"));

        Assert.assertFalse(rs.next());
        rs.close();
        e.close();;
        h.close();
    }

    @Test
    public void test_Statement_native_q_t2() throws SQLException, ClassNotFoundException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        Statement e = h.createStatement();
        e.executeQuery("q) select lg, x, name, bl, bt, r, f, d, z, t from t2");
        ResultSet rs = e.getResultSet();

        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(10, meta.getColumnCount());
        Assert.assertEquals("lg"    , meta.getColumnName(1));
        Assert.assertEquals("long"  , meta.getColumnTypeName(1));
        Assert.assertEquals(-5      , meta.getColumnType(1));
        Assert.assertEquals("x"     , meta.getColumnName(2));
        Assert.assertEquals("int"   , meta.getColumnTypeName(2));
        Assert.assertEquals(4       , meta.getColumnType(2));
        Assert.assertEquals("name"  , meta.getColumnName(3));
        Assert.assertEquals("symbol", meta.getColumnTypeName(3));
        Assert.assertEquals("bl"    , meta.getColumnName(4));
        Assert.assertEquals("boolean", meta.getColumnTypeName(4));
        Assert.assertEquals("bt"    , meta.getColumnName(5));
        Assert.assertEquals("byte"  , meta.getColumnTypeName(5));
        Assert.assertEquals("r"     , meta.getColumnName(6));
        Assert.assertEquals("real"  , meta.getColumnTypeName(6));
        Assert.assertEquals("f"     , meta.getColumnName(7));
        Assert.assertEquals("float" , meta.getColumnTypeName(7));
        Assert.assertEquals("d"     , meta.getColumnName(8));
        Assert.assertEquals("date"  , meta.getColumnTypeName(8));
        Assert.assertEquals("z"     , meta.getColumnName(9));
        Assert.assertEquals(0       , meta.getColumnType(9));
        Assert.assertEquals(""      , meta.getColumnTypeName(9));    //useless !
        Assert.assertEquals("t"     , meta.getColumnName(10));
        Assert.assertEquals("time"  , meta.getColumnTypeName(10));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(1000L, rs.getLong(1));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(1004L, rs.getLong(1));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(0, rs.getLong(1)); //actually this should be Null

        Assert.assertFalse(rs.next());
        rs.close();
        e.close();;
        h.close();
    }

    @Test
    public void test_Statement_q_t2() throws SQLException, ClassNotFoundException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        Statement e = h.createStatement();
        e.executeQuery("SELECT ");
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(2, meta.getColumnCount());
        Assert.assertEquals("id"    , meta.getColumnName(1));
        Assert.assertEquals("int4"  , meta.getColumnTypeName(1));
        Assert.assertEquals("name"  , meta.getColumnName(2));
        Assert.assertEquals("text"  , meta.getColumnTypeName(2));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(100, rs.getInt(1));
        Assert.assertEquals("abc", rs.getString(2));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(104, rs.getInt(1));
        Assert.assertEquals("def", rs.getString(2));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(0, rs.getLong(1)); //actually this should be Null

        Assert.assertFalse(rs.next());
        rs.close();
        e.close();;
        h.close();
    }
}