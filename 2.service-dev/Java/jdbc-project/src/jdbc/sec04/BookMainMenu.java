package jdbc.sec04;

import java.util.ArrayList;
import java.util.Scanner;

public class BookMainMenu {
    public static void main(String[] args) {
        IBookDAO sdao = new BookDAO();
        try (Scanner sc = new Scanner(System.in)) {
            int number;

            do {
                System.out.println("=========================");
                System.out.println("책 관리 프로그램");
                System.out.println("1. 책 정보 추가");
                System.out.println("2. 전체 책 정보 조회");
                System.out.println("3. 책 번호로 정보 조회");
                System.out.println("4. 책 이름으로 정보 조회");
                System.out.println("5. 책 정보 수정");
                System.out.println("6. 책 정보 삭제");
                System.out.println("0. 프로그램 종료");
                System.out.println("=========================");
                System.out.print("메뉴를 선택하세요: ");
                number = Integer.parseInt(sc.nextLine());

                if (number >= 1 && number <= 6) {
                    select(number, sc, sdao);
                } else if (number == 0) {
                    System.out.println("프로그램을 종료합니다.");
                } else {
                    System.out.println("잘못된 메뉴 선택입니다. 다시 시도하세요.");
                }
            } while (number != 0);
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
        } finally {
            System.out.println("프로그램이 종료되었습니다.");
            sdao.close();
        }
    }

    public static void select(int number, Scanner sc, IBookDAO sdao) {
        System.out.println("=========================");
        switch (number) {
            case 1 -> {
                System.out.println("책 정보를 추가합니다.");
                sdao.insertBook(ReadWrite.getStdInfo(sc));
            }
            case 2 -> {
                System.out.println("책 정보를 전체 조회합니다.");
                ArrayList<BookDTO> stdList = sdao.getAllBooks();
                ReadWrite.writeStdInfo(stdList);
            }
            case 3 -> {
                System.out.println("책 번호로 정보를 조회합니다.");
                System.out.print("책 번호을 입력하세요: ");
                String stdNo = sc.nextLine();
                ReadWrite.writeStdInfo(sdao.detailBook(stdNo));
            }
            case 4 -> {
                System.out.println("책 이름으로 정보를 조회합니다.");
                System.out.print("책 이름을 입력하세요: ");
                String deptName = sc.nextLine();
                ReadWrite.writeStdInfo(sdao.searchBooks(deptName));
            }
            case 5 -> {
                System.out.println("책 정보를 수정합니다.");
                sdao.updateBook(ReadWrite.getStdInfo(sc));
            }
            case 6 -> {
                System.out.println("책 정보를 삭제합니다.");
                System.out.print("삭제를 위해 책 번호를 입력하세요: ");
                String stdNo = sc.nextLine();
                sdao.deleteBook(stdNo);
            }
        }
        waitForEnter(sc);
    }

    private static void waitForEnter(Scanner sc) {
        System.out.print("작업이 완료되었습니다. 계속하려면 Enter 키를 누르세요...");
        sc.nextLine();
    }
}
