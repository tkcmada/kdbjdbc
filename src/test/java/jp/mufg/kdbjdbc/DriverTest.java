package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class DriverTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DriverTest.class);

    private Connection conn;

    private void setup() throws SQLException {
        try {
            Class.forName("jp.mufg.kdbjdbc.KdbDriver");
            Class.forName("jp.mufg.logjdbc.LogDriver");
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        // this.conn = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        this.conn = DriverManager.getConnection("jdbc:kdb:localhost:5001","user_dummy","password_dummy");
    }

    @After
    public void tearDown() {
        if(conn != null) {
            try { conn.close(); } catch(SQLException ignored) {}
            conn = null;
        }
    }

//     @Test
//     public void test_DatabaseMetadata_columns() throws ClassNotFoundException, SQLException {
//         Class.forName("jp.mufg.kdbjdbc.KdbDriver");
//         Class.forName("jp.mufg.logjdbc.LogDriver");
//         Properties props = new Properties();
//         props.put("user", "user_dummy");
//         props.put("password", "password_dummy");
//         props.put("logdir", ".");
//         Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001", props);
//         DatabaseMetaData meta = h.getMetaData();
//         ResultSet rs = meta.getColumns(null, "public", "t2", null);
//         while(rs.next()) {
//             logger.info("column:{}", rs.getString("COLUMN_NAME")); //need to wrap result to offer getString(String)
//         }
//         rs.close();
//         h.close();
//     }

//     @Test
//     public void test_arithmatic() throws ClassNotFoundException, SQLException {
//         Class.forName("jp.mufg.kdbjdbc.KdbDriver");
//         Class.forName("jp.mufg.logjdbc.LogDriver");
//         Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
//         Statement e = h.createStatement();
//         e.execute("q) flip ( `name`lg ! (`abc`def; 1 2) )");
//         ResultSet rs = e.getResultSet();
//         Assert.assertTrue(rs.next());
//         Assert.assertEquals("abc", rs.getString("name"));
//         Assert.assertEquals(1L   , rs.getLong("lg"));

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals("def", rs.getString("name"));
//         Assert.assertEquals(2L   , rs.getLong("lg"));

//         Assert.assertFalse(rs.next());
//         rs.close();
//         e.close();;
//         h.close();
//     }
// /*
//     @Test
//     public void test_Statement_native_q_t2() throws SQLException, ClassNotFoundException {
//         Class.forName("jp.mufg.kdbjdbc.KdbDriver");
//         Class.forName("jp.mufg.logjdbc.LogDriver");
//         Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
//         Statement e = h.createStatement();
//         e.executeQuery("q) select lg, x, name, bl, bt, r, f, d, z, t from t2");
//         ResultSet rs = e.getResultSet();

//         ResultSetMetaData meta = rs.getMetaData();
//         Assert.assertEquals(10, meta.getColumnCount());
//         Assert.assertEquals("lg"    , meta.getColumnName(1));
//         Assert.assertEquals("long"  , meta.getColumnTypeName(1));
//         Assert.assertEquals(-5      , meta.getColumnType(1));
//         Assert.assertEquals("x"     , meta.getColumnName(2));
//         Assert.assertEquals("int"   , meta.getColumnTypeName(2));
//         Assert.assertEquals(4       , meta.getColumnType(2));
//         Assert.assertEquals("name"  , meta.getColumnName(3));
//         Assert.assertEquals("symbol", meta.getColumnTypeName(3));
//         Assert.assertEquals("bl"    , meta.getColumnName(4));
//         Assert.assertEquals("boolean", meta.getColumnTypeName(4));
//         Assert.assertEquals("bt"    , meta.getColumnName(5));
//         Assert.assertEquals("byte"  , meta.getColumnTypeName(5));
//         Assert.assertEquals("r"     , meta.getColumnName(6));
//         Assert.assertEquals("real"  , meta.getColumnTypeName(6));
//         Assert.assertEquals("f"     , meta.getColumnName(7));
//         Assert.assertEquals("float" , meta.getColumnTypeName(7));
//         Assert.assertEquals("d"     , meta.getColumnName(8));
//         Assert.assertEquals("date"  , meta.getColumnTypeName(8));
//         Assert.assertEquals("z"     , meta.getColumnName(9));
//         Assert.assertEquals(0       , meta.getColumnType(9));
//         Assert.assertEquals(""      , meta.getColumnTypeName(9));    //useless !
//         Assert.assertEquals("t"     , meta.getColumnName(10));
//         Assert.assertEquals("time"  , meta.getColumnTypeName(10));

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals(1000L, rs.getLong(1));

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals(1004L, rs.getLong(1));

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals(0, rs.getLong(1)); //actually this should be Null

//         Assert.assertFalse(rs.next());
//         rs.close();
//         e.close();;
//         h.close();
//     }
//     */

//     @Test
//     public void test_DatabaseMetaData_getTables() throws SQLException {
//         setup();

//         DatabaseMetaData meta = conn.getMetaData();
//         ResultSet rs = meta.getTables("testdb", "public", null, null);
//         List<String> tables = new ArrayList<String>();
//         while(rs.next()) {
//             tables.add(rs.getString("table_name"));
//         }
//         rs.close();
//         Collections.sort(tables);
//         Assert.assertEquals("[MarketBooks, MarketBooksNoNull, t2, t3, t4]", tables.toString());
//     }

//     @Test
//     public void test_DatabaseMetaData_getColumns() throws SQLException {
//         setup();

//         DatabaseMetaData meta = conn.getMetaData();
//         ResultSet rs = meta.getColumns("testdb", "public", "t2", null);

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals("name"  , rs.getString("COLUMN_NAME"));
//         Assert.assertEquals("12"    , rs.getString("DATA_TYPE"));

//         Assert.assertTrue(rs.next());
//         Assert.assertEquals("x"     , rs.getString("COLUMN_NAME"));
//         Assert.assertEquals("4"     , rs.getString("DATA_TYPE"));

//         rs.close();
//     }


    @Test
    public void test_Statement_q_t2() throws SQLException, ClassNotFoundException {
        setup();

        Statement e = conn.createStatement();
        e.executeQuery("SELECT ");
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(12, meta.getColumnCount());

        int p = 0;

        p++;
        Assert.assertEquals("name"  , meta.getColumnName(p));
        Assert.assertEquals("s"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("bl"    , meta.getColumnName(p));
        Assert.assertEquals("b"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("bt"    , meta.getColumnName(p));
        Assert.assertEquals("x"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("x"     , meta.getColumnName(p));
        Assert.assertEquals("i"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("lg"    , meta.getColumnName(p));
        Assert.assertEquals("j"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("r"     , meta.getColumnName(p));
        Assert.assertEquals("e"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("f"     , meta.getColumnName(p));
        Assert.assertEquals("f"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("d"     , meta.getColumnName(p));
        Assert.assertEquals("d"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("z"     , meta.getColumnName(p));
        Assert.assertEquals("p"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("ts"    , meta.getColumnName(p));
        Assert.assertEquals("n"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("c"     , meta.getColumnName(p));
        Assert.assertEquals("c"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("g"     , meta.getColumnName(p));
        Assert.assertEquals("g"     , meta.getColumnTypeName(p));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("abc"   , rs.getString("name"));
        Assert.assertTrue(rs.getBoolean("bl"));
        Assert.assertEquals(0x26    , rs.getByte("bt"));
        Assert.assertEquals(100     , rs.getInt("x"));
        Assert.assertEquals(1000L   , rs.getLong("lg"));
        Assert.assertEquals(1.2f    , rs.getFloat("r")  , 0.0001f);
        Assert.assertEquals(1.5f    , rs.getDouble("f"), 0.00001);
        Assert.assertEquals("2015-01-01", rs.getObject("d"));
        Assert.assertEquals(new Timestamp(2015 - 1900, 0, 1, 1, 2, 3, 1002003), rs.getObject("z"));
        Assert.assertEquals("01:02:03.001002000", rs.getObject("ts"));
        Assert.assertEquals("a"     , rs.getObject("c"));
        Assert.assertNotNull(rs.getObject("g"));


        // Assert.assertTrue(rs.next());
        // Assert.assertEquals(null, rs.getString(1));
        // Assert.assertEquals(0, rs.getInt(2)); // 0Ni -> 0
        // Assert.assertEquals(0L, rs.getLong(3)); // 0Nj -> 0

        // Assert.assertFalse(rs.next());

        rs.close();
        e.close();;
    }
}