package secure.sec01.a_statement;

import secure.sec01.util.DBConnect;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInjectMain {
    public static void main(String[] args) {
        DBConnect db = new DBConnect();
        Connection conn = db.getConnection();
        Statement stmt = null;
        ResultSet rs = null;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the StudentNo: ");
            String studentNo = sc.nextLine();

            // SQL Injection => ' OR 1=1 UNION SELECT COLUMN_NAME, null, null, null, null, null FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT' --
            String sql = "SELECT * FROM STUDENT WHERE STD_NO = '" + studentNo + "'";

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            // std_no, std_name, std_year, std_address, std_birth, dept_no
            System.out.println("StudentNo\tName\tYear\tAddress\tBirthDate\tDeptNo");
            System.out.println("----------------------------------------------------------");

            while (rs.next()) {
                PrintStream printf = System.out.printf("%s\t%s\t%d\t%s\t%s\t%s\n",
                        rs.getString("STD_NO"),
                        rs.getString("STD_NAME"),
                        rs.getInt("STD_YEAR"),
                        rs.getString("STD_ADDRESS"),
                        rs.getString("STD_BIRTH"),
                        rs.getString("DEPT_NO"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnect.close(conn, stmt, rs);
        }
    }
}
