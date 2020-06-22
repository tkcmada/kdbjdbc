package jp.mufg.kdbjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

/**
 * Sample JDBC Connection String jdbc:kdb:127.0.0.1:5001
 */
public class KdbDriver implements Driver {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(KdbDriver.class);
    public static final String URI_PREFIX = "jdbc:kdb:";

    static {
        logger.info("registering KdbDriver...");
        try {
            java.sql.DriverManager.registerDriver(new KdbDriver());
        } catch (SQLException ex) {
            throw new RuntimeException("Can't register KdbDriver!", ex);
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (!url.startsWith(URI_PREFIX)) {
            return null;
        }
        try {
            Class.forName("jdbc");
        }
        catch(ClassNotFoundException ex) {
            throw new SQLException("Cannot kdb native jdbc driver. jdbc.jar should be downloaded from https://github.com/KxSystems/kdb/tree/master/c/jdbc.jar and located in class path.", ex);
        }
        String host_port = url.substring(KdbDriver.URI_PREFIX.length());
        String qconnstr = "jdbc:q:" + host_port;
        logger.info("connecting to jdbc:q " + qconnstr + " " + String.valueOf(info));
        Connection conn = DriverManager.getConnection(qconnstr, info);
        return new KdbConnection(conn, url, info);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(URI_PREFIX);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getMajorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMinorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    
}