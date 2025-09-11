package kr.bluenyang.practice.webgame.domain.hangman;

import kr.bluenyang.practice.webgame.domain.wordgen.Word;
import kr.bluenyang.practice.webgame.domain.wordgen.WordGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * HangmanGame class
 */
public class HangmanGame {
    private final String wordToGuess;
    private final String wordCategory;
    private final StringBuilder current;
    private final List<Character> usedLetters;
    private int chancesLeft;

    public HangmanGame() {
        // Random word generator
        Word randomWord = WordGenerator.getRandomWord();
        this.wordToGuess = randomWord.word();
        this.wordCategory = randomWord.category();

        int length = wordToGuess.length();
        this.current = new StringBuilder("_".repeat(length));
        this.usedLetters = new ArrayList<>();

        this.chancesLeft = 7; // Default chances
    }

    // Getters
    // Get number of chances left
    public int getChancesLeft() {
        return chancesLeft;
    }

    public String getCurrentGuess() {
        return current.toString();
    }

    public List<Character> getUsedLetters() {
        return usedLetters;
    }

    public String getWordToGuess() {
        return wordToGuess;
    }

    public String getWordCategory() {
        return wordCategory;
    }

    /**
     * Process a guessed letter
     *
     * @param letter The letter to guess
     * @return GuessResult (CORRECT, WRONG, ALREADY_USED, ALREADY_ENDED)
     */
    public HangmanGuessResult guessLetter(char letter) {
        if (this.getGameStatus() != HangmanGameStatus.ONGOING) {
            return HangmanGuessResult.ALREADY_ENDED;
        }

        letter = Character.toLowerCase(letter);
        if (usedLetters.contains(letter)) {
            return HangmanGuessResult.ALREADY_USED;
        }

        if (letter < 'a' || letter > 'z') {
            return HangmanGuessResult.INVALID_INPUT;
        }

        usedLetters.add(letter);

        if (wordToGuess.indexOf(letter) == -1) {
            chancesLeft--;
            return HangmanGuessResult.WRONG;
        }

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == letter) {
                current.setCharAt(i, letter);
            }
        }

        return HangmanGuessResult.CORRECT;
    }

    /**
     * Check if the word is completely guessed
     *
     * @return true if the word is completely guessed, false otherwise
     */
    public boolean isWordGuessed() {
        return current.toString().equals(wordToGuess);
    }

    /**
     * Get the current game status
     *
     * @return GameStatus (WON, LOST, ONGOING)
     */
    public HangmanGameStatus getGameStatus() {
        if (this.isWordGuessed()) {
            return HangmanGameStatus.WON;
        } else if (chancesLeft <= 0) {
            return HangmanGameStatus.LOST;
        } else {
            return HangmanGameStatus.ONGOING;
        }
    }
}
