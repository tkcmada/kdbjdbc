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
        logger.info("loading kdb jdbc driver...");
        try {
            Class.forName("jdbc");
        }
        catch(ClassNotFoundException ex) {
            throw new SQLException("Cannot kdb native jdbc driver. jdbc.jar should be downloaded from https://github.com/KxSystems/kdb/tree/master/c/jdbc.jar and located in class path.", ex);
        }
        String host_port = url.substring(KdbDriver.URI_PREFIX.length());
        String qconnstr = "jdbc:q:" + host_port;
        logger.info("KdbDriver ver 20200714-3 connecting to " + qconnstr + " " + String.valueOf(info));
        Connection conn = DriverManager.getConnection(qconnstr, info);
        return new KdbConnection(conn);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith(URI_PREFIX);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        throw new UnsupportedOperationException("not support");
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 1;
    }

    @Override
    public boolean jdbcCompliant() {
        return true;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new SQLFeatureNotSupportedException("getParentLogger is not supported");
    }   
}