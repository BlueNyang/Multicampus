package view;

import model.BookDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookUpdateView {
    public BookDTO getUpdateBookDetail(Scanner sc) {
        System.out.println("========================================");
        System.out.println("Update Book Details");
        System.out.println("========================================");
        try {
            System.out.print("Enter Book No: ");
            String bookNo = sc.nextLine();

            System.out.print("Enter Book Title: ");
            String bookTitle = sc.nextLine();

            System.out.print("Enter Book Author: ");
            String bookAuthor = sc.nextLine();

            System.out.print("Enter Book Price: ");
            String inputPrice = sc.nextLine();
            int bookPrice = 0;
            try {
                bookPrice = Integer.parseInt(inputPrice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for price or stock. Please enter numeric values.");
                return null;
            }

            System.out.print("Enter book Date (YYYY-MM-DD): ");
            String inputDate = sc.nextLine();
            Date bookDate;
            try {
                bookDate = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");
                return null;
            } catch (Exception e) {
                System.out.println("An error occurred while parsing the date.");
                return null;
            }

            System.out.print("Enter Book Stock: ");
            String inputStock = sc.nextLine();
            int bookStock = 0;
            try {
                bookStock = Integer.parseInt(inputStock);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for stock. Please enter a numeric value.");
                return null;
            }

            System.out.print("Enter Book Publisher: ");
            String pubNo = sc.nextLine();

            return new BookDTO(bookNo, bookTitle, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
        } catch (Exception e) {
            System.out.println("An error occurred while updating book details. Please try again.");
            return null;
        }
    }
}
