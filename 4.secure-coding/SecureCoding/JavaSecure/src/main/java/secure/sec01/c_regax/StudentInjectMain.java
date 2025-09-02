package secure.sec01.c_regax;

import secure.sec01.util.DBConnect;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentInjectMain {
    public static void main(String[] args) {
        Connection conn = new DBConnect().getConnection();
        Statement pstmt = null;
        ResultSet rs = null;

        String regex = "^(?!.*(select|update|delete|or|create|alter|drop|where|=|'|-))[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the StudentNo: ");
            String studentNo = sc.nextLine();

            if (!pattern.matcher(studentNo.toLowerCase()).find()) {
                System.out.println("Invalid input. Potential SQL injection detected.");
                return;
            }

            String sql = "SELECT * FROM STUDENT WHERE STD_NO = '" + studentNo + "'";

            pstmt = conn.createStatement();
            rs = pstmt.executeQuery(sql);

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
            DBConnect.close(conn, pstmt, rs);
        }
    }
}
