package kr.bluenyang.webgame.game.numbb.service;

import kr.bluenyang.webgame.game.numbb.dto.NumberBaseballGuessResult;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballStatus;
import kr.bluenyang.webgame.game.numbb.model.NumberBaseballTryVo;

import java.util.List;

public interface NumberBaseballGameService {

    /**
     * Create a new game with a secret number of specified length
     *
     * @param length the length of the secret number
     * @return a list of integers representing the secret number
     */
    List<Integer> createNewGame(int length);

    /**
     * Process a player's guess and return the result
     *
     * @param secretNumber the secret number to be guessed
     * @param attempts     the list of previous attempts
     * @param status       the current game status
     * @param guess        the player's guess as a string
     * @return the result of the guess including strikes, balls, and updated status
     */
    NumberBaseballGuessResult makeGuess(List<Integer> secretNumber,
                                        List<NumberBaseballTryVo> attempts,
                                        NumberBaseballStatus status,
                                        String guess);
}
