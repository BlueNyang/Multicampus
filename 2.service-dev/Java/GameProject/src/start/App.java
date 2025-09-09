package start;

import info.AppInfo;
import input.InputHandler;
import game.IGameController;
import game.HangmanController;
import game.NumberBaseballController;
import user.IUserService;
import user.UserDTO;
import user.UserService;

/**
 * AppStart class to initialize and run the game application.
 */
public class App {
    // Menu options for the application
    private final String[] menu;
    // User service to handle user-related operations
    private final IUserService userService;
    // Flags to track user login status and current user ID
    private boolean isLoggedIn = false;
    private String currentUserId = null;

    public App() {
        this.menu = new String[]{
                "Application Information",
                "NumberBaseballGame",
                "HangmanGame",
                "RegisterUser",
                "LoginUser",
                "Exit"
        };
        this.userService = new UserService();
    }

    /**
     * Main method to start the application.
     * It initializes the AppStart instance and calls the App method.
     */
    public void start() {
        System.out.println("=========================================");
        System.out.println("           Game Project Start            ");
        System.out.println("=========================================");
        System.out.println("Welcome to the Game Project!");

        // Start the main menu loop
        while (true) {
            System.out.println("Please select an option from the menu below:");

            // Display the menu options
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i]);
            }

            // Prompt the user for their choice
            System.out.print("Enter your choice: ");
            String choice = InputHandler.getInput();

            // Handle the user's choice
            if (handleChoice(choice)) {
                break;
            }
            System.out.println();
        }
    }

    /**
     * Handles the user's choice from the main menu.
     * It performs actions based on the selected option.
     *
     * @param choice The user's choice as a string.
     * @return true if the application should exit, false otherwise.
     */
    private boolean handleChoice(String choice) {
        IGameController game;
        // Check the user's choice
        switch (choice) {
            // Display application information
            case "1" -> {
                String info = AppInfo.getAppInfo();
                System.out.println("==========================================");
                System.out.println("Application Information:");
                System.out.println(info);
                System.out.println("==========================================");
            }
            // Start the Number Base Ball Game
            case "2" -> {
                System.out.println("Starting Number Base Ball Game...");
                game = new NumberBaseballController(3, 10);
                game.startGame();
            }
            // Start the Hangman Game
            case "3" -> {
                System.out.println("Starting Hangman Game...");
                String[] gameWords = {"java", "python", "hangman", "game", "programming"};
                game = new HangmanController(gameWords, 10);
                game.startGame();
            }
            // Register a new user
            case "4" -> {
                System.out.println("Register User");
                System.out.print("Enter User ID: ");
                String userId = InputHandler.getInput();
                System.out.print("Enter Username: ");
                String username = InputHandler.getInput();
                System.out.print("Enter Password: ");
                String password = InputHandler.getInput();
                System.out.print("Enter Email: ");
                String email = InputHandler.getInput();

                userService.registerUser(userId, username, password, email);
            }
            // Login or access user menu
            case "5" -> {
                // Stay in the main menu
                if (isLoggedIn) {
                    while (true) {
                        System.out.println("==========================================");
                        String[] subMenu = {
                                "View Profile",
                                "Update Profile",
                                "Delete Account",
                                "Logout",
                                "Exit User Menu"
                        };
                        System.out.println("User Menu:");
                        for (int i = 0; i < subMenu.length; i++) {
                            System.out.println((i + 1) + ". " + subMenu[i]);
                        }
                        System.out.println("Current User: " + (currentUserId != null ? currentUserId : "Not logged in"));
                        System.out.print("Enter your choice: ");
                        String subChoice = InputHandler.getInput();
                        if (handleSubMenuChoice(subChoice))
                            break;
                    }
                } else {
                    System.out.print("Enter ID: ");
                    String username = InputHandler.getInput();
                    System.out.print("Enter Password: ");
                    String password = InputHandler.getInput();

                    UserDTO user = userService.loginUser(username, password);
                    // Stay in the main menu
                    if (user != null) {
                        isLoggedIn = true;
                        currentUserId = user.getUserId();
                        menu[4] = "User Menu (Logged in as " + user.getUsername() + ")";
                        System.out.println("Login successful. Welcome, " + username + "!");
                    } else {
                        System.out.println("Login failed. Please try again.");
                    }
                }
                return false;
            }
            // Exit the application
            case "6" -> {
                System.out.println("Exiting the application. Goodbye!");
                return true; // Exit the application
            }
            // Handle invalid choices
            default -> {
                System.out.println("Invalid choice. Please try again.");
                return false; // Stay in the main menu
            }
        }
        return false;
    }

    /**
     * Handles the user's choice from the user menu.
     * It performs actions based on the selected option.
     *
     * @param choice The user's choice as a string.
     * @return true if the user menu should exit, false otherwise.
     */
    private boolean handleSubMenuChoice(String choice) {
        // Check if the user is logged in
        if (!isLoggedIn || currentUserId == null) {
            System.out.println("You must be logged in to access user features.");
            return true;
        }

        // Handle the user's choice in the user menu
        switch (choice) {
            // Display user profile
            case "1" -> {
                System.out.println("Viewing Profile...");
                UserDTO user = userService.getUserById(currentUserId);
                if (user != null) {
                    System.out.println("User Profile: " + user.getUsername());
                    System.out.println("User ID: " + user.getUserId());
                    System.out.println("Username: " + user.getUsername());
                    System.out.println("Email: " + user.getUserEmail());
                } else {
                    System.out.println("User not found.");
                }
            }
            // Update user profile
            case "2" -> {
                System.out.println("Updating Profile...");
                System.out.print("Enter new Password: ");
                String password = InputHandler.getInput();
                System.out.print("Enter new Email: ");
                String email = InputHandler.getInput();

                String username = null;
                UserDTO user = userService.getUserById(currentUserId);
                if (user != null) {
                    username = user.getUsername();
                } else {
                    System.out.println("User not found.");
                    return true;
                }

                if (userService.updateUserInfo(currentUserId, username, password, email)) {
                    System.out.println("Profile updated successfully.");
                } else {
                    System.out.println("Failed to update profile.");
                }
            }
            // Delete user account
            case "3" -> {
                System.out.println("Deleting Account...");
                if (userService.deleteUser(currentUserId)) {
                    System.out.println("Account deleted successfully.");
                    isLoggedIn = false;
                    currentUserId = null;
                    menu[4] = "LoginUser"; // Reset the menu option
                    return true;
                } else {
                    System.out.println("Failed to delete account.");
                }
            }
            // Logout user
            case "4" -> {
                System.out.println("Logging out...");
                isLoggedIn = false;
                currentUserId = null;
                System.out.println("Logged out successfully.");
                menu[4] = "LoginUser"; // Reset the menu option
                return true; // Exit the user menu
            }
            // Exit user menu
            case "5" -> {
                System.out.println("Exiting User Menu.");
                return true; // Exit the user menu
            }
            // Handle invalid choices in the user menu
            default -> System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }
}
