package view;

import controller.Controller;
import model.BookDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookInsertView {
    public void insert(Scanner sc) {
        System.out.println("========================================");
        System.out.println("Add New Book");
        System.out.println("========================================");

        System.out.print("Enter Book No: ");
        String bookNo = sc.nextLine();

        System.out.print("Enter Book Name: ");
        String bookName = sc.nextLine();

        System.out.print("Enter Book Author: ");
        String bookAuthor = sc.nextLine();

        System.out.print("Enter Book Price: ");
        String inputPrice = sc.nextLine();
        int bookPrice = 0;
        try {
            bookPrice = Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for price or stock. Please enter numeric values.");
            return;
        }

        System.out.print("Enter book Date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();
        Date bookDate;
        try {
            bookDate = new SimpleDateFormat("yyyy-MM-dd").parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        } catch (Exception e) {
            System.out.println("An error occurred while parsing the date.");
            return;
        }

        System.out.print("Enter Book Stock: ");
        String inputStock = sc.nextLine();
        int bookStock = 0;
        try {
            bookStock = Integer.parseInt(inputStock);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for stock. Please enter a numeric value.");
            return;
        }

        System.out.print("Enter Book Publisher: ");
        String pubNo = sc.nextLine();


        // Assuming Controller.getInstance().addBook() is the method to add a book
        BookDTO bookDTO = new BookDTO(bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
        Controller.getInstance().handleInsert(bookDTO);

        System.out.println("========================================");
    }
}
