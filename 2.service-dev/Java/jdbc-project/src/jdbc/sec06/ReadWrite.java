package jdbc.sec06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
    public static StudentDTO getStdInfo(Scanner sc) {
        System.out.print("학번: ");
        String stdNo = sc.nextLine();
        System.out.print("이름: ");
        String stdName = sc.nextLine();
        System.out.print("학년: ");
        int stdYear = Integer.parseInt(sc.nextLine());
        System.out.print("주소: ");
        String stdAddress = sc.nextLine();
        System.out.print("생년월일(YYYY-MM-DD): ");
        String birthInput = sc.nextLine();
        System.out.print("학과번호: ");
        String deptNo = sc.nextLine();

        Date stdBirth = null;

        try {
            stdBirth = new SimpleDateFormat("yyyy-MM-dd").parse(birthInput);
        } catch (ParseException e) {
            System.out.println("날짜 형식이 잘못되었습니다. YYYY-MM-DD 형식으로 입력해주세요.");
            return null; // 날짜 형식이 잘못된 경우 null 반환
        }

        return new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirth, deptNo);
    }

    public static void writeStdInfo(ArrayList<StudentDTO> stdList) {
        System.out.printf("%-10s\t%-10s\t%-4s\t%-20s\t%13s\t%5s\n", "stdNo", "Name", "Year", "Address", "Birth Day", "deptNo");

        System.out.println("--------------------------------------------------");
        for (StudentDTO student : stdList) {
            String stdNo = student.getStdNo();
            String stdName = student.getStdName();
            int stdYear = student.getStdYear();
            String stdAddress = student.getStdAddress();
            Date stdBirth = student.getStdBirth();
            String deptNo = student.getDeptNo();

            // 날짜를 YYYY-MM-DD 형식으로 변환
            String birthStr = new SimpleDateFormat("yyyy-MM-dd").format(stdBirth);

            System.out.printf("%-10s\t%-10s\t%-4d\t%-20s\t%13s\t%5s\n", stdNo, stdName, stdYear, stdAddress, birthStr, deptNo);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("총 " + stdList.size() + "명의 학생 정보가 조회되었습니다.");
    }
}
