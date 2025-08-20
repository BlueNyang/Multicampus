package jdbc.sec05;

import java.sql.*;

public class InsertMain {
    public static void main(String[] args) {
        // DBConnect 객체 생성
        DBConnect dbconnect = new DBConnect();
        // DB 연결을 위한 Connection 객체 생성
        Connection conn = dbconnect.getConnection();
        // DB Query 실행을 위한 Statement 객체 선언
        PreparedStatement pstmt = null;

        String bookNo = "1016";
        String bookName = "Java Programming";
        String bookAuthor = "John Doe";
        int bookPrice = 25000;
        String bookDate = "2024-05-07";
        int bookStock = 10;
        String pubNo = "1";

        try {
            // DB 연결이 성공적으로 이루어진 경우
            if (conn != null) {
                // SQL 쿼리 실행
                String sql = "INSERT INTO book VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

                pstmt = conn.prepareStatement(sql);

                // PreareStatement.setXXX(idx, value) 메서드를 사용하여 파라미터 설정
                pstmt.setString(1, bookNo);
                pstmt.setString(2, bookName);
                pstmt.setString(3, bookAuthor);
                pstmt.setInt(4, bookPrice);
                pstmt.setString(5, bookDate);
                pstmt.setInt(6, bookStock);
                pstmt.setString(7, pubNo);

                int result = pstmt.executeUpdate(); // SQL 쿼리 실행

                // 결과 출력
                if (result > 0) {
                    System.out.println("도서 정보가 성공적으로 추가되었습니다.");
                } else {
                    System.out.println("도서 정보 추가에 실패했습니다.");
                }
            }
        } catch (SQLException e) {
            // SQL 실행 중 오류가 발생한 경우
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt, null);
        }
    }
}
