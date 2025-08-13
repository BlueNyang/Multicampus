package jdbc.ex01;

import java.sql.*;

public class PrdDBConnectMain {
    public static void main(String[] args) {
        // DBConnect 객체 생성
        // DBConnect 클래스는 DB 연결을 위한 설정을 포함
        PrdDBConnect dbconnect = new PrdDBConnect();

        // DB 연결을 위한 Connection 객체 생성
        Connection conn = dbconnect.getConnection();
        // DB Query 실행을 위한 Statement 객체와 ResultSet 객체 선언
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // DB 연결이 성공적으로 이루어진 경우
            if (conn != null) {
                // statement 객체 생성
                stmt = conn.createStatement();

                // SQL 쿼리 실행
                // product 테이블에서 모든 데이터를 prd_no 기준으로 정렬하여 조회
                String sql = "SELECT * FROM product ORDER BY prd_no";
                rs = stmt.executeQuery(sql);

                // 결과 출력
                while (rs.next()) {
                    // 각 컬럼의 데이터를 가져와서 출력
                    String prd_no = rs.getString("prd_no").trim();
                    String name = rs.getString("prd_name").trim();
                    Integer price = rs.getInt("prd_price");
                    String company = rs.getString("prd_company").trim();
                    System.out.printf("%-10s %-20s %6d %10s\n", prd_no, name, price, company);
                }
            }
        } catch (SQLException e) {
            // SQL 실행 중 오류가 발생한 경우
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } finally {
            // 자원 해제
            try {
                // ResultSet, Statement, Connection 객체를 닫음
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                // 자원 해제 중 오류가 발생한 경우
                System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
            }
        }
    }
}
