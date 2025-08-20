package jdbc.sec03;

import java.sql.*;

public class DBConnectMain {
    public static void main(String[] args) {
        DBConnect dbconn = new DBConnect();

        Connection conn = dbconn.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try {
            if (conn != null) {
                stmt = conn.createStatement();
                String sql = "SELECT * FROM book ORDER BY book_no";
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String id = rs.getString("book_no").trim();
                    String name = rs.getString("book_name").trim();
                    String author = rs.getString("book_author").trim();
                    Integer price = rs.getInt("book_price");
                    Date date = rs.getDate("book_date");
                    Integer stock = rs.getInt("book_stock");
                    String pub_no = rs.getString("pub_no").trim();
                    System.out.printf("%-10s %-20s %-10s %6d %13s %3d %10s\n",
                            id, name, author, price, date.toString(), stock, pub_no);
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL 실행 중 오류 발생: " + e.getMessage());
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
