package kr.bluenyang.webgame.common.util;

import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Utility class for managing database connections using a DataSource.
 */
@Slf4j
public class DBConnect {
    // DataSource for managing connections
    private DataSource ds;

    public DBConnect() {
        // Initialize the DataSource
        log.info("DBConnect - Initializing DataSource");
        try {
            // Context lookup for ds, "jdbc/OracleXE". from context.xml
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/OracleXE");
        } catch (NamingException e) {
            log.error("Data Source Initialization Error: {}", e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        log.info("DBConnect.getConnection - Getting a connection from the DataSource...");
        return this.ds.getConnection();
    }

    /**
     * Close the given resources.
     *
     * @param conn java.sql.Connection object
     * @param ps   java.sql.PreparedStatement object
     * @param rs   java.sql.ResultSet object
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        log.info("DBConnect.close - Closing resources...");
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            log.error("DBConnect.close - Error closing resources: {}", e.getMessage());
        } finally {
            log.info("DBConnect.close - Resources Closed Successfully");
        }
    }
}
