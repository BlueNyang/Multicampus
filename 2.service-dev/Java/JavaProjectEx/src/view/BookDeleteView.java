package view;

import java.util.Scanner;

public class BookDeleteView {
    public String getBookNo(Scanner sc) {
        System.out.println("========================================");
        System.out.println("Delete Book");
        System.out.println("========================================");

        System.out.print("Enter Book No to delete: ");
        String bookNo;

        try {
            bookNo = sc.nextLine();
        } catch (Exception e) {
            return null;
        }

        return bookNo;
    }
}
