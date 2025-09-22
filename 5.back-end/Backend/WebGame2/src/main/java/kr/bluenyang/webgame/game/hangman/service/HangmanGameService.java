package kr.bluenyang.webgame.game.hangman.service;

import kr.bluenyang.webgame.game.hangman.dto.HangmanGameInfo;
import kr.bluenyang.webgame.game.hangman.dto.HangmanGameResult;

/**
 * HangmanGameService interface for managing Hangman game operations.
 */
public interface HangmanGameService {
    /**
     * Creates a new Hangman game data.
     *
     * @return HangmanGameInfo containing the initial game state.
     */
    HangmanGameInfo createNewGame();

    /**
     * Processes a letter guess in the Hangman game.
     *
     * @param hangmanGameInfo current game state
     * @param letter          the guessed letter
     * @return HangmanGameResult containing the updated game state after the guess
     */
    HangmanGameResult guessLetter(HangmanGameInfo hangmanGameInfo, char letter);
}
