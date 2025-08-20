package jdbc.sec04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReadWrite {
    public static BookDTO getStdInfo(Scanner sc) {
        System.out.print("책번호: ");
        String bookNo = sc.nextLine();
        System.out.print("책이름: ");
        String bookName = sc.nextLine();
        System.out.print("저자: ");
        String bookAuthor = sc.nextLine();
        System.out.print("가격: ");
        int bookPrice = Integer.parseInt(sc.nextLine());
        System.out.print("출판일(YYYY-MM-DD): ");
        String dateInput = sc.nextLine();
        System.out.print("재고: ");
        int bookStock = Integer.parseInt(sc.nextLine());
        System.out.print("출판사번호: ");
        String pubNo = sc.nextLine();

        Date bookDate;

        try {
            bookDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("날짜 형식이 잘못되었습니다. YYYY-MM-DD 형식으로 입력해주세요.");
            return null; // 날짜 형식이 잘못된 경우 null 반환
        }

        return new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
    }

    public static void writeStdInfo(ArrayList<BookDTO> bookList) {
        System.out.printf("%-10s\t%-10s\t%-4s\t%-20s\t%13s\t%5s\n", "stdNo", "Name", "Year", "Address", "Birth Day", "deptNo");

        System.out.println("--------------------------------------------------");
        for (BookDTO book : bookList) {
            String bookNo = book.getBookNo();
            String bookName = book.getBookName();
            String bookAuthor = book.getBookAuthor();
            int bookPrice = book.getBookPrice();
            Date bookDate = book.getBookDate();
            int bookStock = book.getBookStock();
            String pubNo = book.getPubNo();

            // 날짜를 YYYY-MM-DD 형식으로 변환
            String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(bookDate);

            System.out.printf("%-10s\t%-10s\t%-4s\t%-20s\t%13s\t%5s\n", bookNo, bookName, bookAuthor, bookPrice, dateStr, bookStock, pubNo);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("총 " + bookList.size() + "권의 책(이)가 조회되었습니다.");
    }
}
