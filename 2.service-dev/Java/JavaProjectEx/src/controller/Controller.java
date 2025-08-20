package controller;

import model.Book;
import model.BookDAO;
import model.BookDTO;
import model.IBookDAO;
import view.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static final Controller instance = new Controller();
    private final IBookDAO bookDAO;
    private final Scanner sc = new Scanner(System.in);

    private Controller() {
        this.bookDAO = new BookDAO();
        if (bookDAO.isConnected()) {
            ResultView.success("Database connection established successfully.");
        } else {
            ResultView.error("Failed to connect to the database. Please check your connection settings.");
            System.exit(1);
        }
    }

    public static Controller getInstance() {
        return instance;
    }

    public void handleUserChoice() {
        int choice = 0;
        try {
            String input = sc.nextLine();
            choice = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            ResultView.error("Invalid input. Please enter a number between 1 and 5.");
            return;
        } catch (Exception e) {
            sc.nextLine(); // Clear the invalid input
            ResultView.error("Error processing input.");
            return;
        }

        switch (choice) {
            case 1 -> new BookInsertView().insert(sc);
            case 2 -> MainView.displayViewMenu();
            case 3 -> handleUpdate();
            case 4 -> handleDelete();
            case 5 -> {
                bookDAO.closeAll();
                try {
                    sc.close();
                } catch (Exception e) {
                    ResultView.error(e.getMessage());
                }
                MainView.exitApp();
            }
            default -> ResultView.error("Invalid input. Please enter a number between 1 and 5.");
        }
    }

    public void handleViewChoice() {
        int choice = 0;
        try {
            String input = sc.nextLine();
            choice = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            ResultView.error("Invalid input. Please enter a number between 1 and 4.");
            return;
        } catch (Exception e) {
            sc.nextLine(); // Clear the invalid input
            ResultView.error("Error processing input.");
            return;
        }

        switch (choice) {
            case 1 -> new BookListView().displayBooks(booksToDTOs(bookDAO.getAll()));
            case 2 -> handleDisplayByName();
            case 3 -> handleDisplayByNo();
            case 4 -> {
                ResultView.success("Returning to the main menu.");
                return;
            }
            default -> {
                ResultView.error("Invalid input. Please enter a number between 1 and 4.");
                return;
            }
        }
        ResultView.waitForEnter(sc);
    }

    public void handleInsert(BookDTO bookDTO) {
        if (bookDAO.insertBook(bookDTO.toEntity())) {
            ResultView.success("Book inserted Successfully.");
        } else {
            ResultView.error("Failed to insert book. Please try again.");
        }
    }

    public void handleDisplayByName() {
        String bookName = new BookListView().getBookByName(sc);
        if (bookName == null || bookName.trim().isEmpty()) return;

        ArrayList<Book> books = bookDAO.getByName(bookName);

        if (books.isEmpty()) {
            ResultView.error("No books found with the name " + bookName);
        } else {
            new BookListView().displayBooks(booksToDTOs(books));
        }
    }

    public void handleDisplayByNo() {
        String bookNo = new BookListView().displayBookByNo(sc);
        if (bookNo == null || bookNo.trim().isEmpty()) return;

        ArrayList<Book> book = bookDAO.getBookByNo(bookNo);

        if (book.isEmpty()) {
            ResultView.error("No book found with the book number " + bookNo);
        } else {
            new BookListView().displayBooks(booksToDTOs(book));
        }
    }

    public void handleUpdate() {
        BookDTO bookDTO = new BookUpdateView().getUpdateBookDetail(sc);
        if (bookDTO == null) return;

        boolean isUpdated = bookDAO.updateBook(bookDTO.toEntity());

        if (isUpdated) {
            ResultView.success("Book updated successfully.");
        } else {
            ResultView.error("Failed to update the book. Please try again.");
        }
    }

    public void handleDelete() {
        String bookNo = new BookDeleteView().getBookNo(sc);

        if (bookNo == null || bookNo.trim().isEmpty()) {
            ResultView.error("Invalid book number. Please try again.");
            return;
        }

        boolean isDeleted = bookDAO.deleteBook(bookNo);

        if (isDeleted) {
            ResultView.success("Book deleted successfully.");
        } else {
            ResultView.error("Failed to delete the book. Please try again.");
        }
    }

    private ArrayList<BookDTO> booksToDTOs(ArrayList<Book> books) {
        return new ArrayList<>(books.stream()
                .map(BookDTO::from)
                .toList());
    }
}
