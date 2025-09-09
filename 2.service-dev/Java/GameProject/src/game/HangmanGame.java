package game;

import java.util.ArrayList;
import java.util.List;

/**
 * HangmanGame class represents the logic of a Hangman game.
 */
public class HangmanGame {
    // The word to guess in the Hangman game
    private final String wordToGuess;
    // The current state of the guessed word, represented as underscores for unguessed letters
    private final StringBuilder current;
    // List of letters that have been guessed by the player
    private final List<Character> usedLetters;
    // The number of chances left for the player to guess the word
    private int chancesLeft;

    /**
     * Constructor for the HangmanGame class.
     *
     * @param wordToGuess The word that the player needs to guess.
     * @param maxChances  The maximum number of incorrect attempts allowed.
     */
    public HangmanGame(String wordToGuess, int maxChances) {
        this.wordToGuess = wordToGuess;
        this.current = new StringBuilder("_".repeat(wordToGuess.length()));
        this.chancesLeft = maxChances;
        this.usedLetters = new ArrayList<>();
    }

    /**
     * Returns the current guess of the word.
     * The current guess is represented as a string with underscores for unguessed letters.
     *
     * @return The current guess of the word as a string.
     */
    public String getCurrentGuess() {
        return current.toString();
    }

    /**
     * Returns the number of attempts left for the player.
     *
     * @return The number of attempts left.
     */
    public int getChancesLeft() {
        return chancesLeft;
    }

    /**
     * Processes a letter guessed by the player.
     *
     * @param letter The letter guessed by the player.
     * @return An integer indicating the result of the guess.
     * - 1 if the letter has already been guessed,
     * 0 if the letter is not in the word,
     * 2 if the letter is in the word.
     */
    public int guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        boolean found = false;

        // Check if the letter has already been used
        if (usedLetters != null) {
            if (usedLetters.contains(letter)) {
                return -1; // Letter has already been guessed
            } else {
                usedLetters.add(letter); // Add the letter to the list of used letters
            }
        }

        // Check if the letter is in the word to guess
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                current.setCharAt(i, letter);
                found = true;
            }
        }

        // If the letter was not found in the word, decrement chances left
        if (!found) {
            chancesLeft--;
        }

        // Return the result of the guess
        if (found) return 1;
        else return 0;
    }

    /**
     * Checks if the game is over.
     * The game is over if the player has run out of chances or has guessed the word.
     *
     * @return True if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return chancesLeft <= 0 || current.toString().equals(wordToGuess);
    }

    /**
     * Checks if the word has been completely guessed.
     *
     * @return True if the word has been guessed, false otherwise.
     */
    public boolean isWordGuessed() {
        return current.toString().equals(wordToGuess);
    }
}
