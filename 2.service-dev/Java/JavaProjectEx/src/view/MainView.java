package view;

import controller.Controller;

public class MainView {
    private static final Controller controller = Controller.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to the Book Management System");
        while (true) {
            displayMenu();
        }
    }

    public static void displayMenu() {
        System.out.println("========================================");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.println("========================================");
        System.out.print("Please enter your choice: ");
        controller.handleUserChoice();
    }

    public static void displayViewMenu() {
        System.out.println("========================================");
        System.out.println("1. View All Books");
        System.out.println("2. Search Book by Title");
        System.out.println("3. Search Book by Book No");
        System.out.println("4. Back to Main Menu");
        System.out.println("========================================");
        System.out.print("Please enter your choice: ");
        Controller.getInstance().handleViewChoice();
    }

    public static void exitApp() {
        System.out.println("========================================");
        System.out.println("Exiting the application.");
        System.out.println("========================================");
        System.exit(0);
    }
}
