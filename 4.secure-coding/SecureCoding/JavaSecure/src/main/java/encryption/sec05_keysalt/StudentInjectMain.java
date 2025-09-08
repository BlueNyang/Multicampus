package encryption.sec05_keysalt;

import encryption.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInjectMain {
    public static void main(String[] args) {
        // 취약점이 있는 코드/잘못 개발된 코드
        DBConnect dbCon = new DBConnect();
        Connection conn = dbCon.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the Student number: ");
            String studentNo = sc.nextLine();
            System.out.println(studentNo);

            //sql 쿼리문 작성 - 플레이스홀더 사용하지 않고 변수 이용해서 코딩(전체컬럼 추출)
            //preapredstatement를 사용하지만 바인딩 하고 있지 않음 - 인젝션 취약점
            String sql = "SELECT * from student where std_no='" + studentNo + "'";
            System.out.println(sql);
            pstmt = conn.prepareStatement(sql); //하드코딩된 쿼리 구문 그대로 적용 가능
            rs = pstmt.executeQuery();

            //제목 출력
            System.out.println("-----------학생 정보 조회 --------");
            System.out.println("학생번호 \t 학생이름 \t\t\t\t 학년");

            //필요 내용만 추출
            while (rs.next()) {
                String stdNo = rs.getString(1);
                String stdName = rs.getString(2);
                int stdYear = rs.getInt(3);

                //한 행씩 출력
                System.out.format("%-10s\t %-20s\t %6d \n", stdNo, stdName, stdYear);
            }
        } catch (SQLException e) {
            System.out.println("SQL error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            DBConnect.close(conn, pstmt, rs);
        }

    }
}
