package kr.bluenyang.practice.webgame.domain.numbb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The NumberBaseballGame class
 */
public class NumberBaseballGame {

    private final List<Integer> secretNumber;
    private final List<NumberBaseballResult> Attempts;
    private boolean isSolved = false;

    public NumberBaseballGame() {
        // Length of the secret number
        int NUMBER_LENGTH = 5;

        // Generate a random number with the specified length
        int bound = (int) Math.pow(10, NUMBER_LENGTH - 1);
        int randomNum = new Random().nextInt(bound, bound * 10);
        this.secretNumber = String.valueOf(randomNum)
                .chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        this.Attempts = new ArrayList<>();
        System.out.println("Secret Number: " + Arrays.toString(secretNumber.toArray()));
    }

    // Getters
    public int getAttempts() {
        return Attempts.size();
    }

    public List<NumberBaseballResult> getResults() {
        return Attempts;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public List<Integer> getSecretNumber() {
        return secretNumber;
    }

    /**
     * Process a player's guess and return the result in terms of strikes and balls.
     *
     * @param guess The player's guess
     */
    public NumberBaseballStatus makeGuess(String guess) {
        if (isSolved) {
            return NumberBaseballStatus.SOLVED;
        }

        if (guess.length() != secretNumber.size()) {
            System.out.println("Invalid guess length: " + guess.length());
            return NumberBaseballStatus.INVALID_LENGTH;
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < secretNumber.size(); i++) {
            if (guess.charAt(i) < '0' || guess.charAt(i) > '9') {
                System.out.println("Invalid character in guess: " + guess.charAt(i));
                return NumberBaseballStatus.INVALID_INPUT;
            }
            int digit = Integer.parseInt(guess.charAt(i) + "");

            if (secretNumber.get(i).equals(digit)) {
                strikes++;
            } else if (secretNumber.contains(digit)) {
                balls++;
            }
        }

        System.out.println("Guess: " + guess + ", Strikes: " + strikes + ", Balls: " + balls);

        Attempts.add(new NumberBaseballResult(guess, strikes, balls));

        if (strikes == secretNumber.size()) {
            isSolved = true;
            return NumberBaseballStatus.SOLVED;
        }
        
        return NumberBaseballStatus.ONGOING;
    }
}
