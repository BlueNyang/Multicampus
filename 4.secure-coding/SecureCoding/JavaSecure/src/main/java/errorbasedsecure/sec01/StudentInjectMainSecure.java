package errorbasedsecure.sec01;

import secure.sec01.util.DBConnect;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInjectMainSecure {

    public static void main(String[] args) {
        // 취약점이 있는 코드/잘못 개발된 코드
        DBConnect dbCon = new DBConnect();
        Connection con = dbCon.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the student number : ");
            String studentNo = sc.nextLine();
            System.out.println(studentNo);

            //sql 쿼리문 작성 - 플레이스홀더 사용하지 않고 변수 이용해서 코딩(전체컬럼 추출)
            //preapredstatement를 사용하지만 바인딩 하고 있지 않음 - 인젝션 취약점
            String sql = "select * from student where stdNo='" + studentNo + "'";
            System.out.println(sql);
            pstmt = con.prepareStatement(sql); //하드코딩된 쿼리 구문 그대로 적용 가능
            rs = pstmt.executeQuery();

            //제목 출력
            System.out.println("-----------학생 정보 조회 --------");
            System.out.println("STD_NO\tSTD_NAME\t\t\t\tSTD_YEAR");

            //필요 내용만 추출
            while (rs.next()) {
                String stdNo = rs.getString(1);
                String stdName = rs.getString(2);
                int stdYear = rs.getInt(3);

                //한 행씩 출력
                System.out.format("%-10s\t %-20s\t %6d \n", stdNo, stdName, stdYear);
            }
        } catch (SQLException e) {
            //e.printStackTrace(); //개발단계에서 개발자가 확인하기 위한 에러 출력 문
            System.out.println("프로그램 실행 중 오류 발생 프로그램 종료");
        } finally {
            errorbasedsecure.util.DBConnect.close(con, pstmt, rs);
        }

    }

}
