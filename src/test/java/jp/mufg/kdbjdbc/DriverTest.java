package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.Level;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class DriverTest {
    // private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DriverTest.class);

    @Test
    public void test_arithmatic() throws ClassNotFoundException, SQLException {
        System.out.println("debug print test.");
        Class.forName("jp.mufg.kdbjdbc.KdbDriver");
        Connection h = DriverManager.getConnection("jdbc:kdb:localhost:5001","","");
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
    public void test_Statement_t2() throws SQLException {
        Connection h = DriverManager.getConnection("jdbc:kdb:localhost:5001","","");
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
    public void test_PreparedStatement_t2() throws SQLException {
        Connection h = DriverManager.getConnection("jdbc:kdb:localhost:5001","","");
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