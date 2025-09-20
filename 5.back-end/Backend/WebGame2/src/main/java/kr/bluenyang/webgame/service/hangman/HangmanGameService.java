package kr.bluenyang.webgame.service.hangman;

import kr.bluenyang.webgame.domain.hangman.SecretWord;
import kr.bluenyang.webgame.dto.hangman.HangmanGameResult;
import kr.bluenyang.webgame.dto.hangman.HangmanDTO;
import kr.bluenyang.webgame.dto.hangman.HangmanGameInfo;
import kr.bluenyang.webgame.service.hangman.wordgen.Word;
import kr.bluenyang.webgame.service.hangman.wordgen.WordGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * HangmanGame class
 */
@Slf4j
public class HangmanGameService {
    private final String wordToGuess;
    private final HangmanDTO hangmanDTO;

    private static final List<String> HANGMAN_STAGES = Arrays.asList(
            "\n    +---+\n    |   |\n    O   |\n   /|\\  |\n   / \\  |\n        |\n=========",
            "\n    +---+\n    |   |\n    O   |\n   /|\\  |\n   /    |\n        |\n=========",
            "\n    +---+\n    |   |\n    O   |\n   /|\\  |\n        |\n        |\n=========",
            "\n    +---+\n    |   |\n    O   |\n   /|   |\n        |\n        |\n=========",
            "\n    +---+\n    |   |\n    O   |\n    |   |\n        |\n        |\n=========",
            "\n    +---+\n    |   |\n    O   |\n        |\n        |\n        |\n=========",
            "\n    +---+\n    |   |\n        |\n        |\n        |\n        |\n=========",
            "\n    +---+\n        |\n        |\n        |\n        |\n        |\n========="
    );

    public HangmanGameService(HangmanGameInfo hangmanGameInfo) {
        this.hangmanDTO = hangmanGameInfo.dto();
        this.wordToGuess = hangmanGameInfo.secretWord().word();
    }

    public static HangmanGameInfo createNewGame() {
        log.info("Creating a new Hangman game...");
        // Random word generator
        Word randomWord = WordGenerator.getRandomWord();
        String wordToGuess = randomWord.word();
        String wordCategory = randomWord.category();
        SecretWord secretWord = new SecretWord(wordToGuess, wordCategory);

        HangmanDTO hangmanDTO = new HangmanDTO();
        int length = wordToGuess.length();
        hangmanDTO.setCurrentWordState("_".repeat(length));
        hangmanDTO.setUsedLetters(new HashSet<>());
        hangmanDTO.setChancesLeft(7); // Default chances
        hangmanDTO.setHangmanVisual(HANGMAN_STAGES.get(7));
        hangmanDTO.setHangmanGameStatus(HangmanGameStatus.ONGOING);

        return new HangmanGameInfo(secretWord, hangmanDTO);
    }

    /**
     * Process a guessed letter
     *
     * @param letter The letter to guess
     * @return GuessResult (CORRECT, WRONG, ALREADY_USED, ALREADY_ENDED)
     */
    public HangmanGameResult guessLetter(char letter) {
        log.info("Guessing letter...");
        if (this.getGameStatus() != HangmanGameStatus.ONGOING) {
            log.info("The game has already ended.");
            return new HangmanGameResult(HangmanGuessResult.ALREADY_ENDED, hangmanDTO);
        }

        if (letter < 'a' || letter > 'z') {
            log.info("Invalid input: {}", letter);
            return new HangmanGameResult(HangmanGuessResult.INVALID_INPUT, hangmanDTO);
        }

        Set<Character> usedLetters = hangmanDTO.getUsedLetters();
        letter = Character.toLowerCase(letter);
        if (usedLetters.contains(letter)) {
            log.info("Letter '{}' has already been used.", letter);
            return new HangmanGameResult(HangmanGuessResult.ALREADY_USED, hangmanDTO);
        }

        usedLetters.add(letter);
        hangmanDTO.setUsedLetters(usedLetters);
        int chancesLeft = hangmanDTO.getChancesLeft();
        if (wordToGuess.indexOf(letter) == -1) {
            log.info("Letter '{}' is not in the word.", letter);
            hangmanDTO.setHangmanVisual(HANGMAN_STAGES.get(--chancesLeft));
            hangmanDTO.setChancesLeft(chancesLeft);
            if (this.getGameStatus() == HangmanGameStatus.LOST) {
                log.info("The player has lost the game.");
                hangmanDTO.setHangmanGameStatus(HangmanGameStatus.LOST);
                hangmanDTO.setCurrentWordState(wordToGuess);
                return new HangmanGameResult(HangmanGuessResult.WRONG, hangmanDTO);

            }
            log.info("Decreasing chances left.");
            hangmanDTO.setChancesLeft(chancesLeft);
            return new HangmanGameResult(HangmanGuessResult.WRONG, hangmanDTO);

        }

        StringBuilder current = new StringBuilder(hangmanDTO.getCurrentWordState());
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                current.setCharAt(i, letter);
            }
        }

        hangmanDTO.setCurrentWordState(current.toString());
        if (this.getGameStatus() == HangmanGameStatus.WON) {
            log.info("The player has won the game!");
            hangmanDTO.setHangmanGameStatus(HangmanGameStatus.WON);
            return new HangmanGameResult(HangmanGuessResult.CORRECT, hangmanDTO);
        }

        log.info("The player guessed correctly.");
        return new HangmanGameResult(HangmanGuessResult.CORRECT, hangmanDTO);
    }

    /**
     * Get the current game status
     *
     * @return GameStatus (WON, LOST, ONGOING)
     */
    public HangmanGameStatus getGameStatus() {
        if (hangmanDTO.getCurrentWordState().equals(wordToGuess)) {
            return HangmanGameStatus.WON;
        } else if (hangmanDTO.getChancesLeft() <= 0) {
            return HangmanGameStatus.LOST;
        } else {
            return HangmanGameStatus.ONGOING;
        }
    }
}
