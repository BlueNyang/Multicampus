package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteMain {
    public static void main(String[] args) {
        DBConnect dbconnect = new DBConnect();

        // DB 연결을 위한 Connection 객체 생성
        Connection conn = dbconnect.getConnection();
        // DB Query 실행을 위한 Statement 객체 선언
        PreparedStatement pstmt = null;

        try (Scanner sc = new Scanner(System.in)) {
            String sql = "DELETE FROM book WHERE book_no = ?";
            pstmt = conn.prepareStatement(sql);

            System.out.print("삭제할 도서 번호를 입력하세요: ");
            String bookNo = sc.nextLine().trim(); // 사용자로부터 도서 번호 입력 받기

            // 입력받은 도서 번호를 PreparedStatement에 설정
            pstmt.setString(1, bookNo);

            // SQL 쿼리 실행
            int rowsAffected = pstmt.executeUpdate();

            // 실행 결과 출력
            if (rowsAffected > 0) {
                System.out.println("도서 번호 " + bookNo + "이(가) 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("도서 번호 " + bookNo + "이(가) 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            // SQL 실행 중 오류가 발생한 경우
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } catch (Exception e) {
            // 일반적인 오류가 발생한 경우
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            // 자원 해제
            try {
                // PreparedStatement, Connection 객체를 닫음
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                // 자원 해제 중 오류가 발생한 경우
                System.out.println("자원 해제 중 오류 발생: " + e.getMessage());
            }
        }
    }
}
