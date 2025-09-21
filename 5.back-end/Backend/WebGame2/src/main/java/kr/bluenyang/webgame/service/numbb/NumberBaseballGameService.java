package kr.bluenyang.webgame.service.numbb;

import kr.bluenyang.webgame.dto.numbb.NumberBaseballGuessResult;
import kr.bluenyang.webgame.dto.numbb.NumberBaseballTry;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The NumberBaseballGame class
 */
@Slf4j
public class NumberBaseballGameService {

    private final List<Integer> secretNumber;
    private final List<NumberBaseballTry> attempts;
    private boolean isSolved = false;

    public NumberBaseballGameService(List<Integer> secretNumber, List<NumberBaseballTry> attempts) {
        this.secretNumber = secretNumber;
        this.attempts = attempts;
    }

    public static List<Integer> createNewGame(int length) {
        log.info("Creating a new Number Baseball game...");
        int bound = (int) Math.pow(10, length - 1);
        int randomNum = new Random().nextInt(bound, bound * 10);
        return String.valueOf(randomNum)
                .chars()
                .map(Character::getNumericValue)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }

    /**
     * Process a player's guess and return the result in terms of strikes and balls.
     *
     * @param guess The player's guess
     */
    public NumberBaseballGuessResult makeGuess(String guess) {
        log.info("Attempting to guess number baseball game...");
        if (isSolved) {
            System.out.println("Game already solved.");
            return new NumberBaseballGuessResult(
                    attempts,
                    NumberBaseballStatus.SOLVED
            );
        }

        if (guess.length() != secretNumber.size()) {
            log.info("Guess number length not equal to secret number.");
            return new NumberBaseballGuessResult(
                    attempts,
                    NumberBaseballStatus.INVALID_LENGTH
            );
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < secretNumber.size(); i++) {
            if (guess.charAt(i) < '0' || guess.charAt(i) > '9') {
                log.info("Invalid character in guess: " + guess.charAt(i) + " at index " + i);
                return new NumberBaseballGuessResult(
                        attempts,
                        NumberBaseballStatus.INVALID_INPUT
                );
            }
            int digit = Integer.parseInt(guess.charAt(i) + "");

            if (secretNumber.get(i).equals(digit)) {
                strikes++;
            } else if (secretNumber.contains(digit)) {
                balls++;
            }
        }

        log.info("Guess result - Strikes: {}, Balls: {}", strikes, balls);
        attempts.add(new NumberBaseballTry(guess, strikes, balls));

        if (strikes == secretNumber.size()) {
            log.info("Game solved!");
            isSolved = true;
            return new NumberBaseballGuessResult(
                    attempts,
                    NumberBaseballStatus.SOLVED
            );
        }
        
        return new NumberBaseballGuessResult(
                attempts,
                NumberBaseballStatus.ONGOING
        );
    }
}
