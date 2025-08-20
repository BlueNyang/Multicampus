package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBConnect {
    private final String url;
    private final String username;
    private final String password;

    public DBConnect() {
        final Dotenv dotenv = Dotenv.configure()
                .directory("./jdbc-project/.env")
                .load(); // .env configure

        this.url = dotenv.get("DB_URL");
        this.username = dotenv.get("DB_USERNAME");
        this.password = dotenv.get("DB_PASSWORD");
    }

    /**
     * Get a connection to the database.
     *
     * @return Connection object if successful, null otherwise.
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
            return null;
        }
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Connection close error: " + e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Statement close error: " + e.getMessage());
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("ResultSet close error: " + e.getMessage());
            }
        }
    }

    public static void close(PreparedStatement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
    }

    public static void close(Connection con, PreparedStatement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
        close(con);
    }
}
