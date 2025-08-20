package view;

import model.BookDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookListView {
    public void displayBooks(ArrayList<BookDTO> books) {
        System.out.println("========================================");
        System.out.println("Displaying All Books");

        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Book No\tTitle\tAuthor\tPrice\tDate\tStock\tPublisher");
            System.out.println("--------------------------------------------------");
            for (BookDTO book : books) {
                System.out.println(book);
            }
        }
    }

    public String getBookByName(Scanner sc) {
        System.out.println("========================================");
        System.out.println("Search Book by Title");
        System.out.println("========================================");

        System.out.print("Enter Book Title: ");

        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return null;
        }
    }

    public String displayBookByNo(Scanner sc) {
        System.out.println("========================================");
        System.out.println("Search Book by Book No");
        System.out.println("========================================");

        System.out.print("Enter Book No: ");

        try {
            return sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
            return null;
        }
    }
}
