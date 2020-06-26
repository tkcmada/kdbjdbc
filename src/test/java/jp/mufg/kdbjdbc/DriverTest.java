package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    public void test_Statement_t2() throws SQLException, ClassNotFoundException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        Statement e = h.createStatement();
        e.executeQuery("q) select lg from t2");
        ResultSet rs = e.getResultSet();
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
}