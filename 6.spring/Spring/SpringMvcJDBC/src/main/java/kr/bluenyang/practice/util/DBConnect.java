package kr.bluenyang.practice.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Component
public class DBConnect {
    private DataSource ds;

    public DBConnect(DataSource ds) {
        this.ds = ds;
        log.info("DBConnect - DataSource injected via constructor");
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
