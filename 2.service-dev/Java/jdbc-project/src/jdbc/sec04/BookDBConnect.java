package jdbc.sec04;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class BookDBConnect {
    // DB 연결을 위한 URL, 사용자명, 비밀번호
    private String url;
    // DB 연결을 위한 사용자명
    private String username;
    // DB 연결을 위한 비밀번호
    private String password;

    public BookDBConnect() {
        // .env 파일에서 DB 연결 정보를 읽어오기 위해 Dotenv 라이브러리 사용
        final Dotenv dotenv = Dotenv.configure()
                .directory("./jdbc-project/.env")
                .load(); // .env configure

        // .env 파일에서 DB 연결 정보 가져오기
        this.url = dotenv.get("DB_URL");
        this.username = dotenv.get("DB_USERNAME");
        this.password = dotenv.get("DB_PASSWORD");
    }

    public Connection getConnection() {
        try {
            // DB 연결
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
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
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            conn = null;
            pstmt = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
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
        // 자원 해제 메소드
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            pstmt = null;
            rs = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    public static void close(PreparedStatement pstmt) {
        // 자원 해제 메소드
        try {
            if (pstmt != null) pstmt.close();
            pstmt = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }

    public static void close(ResultSet rs) {
        // 자원 해제 메소드
        try {
            if (rs != null) rs.close();
            rs = null;
        } catch (SQLException e) {
            System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
        }
    }
}

