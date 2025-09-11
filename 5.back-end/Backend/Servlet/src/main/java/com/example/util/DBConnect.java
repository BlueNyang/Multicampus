package com.example.util;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBConnect {
    private final String url;
    private final String username;
    private final String password;
    private final String driver;

    public DBConnect() {
        final Dotenv dotenv = Dotenv.load();

        this.url = dotenv.get("DB_URL");
        this.username = dotenv.get("DB_USERNAME");
        this.password = dotenv.get("DB_PASSWORD");
        this.driver = dotenv.get("DB_DRIVER");
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결 성공");
            return conn;
        } catch (java.sql.SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
            return null;
        }
    }


    public static void close(Connection conn) {
        // 자원 해제 메소드
        try {
            if (conn != null) conn.close();
            conn = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    public static void close(Connection conn, PreparedStatement pstmt) {
        // 자원 해제 메소드
        close(conn, pstmt, null);
    }

    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        // 자원 해제 메소드
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            conn = null;
            pstmt = null;
            rs = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    public static void close(PreparedStatement pstmt, ResultSet rs) {
        close(null, pstmt, rs);
    }

    public static void close(PreparedStatement pstmt) {
        close(null, pstmt, null);
    }

    public static void close(ResultSet rs) {
        close(null, null, rs);
    }
}
