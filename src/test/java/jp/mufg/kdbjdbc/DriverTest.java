package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
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


    @Test
    public void test_DatabaseMetadata_columns() throws ClassNotFoundException, SQLException {
        setup();
        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getColumns(null, "public", "t2", null);
        while(rs.next()) {
            logger.info("column:{}", rs.getString("COLUMN_NAME")); //need to wrap result to offer getString(String)
        }
        rs.close();
    }

//     @Test
//     public void test_arithmatic() throws ClassNotFoundException, SQLException {
//          setup();
//         Statement e = conn.createStatement();
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

    @Test
    public void test_DatabaseMetaData_getTables() throws SQLException {
        setup();

        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getTables("testdb", "public", null, null);
        List<String> tables = new ArrayList<String>();
        while(rs.next()) {
            tables.add(rs.getString("table_name"));
        }
        rs.close();
        Collections.sort(tables);
        Assert.assertEquals("[MarketBooks, MarketBooksNoNull, t2, t3, t4]", tables.toString());
    }

    @Test
    public void test_DatabaseMetaData_getColumns() throws SQLException {
        setup();

        DatabaseMetaData meta = conn.getMetaData();
        ResultSet rs = meta.getColumns("testdb", "public", "t2", null);

        Assert.assertTrue(rs.next());
        Assert.assertEquals("name"          , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.VARCHAR   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("bl"            , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.BIT       , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("bt"            , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.TINYINT   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("x"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.INTEGER   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("lg"            , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.BIGINT    , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("r"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.REAL      , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("f"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.FLOAT     , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("date"          , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.VARCHAR   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("z"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.TIMESTAMP , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("ts"            , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.VARCHAR   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("c"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.VARCHAR   , rs.getInt("DATA_TYPE"));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("g"             , rs.getString("COLUMN_NAME"));
        Assert.assertEquals(Types.VARCHAR   , rs.getInt("DATA_TYPE"));


        Assert.assertFalse(rs.next());

        rs.close();
    }


    @Test
    public void test_Statement_q_t2() throws SQLException, ClassNotFoundException {
        setup();

        Statement e = conn.createStatement();
        e.executeQuery("SELECT t2.name AS \"name:xxx\" , t2.bl as bl, t2.bt as bt, t2.x as x, t2.lg as lg, t2.r as r, t2.f as f, t2.date as date, t2.z as z, t2.ts as ts, t2.c as c, t2.g as g FROM 'public'.'t2' 't2'".replace("'", "\""));
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(12, meta.getColumnCount());

        int p = 0;

        p++;
        Assert.assertEquals("name:xxx"  , meta.getColumnName(p));
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
        Assert.assertEquals(Types.REAL   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("f"     , meta.getColumnName(p));
        Assert.assertEquals("f"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("date"  , meta.getColumnName(p));
        Assert.assertEquals("d"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("z"     , meta.getColumnName(p));
        Assert.assertEquals("p"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

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
        Assert.assertEquals("abc"   , rs.getString("name:xxx"));
        Assert.assertEquals("abc"   , rs.getString(1));
        Assert.assertTrue(rs.getBoolean("bl"));
        Assert.assertTrue(rs.getBoolean(2   ));
        Assert.assertEquals(0x26    , rs.getByte("bt"));
        Assert.assertEquals(0x26    , rs.getByte(3   ));
        Assert.assertEquals(100     , rs.getInt("x"));
        Assert.assertEquals(100     , rs.getInt(4  ));
        Assert.assertEquals(1000L   , rs.getLong("lg"));
        Assert.assertEquals(1000L   , rs.getLong(5   ));
        Assert.assertEquals(1.2f    , rs.getFloat("r")  , 0.0001f);
        Assert.assertEquals(1.2f    , rs.getFloat( 6 )  , 0.0001f);
        Assert.assertEquals(1.5f    , rs.getDouble("f"), 0.00001);
        Assert.assertEquals(1.5f    , rs.getDouble( 7 ), 0.00001);
        Assert.assertEquals("2015-01-01", rs.getObject("date"));
        Assert.assertEquals("2015-01-01", rs.getObject( 8 ));
        Assert.assertEquals(new Timestamp(2015 - 1900, Calendar.JANUARY, 1, 1, 2, 3, 1002030), rs.getTimestamp("z", Calendar.getInstance()));
        Assert.assertEquals(new Timestamp(2015 - 1900, Calendar.JANUARY, 1, 1, 2, 3, 1002030), rs.getObject("z"));
//        Assert.assertEquals("2015.01.01D01:02:03.001002030"      , rs.getObject("z")); //varchar version
        Assert.assertEquals("01:02:03.001002000", rs.getObject("ts"));
        Assert.assertEquals("01:02:03.001002000", rs.getObject(10  ));
        Assert.assertEquals("a"     , rs.getObject("c"));
        Assert.assertEquals("a"     , rs.getObject(11 ));
        Assert.assertNotNull(rs.getObject("g"));
        Assert.assertNotNull(rs.getObject(12 ));


        // Assert.assertTrue(rs.next());
        // Assert.assertEquals(null, rs.getString(1));
        // Assert.assertEquals(0, rs.getInt(2)); // 0Ni -> 0
        // Assert.assertEquals(0L, rs.getLong(3)); // 0Nj -> 0

        // Assert.assertFalse(rs.next());

        rs.close();
        e.close();;
    }

    @Test
    public void test_Statement_q_t4() throws SQLException, ClassNotFoundException {
        setup();

        Statement e = conn.createStatement();
        e.executeQuery("SELECT t4.c1 AS 'c1', t4.ll AS 'll', t4.lb AS 'lb', t4.li AS 'li', t4.ls AS 'ls', t4.lf AS 'lf', t4.lz AS 'lz' FROM 'public'.'t4' 't4'".replace("'", "\""));
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(7, meta.getColumnCount());

        int p = 0;

        p++;
        Assert.assertEquals("c1"    , meta.getColumnName(p));
        Assert.assertEquals("j"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.BIGINT   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("ll"    , meta.getColumnName(p));
        Assert.assertEquals("J"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("lb"    , meta.getColumnName(p));
        Assert.assertEquals("X"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("li"    , meta.getColumnName(p));
        Assert.assertEquals("I"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("ls"    , meta.getColumnName(p));
        Assert.assertEquals("S"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("lf"    , meta.getColumnName(p));
        Assert.assertEquals("F"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        p++;
        Assert.assertEquals("lz"     , meta.getColumnName(p));
        Assert.assertEquals("P"     , meta.getColumnTypeName(p));
        Assert.assertEquals(Types.VARCHAR   , meta.getColumnType(p));

        Assert.assertTrue(rs.next());
        Assert.assertEquals(0L       , rs.getObject("c1"));
        Assert.assertEquals("10 20"  , rs.getString("ll"));
        Assert.assertEquals("0x0001" , rs.getString("lb"));
        Assert.assertEquals("0 1"    , rs.getString("li"));
        Assert.assertEquals("`abc`def", rs.getString("ls"));
        Assert.assertEquals("1.0 1.1" , rs.getString("lf"));
        Assert.assertEquals("1970.01.04D00:00:00.001002003 1970.01.04D00:00:00.001002003", rs.getObject("lz"));

        rs.close();
        e.close();;
    }

    @Test
    public void test_Statement_q_t2_group_by_d() throws SQLException, ClassNotFoundException {
        setup();

        Statement e = conn.createStatement();
        e.executeQuery("SELECT t2.date AS date FROM 'public'.'t2' 't2' GROUP BY 1".replace("'", "\""));
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(1, meta.getColumnCount());

        int p = 0;

        p++;
        Assert.assertEquals("date"  , meta.getColumnName(p));
        Assert.assertEquals("d"     , meta.getColumnTypeName(p));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("2015-01-01", rs.getObject("date"));
        Assert.assertEquals("2015-01-01", rs.getObject(1));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("1970-01-04", rs.getObject("date"));
        Assert.assertEquals("1970-01-04", rs.getObject(1));

        Assert.assertTrue(rs.next());
        Assert.assertNull(rs.getObject("date"));
        Assert.assertNull(rs.getObject(1));

        Assert.assertFalse(rs.next());

        rs.close();
        e.close();;
    }

    @Test
    public void test_Statement_q_t2_where_date_equals() throws SQLException, ClassNotFoundException {
        setup();

        Statement e = conn.createStatement();
        Assert.assertTrue(e.execute("SELECT t2.date AS date, SUM(t2.f) AS \"sum:f:ok\" FROM \"public\".\"t2\" \"t2\" WHERE (t2.date = '1970-01-04') GROUP BY 1"));
        ResultSet rs = e.getResultSet();
        ResultSetMetaData meta = rs.getMetaData();
        Assert.assertEquals(2, meta.getColumnCount());

        int p = 0;

        p++;
        Assert.assertEquals("date"  , meta.getColumnName(p));
        Assert.assertEquals("d"     , meta.getColumnTypeName(p));

        p++;
        Assert.assertEquals("sum:f:ok"  , meta.getColumnName(p));
        Assert.assertEquals("f"     , meta.getColumnTypeName(p));

        Assert.assertTrue(rs.next());
        Assert.assertEquals("1970-01-04", rs.getObject("date"));
        Assert.assertEquals(1.4         , rs.getObject("sum:f:ok"));

        // Assert.assertFalse(rs.next());

        rs.close();
        e.close();;
    }
}