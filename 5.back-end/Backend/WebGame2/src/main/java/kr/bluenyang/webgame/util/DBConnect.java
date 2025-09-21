package kr.bluenyang.webgame.util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class DBConnect {
    private DataSource ds;

    public DBConnect() {
        log.info("DBConnect - Initializing DataSource");
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/OracleXE");
        } catch (NamingException e) {
            log.error("Data Source Initialization Error: {}", e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        log.info("DBConnect.close - Closing resources");
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            log.error("DBConnect.close - Error closing resources: {}", e.getMessage());
        }
    }
}
