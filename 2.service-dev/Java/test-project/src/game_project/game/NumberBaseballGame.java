package game_project.game;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The NumberBaseballGame class represents a number baseball game where players guess a secret number.
 */
public class NumberBaseballGame {
    private final ArrayList<Integer> secretNumber;
    private int chancesLeft;

    /**
     * Constructor for the NumberBaseballGame class.
     * @param secretNumber The secret number to guess, represented as an array of integers.
     * @param maxAttempts The maximum number of attempts allowed.
     */
    public NumberBaseballGame(int secretNumber, int maxAttempts) {
        // Convert the secret number to a string, then to an ArrayList of integers.
        this.secretNumber = String.valueOf(secretNumber)
                .chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        this.chancesLeft = maxAttempts;
    }

    /**
     * Returns the number of attempts left for the player.
     * @return The number of attempts left.
     */
    public int getChancesLeft() {
        return chancesLeft;
    }

    /**
     * Processes a guess made by the player.
     * @param guess The player's guess, represented as an array of integers.
     * @return An integer indicating the result of the guess:
     *         0 if the guess is incorrect,
     *         1 if the guess is correct.
     */
    public NumberBaseballResult makeGuess(ArrayList<Integer> guess) {
        chancesLeft--;

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < secretNumber.size(); i++) {
            if (Objects.equals(guess.get(i), secretNumber.get(i))) {
                strikes++;
            } else if (secretNumber.contains(guess.get(i))) {
                balls++;
            }
        }

        return new NumberBaseballResult(strikes, balls);
    }

    /**
     * Returns the secret number.
     * @return The secret number as an array of integers.
     */
    public ArrayList<Integer> getSecretNumber() {
        return secretNumber;
    }

    /**
     * Checks if the game is over, either by running out of chances or guessing the secret number.
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver() {
        return chancesLeft <= 0;
    }
}
