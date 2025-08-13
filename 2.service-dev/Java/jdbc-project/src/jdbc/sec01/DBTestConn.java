package jdbc.sec01;

import java.sql.*; // database 관련 class
import io.github.cdimascio.dotenv.Dotenv; // .env 사용을 위함

public class DBTestConn {
    private static final Dotenv dotenv = Dotenv.configure()
            .directory("./jdbc-project/.env")
            .load(); // .env configure

    public static void main(String[] args) {
        String url = dotenv.get("DB_URL"); //
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        // JDBC 연결을 위한 변수 선언
        // Connection: DB 연결을 위한 인터페이스
        Connection conn = null;
        // Statement: SQL 문을 실행하기 위한 인터페이스
        Statement stmt = null;
        // ResultSet: SQL 쿼리의 결과를 저장하는 인터페이스
        // ResultSet은 SELECT 쿼리의 결과를 저장하는 객체
        // ResultSet은 커서(cursor)를 사용하여 결과를 순차적으로 읽어들임
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // DB 연결
            // DriverManager.getConnection() 메서드를 사용하여 DB에 연결
            // URL, 사용자 이름, 비밀번호를 인자로 전달
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database.");

            // SQL 쿼리 실행
            // Statement 객체를 사용하여 SQL 쿼리를 실행
            stmt = conn.createStatement();
            // 쿼리 실행 결과를 ResultSet에 저장
            rs = stmt.executeQuery("SELECT SYSDATE FROM DUAL");

            // ResultSet에서 결과를 읽어오기
            if (rs.next()) {
                // ResultSet의 첫 번째 컬럼 값을 가져와 출력
                System.out.println("Current date is " + rs.getTimestamp(1));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        } finally {
            // 리소스 정리
            try {
                // ResultSet, Statement, Connection 객체를 닫아 리소스 해제
                // ResultSet 객체는 쿼리 결과를 저장하므로, 사용 후 닫아야 함
                if (rs != null) rs.close();
                // Statement 객체는 SQL 쿼리를 실행하는 데 사용되므로, 쿼리 실행 후 닫아야 함
                if (stmt != null) stmt.close();
                // Connection 객체는 DB 연결을 관리하므로, 사용 후 닫아야 함
                if (conn != null) conn.close();

                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}