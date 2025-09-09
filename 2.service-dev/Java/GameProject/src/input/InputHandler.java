package input;

import java.util.Scanner;

/**
 * InputHandler class to manage user input from the console.
 */
public class InputHandler implements AutoCloseable {
    public static Scanner scanner;

    // Static block to initialize the scanner
    public InputHandler() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
    }

    /**
     * Returns the singleton instance of Scanner.
     * If the scanner is not initialized, it initializes it first.
     *
     * @return Scanner instance
     */
    public static String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void close() {
        if (scanner != null) {
            System.out.println("Closing input scanner.");
            scanner.close();
        }
    }
}
