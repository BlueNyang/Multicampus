package game;

import input.InputHandler;

import java.util.Random;

/**
 * HangmanController is responsible for managing the Hangman game logic.
 */
public class HangmanController implements IGameController {
    // Array of words to choose from for the Hangman game
    private final String[] words;
    // Maximum number of incorrect attempts allowed before the game is over
    private final int maxChances;

    /**
     * Initializes a new Hangman game with the specified word and maximum attempts.
     *
     * @param words      An array of words to choose from for the game.
     * @param maxChances The maximum number of incorrect attempts allowed.
     */
    public HangmanController(String[] words, int maxChances) {
        this.words = words;
        this.maxChances = maxChances;
    }

    @Override
    public void startGame() {
        Random rand = new Random();
        // Select a random word from the provided words array
        String wordToGuess = words[rand.nextInt(words.length)];

        // Instance of HangmanGame that contains the game logic
        HangmanGame game = new HangmanGame(wordToGuess, maxChances);

        System.out.println("=========== Hangman Game ===========");
        System.out.println(":: New game started! ::");

        // Main game loop that continues until the game is over
        while (!game.isGameOver()) {
            System.out.println("=====================================");
            System.out.println("Word to guess: " + game.getCurrentGuess());
            System.out.println("Chances left: " + game.getChancesLeft());
            System.out.println("=====================================");
            System.out.println("Enter a letter to guess (or type 'exit' to quit): ");
            System.out.print("One letter at a time: ");
            String input = InputHandler.getInput().trim();

            // Check if the user wants to exit the game
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the game. Goodbye!");
                return;
            }

            // Validate input: must be a single letter
            if (input.length() != 1) {
                System.out.println("Please enter only one letter at a time.");
                continue;
            }

            // Convert input to lowercase and check if it's a valid letter
            char letter = input.charAt(0);
            // Check result of the letter guess
            int result = game.guessLetter(letter);

            // Provide feedback based on the result of the guess
            switch (result) {
                case -1 -> System.out.println("You have already guessed that letter. Try again.");
                case 0 -> System.out.println("Incorrect guess! The letter '" + letter + "' is not in the word.");
                case 2 -> System.out.println("Good guess! The letter '" + letter + "' is in the word.");
            }

            // Check if the game is over after the guess
            if (game.isWordGuessed()) {
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
                System.out.println("You win!");
                return;
            }
        }
    }
}
