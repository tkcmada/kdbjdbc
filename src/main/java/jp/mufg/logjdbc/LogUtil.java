package jp.mufg.logjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    private LogUtil() {}
    
    // public static CachedRowSet dump(ResultSet rs) throws SQLException {
    //     CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
    //     crs.populate(rs);
    //     rs.close();
    //     crs.beforeFirst();
    //     int n = crs.getMetaData().getColumnCount();
    //     String[] names = new String[n];
    //     logger.info("=====");
    //     for(int i = 1; i <= n; i++) {
    //         names[i-1] = crs.getMetaData().getColumnName(i);
    //         logger.info(i + ":" + names[i-1]);
    //     }
    //     while(crs.next()) {
    //         logger.info("-----");
    //         for(int i = 1; i <= n; i++) {
    //             logger.info(names[i-1] + ":" + crs.getObject(i));
    //         }
    //     }
    //     logger.info("=====");
    //     crs.beforeFirst();
    //     return crs;
    // }

}