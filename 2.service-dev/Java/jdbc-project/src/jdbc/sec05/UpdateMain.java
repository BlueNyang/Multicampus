package jdbc.sec05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
    public static void main(String[] args) {
        DBConnect dbconnect = new DBConnect();
        Connection conn = dbconnect.getConnection();
        PreparedStatement pstmt = null;


        try (Scanner sc = new Scanner(System.in)) {
            String sql = "UPDATE book SET book_name = ?, book_price = ?, book_author = ?, book_date = TO_DATE(?, 'YYYY-MM-DD'), book_stock = ?, pub_no = ? WHERE book_no = ?";
            pstmt = conn.prepareStatement(sql);

            System.out.print("수정할 도서번호 입력: ");
            String bookNo = sc.nextLine().trim();

            System.out.print("수정할 도서 이름 입력: ");
            String bookName = sc.nextLine().trim();
            System.out.print("수정할 도서 가격 입력: ");
            int bookPrice = Integer.parseInt(sc.nextLine().trim());
            System.out.print("수정할 도서 저자 입력: ");
            String bookAuthor = sc.nextLine().trim();
            System.out.print("수정할 도서 출판일 입력 (YYYY-MM-DD): ");
            String bookDate = sc.nextLine().trim();
            System.out.print("수정할 도서 재고수량 입력: ");
            int bookStock = Integer.parseInt(sc.nextLine().trim());
            System.out.print("수정할 도서 출판사번호 입력: ");
            String pubNo = sc.nextLine().trim();

            // PreparedStatement에 파라미터 설정
            pstmt.setString(1, bookName);
            pstmt.setInt(2, bookPrice);
            pstmt.setString(3, bookAuthor);
            pstmt.setString(4, bookDate);
            pstmt.setInt(5, bookStock);
            pstmt.setString(6, pubNo);
            pstmt.setString(7, bookNo);

            // SQL 쿼리 실행
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt, null);
        }
    }
}
