package jdbc.sec05;

import java.sql.*;
import java.util.Scanner;

public class SelectMain {
    public static void main(String[] args) {
        DBConnect dbconnect = new DBConnect();
        Connection conn = dbconnect.getConnection();
//        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("조회할 도서번호 입력: ");
            String askBookNo = sc.nextLine().trim();
//            String sql = "SELECT * FROM book WHERE book_no = '" + askBookNo + "'";
            String sql = "select * from book where book_no = ?";

            try {
//                stmt = conn.createStatement();
//                rs = stmt.executeQuery(sql);
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, askBookNo);
                rs = pstmt.executeQuery();

                System.out.printf("%-10s %-20s %-10s\n", "BookNo", "bookName", "bookStock");
                while (rs.next()) {
                    String bookNo = rs.getString("book_no").trim();
                    String bookName = rs.getString("book_name").trim();
                    int bookStock = rs.getInt("book_stock");

                    System.out.printf("%-10s %-20s %3d\n", bookNo, bookName, bookStock);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } finally {
//            DBConnect.close(conn, stmt, rs);
            DBConnect.close(conn, pstmt, rs);
        }
    }
}
