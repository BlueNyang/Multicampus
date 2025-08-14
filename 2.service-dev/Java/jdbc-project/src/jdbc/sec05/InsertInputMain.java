package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertInputMain {
    public static void main(String[] args) {
        DBConnect dbconnect = new DBConnect();

        Connection conn = dbconnect.getConnection();
        PreparedStatement pstmt = null;

        try (Scanner sc = new Scanner(System.in)) {
            // SQL 쿼리문 작성
            String sql = "INSERT INTO book VALUES (?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?)";

            // PreparedStatement 객체 생성
            pstmt = conn.prepareStatement(sql);

            // 사용자로부터 도서 정보를 입력받음
            System.out.print("도서번호 입력: ");
            String bookNo = sc.nextLine().trim();
            System.out.print("도서명 입력: ");
            String bookName = sc.nextLine().trim();
            System.out.print("도서 저자 입력: ");
            String bookAuthor = sc.nextLine().trim();
            System.out.print("도서가격 입력: ");
            int bookPrice = Integer.parseInt(sc.nextLine().trim());
            System.out.print("출판일 입력 (YYYY-MM-DD): ");
            String bookDate = sc.nextLine().trim();
            System.out.print("재고수량 입력: ");
            int bookStock = Integer.parseInt(sc.nextLine().trim());
            System.out.print("출판사번호 입력: ");
            String pubNo = sc.nextLine().trim();

            // 입력받은 값을 PreparedStatement에 설정
            pstmt.setString(1, bookNo);
            pstmt.setString(2, bookName);
            pstmt.setString(3, bookAuthor);
            pstmt.setInt(4, bookPrice);
            pstmt.setString(5, bookDate);
            pstmt.setInt(6, bookStock);
            pstmt.setString(7, pubNo);

            // SQL 쿼리 실행
            int result = pstmt.executeUpdate();

            // 결과 출력
            if (result > 0) {
                System.out.println("도서 정보가 성공적으로 추가되었습니다.");
            } else {
                System.out.println("도서 정보 추가에 실패했습니다.");
            }
        } catch (SQLException e) {
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt, null);
        }
    }
}
