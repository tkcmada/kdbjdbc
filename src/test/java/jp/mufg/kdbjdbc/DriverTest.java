package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class DriverTest {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DriverTest.class);

    @Test
    public void test_DatabaseMetadata_columns() throws ClassNotFoundException, SQLException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        DatabaseMetaData meta = h.getMetaData();
        ResultSet rs = meta.getColumns("catalog1", "schema1", null, null);
        while(rs.next()) {
            logger.info("column:{}", rs.getString("COLUM_NAME")); //need to wrap result to offer getString(String)
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
        ResultSet rs = e.executeQuery("q) flip ( `name`lg ! (`abc`def; 1 2) )");
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
        ResultSet rs = e.executeQuery("q) select lg from t2");
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
    public void test_PreparedStatement_t2() throws SQLException, ClassNotFoundException {
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Class.forName("jp.mufg.logjdbc.LogDriver");
        Connection h = DriverManager.getConnection("jdbc:log:jdbc:kdb:localhost:5001","user_dummy","password_dummy");
        PreparedStatement e = h.prepareStatement("q) select lg from t2");
        ResultSet rs = e.executeQuery();
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