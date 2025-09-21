package kr.bluenyang.webgame.game.numbb.service;

import kr.bluenyang.webgame.game.numbb.dto.NumberBaseballGuessResult;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The NumberBaseballGame class
 */
@Slf4j
public class NumberBaseballGameServiceImpl implements NumberBaseballGameService {

    public NumberBaseballGameServiceImpl() {
    }

    @Override
    public List<Integer> createNewGame(int length) {
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
    @Override
    public NumberBaseballGuessResult makeGuess(List<Integer> secretNumber,
                                               List<NumberBaseballTryVo> attempts,
                                               NumberBaseballStatus status,
                                               String guess) {
        
        log.info("Attempting to guess number baseball game...");
        if (status == NumberBaseballStatus.SOLVED) {
            System.out.println("Game already solved.");
            return new NumberBaseballGuessResult(attempts, status);
        }

        if (guess.length() != secretNumber.size()) {
            log.info("Guess number length not equal to secret number.");
            status = NumberBaseballStatus.INVALID_LENGTH;
            return new NumberBaseballGuessResult(attempts, status);
        }

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < secretNumber.size(); i++) {
            if (guess.charAt(i) < '0' || guess.charAt(i) > '9') {
                log.info("Invalid character in guess: {} at index {}", guess.charAt(i), i);
                status = NumberBaseballStatus.INVALID_INPUT;
                return new NumberBaseballGuessResult(attempts, status);
            }
            int digit = Integer.parseInt(guess.charAt(i) + "");

            if (secretNumber.get(i).equals(digit)) {
                strikes++;
            } else if (secretNumber.contains(digit)) {
                balls++;
            }
        }

        log.info("Guess result - Strikes: {}, Balls: {}", strikes, balls);
        attempts.addFirst(new NumberBaseballTryVo(guess, strikes, balls));

        if (strikes == secretNumber.size()) {
            log.info("Game solved!");
            status = NumberBaseballStatus.SOLVED;
            return new NumberBaseballGuessResult(attempts, status);
        }

        return new NumberBaseballGuessResult(attempts, status);
    }
}
