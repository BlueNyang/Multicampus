package game_project.game;

import game_project.input.InputHandler;

import java.util.ArrayList;
import java.util.Random;

/**
 * NumberBaseballController is responsible for managing the Number Baseball game.
 */
public class NumberBaseballController implements IGameController {
    // Number of digits in the secret number
    private final int numberOfDigits;
    // Maximum number of chances the player has to guess the number
    private final int maxChances;

    /**
     * Initializes a new Number Baseball game with the specified number of digits and maximum attempts.
     * @param maxChances The maximum number of attempts allowed.
     */
    public NumberBaseballController(int numberOfDigits, int maxChances) {
        this.numberOfDigits = numberOfDigits;
        this.maxChances = maxChances;
    }

    @Override
    public void startGame() {
        // Generate a random number with the specified number of digits
        Random rand = new Random();
        int randomNumber = rand.nextInt((int) Math.pow(10, numberOfDigits) - 1);

        // create game instance with the random number and maximum chances
        NumberBaseballGame game = new NumberBaseballGame(randomNumber, maxChances);

        System.out.println("=========== Number Baseball Game ===========");
        System.out.println(":: New game started! ::");
        System.out.println("Guess the " + numberOfDigits + "-digit number. You have " + maxChances + " chances.");

        // Main game loop
        while(!game.isGameOver()) {
            System.out.println("=====================================");
            System.out.println("Chances left: " + game.getChancesLeft());
            System.out.println("=====================================");
            System.out.print("Enter your guess (a " + numberOfDigits + "-digit number): ");

            // Read user input
            String input = InputHandler.getInput().trim();

            // Check for exit command
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                return;
            }

            // Validate input
            if (input.length() != numberOfDigits || !input.matches("\\d+")) {
                System.out.println("Please enter a valid " + numberOfDigits + "-digit number.");
                continue;
            }

            // Convert input string to an ArrayList of integers
            ArrayList<Integer> guess = input.chars().map(Character::getNumericValue).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

            // Make the guess and get the result
            NumberBaseballResult result = game.makeGuess(guess);

            // Display the result of the guess
            if (result.strikes == numberOfDigits) {
                System.out.println("Congratulations! You've guessed the number: " + game.getSecretNumber());
                return;
            } else if (result.strikes == 0 && result.balls == 0) {
                System.out.println("No strikes or balls. Try again!");
            } else {
                System.out.println(result.strikes + " Strike(s), " + result.balls + " Ball(s).");
            }
        }
    }
}
