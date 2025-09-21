package kr.bluenyang.webgame.game.hangman.service;

import kr.bluenyang.webgame.game.hangman.model.HangmanGameStatus;
import kr.bluenyang.webgame.game.hangman.model.HangmanGuessResult;
import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;
import kr.bluenyang.webgame.game.hangman.dto.HangmanGameResult;
import kr.bluenyang.webgame.game.hangman.dto.HangmanDTO;
import kr.bluenyang.webgame.game.hangman.dto.HangmanGameInfo;
import kr.bluenyang.webgame.game.hangman.util.WordGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * HangmanGame class
 */
@Slf4j
public class HangmanGameServiceImpl implements HangmanGameService {
    // Stage에 나타날 행맨 그림
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

    public HangmanGameServiceImpl() {
    }

    /**
     * Create a new Hangman game
     *
     * @return HangmanGameInfo (SecretWordVO, HangmanDTO)
     */
    @Override
    public HangmanGameInfo createNewGame() {
        log.info("Creating a new Hangman game...");
        // Random word generator
        SecretWordVO secretWord = WordGenerator.getRandomWord();

        // DTO initialization
        HangmanDTO hangmanDTO = new HangmanDTO();
        int length = secretWord.word().length();
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
    @Override
    public HangmanGameResult guessLetter(HangmanGameInfo hangmanGameInfo, char letter) {
        var hangmanDTO = hangmanGameInfo.dto();
        var wordToGuess = hangmanGameInfo.secretWord().word();

        log.info("Guessing letter...");
        if (this.getGameStatus(hangmanDTO, wordToGuess) != HangmanGameStatus.ONGOING) {
            log.info("The game has already ended.");
            return new HangmanGameResult(HangmanGuessResult.ALREADY_ENDED, hangmanDTO);
        }

        // 사용자 입력 유효성 검사
        if (letter < 'a' || letter > 'z') {
            log.info("Invalid input: {}", letter);
            return new HangmanGameResult(HangmanGuessResult.INVALID_INPUT, hangmanDTO);
        }

        // 이미 사용된 글자인지 확인
        Set<Character> usedLetters = hangmanDTO.getUsedLetters();
        letter = Character.toLowerCase(letter);
        if (usedLetters.contains(letter)) {
            log.info("Letter '{}' has already been used.", letter);
            return new HangmanGameResult(HangmanGuessResult.ALREADY_USED, hangmanDTO);
        }

        // 이미 사용된 글자가 아니면 추가
        usedLetters.add(letter);
        // Update DTO
        hangmanDTO.setUsedLetters(usedLetters);

        // 틀렸는지 확인하고, 남은 기회 업데이트
        int chancesLeft = hangmanDTO.getChancesLeft();
        if (wordToGuess.indexOf(letter) == -1) {
            // 틀린 경우
            log.info("Letter '{}' is not in the word.", letter);
            // 화면의 행맨 그림 업데이트
            hangmanDTO.setHangmanVisual(HANGMAN_STAGES.get(--chancesLeft));
            hangmanDTO.setChancesLeft(chancesLeft);

            // 더이상 기회가 없는지 확인
            if (this.getGameStatus(hangmanDTO, wordToGuess) == HangmanGameStatus.LOST) {
                log.info("The player has lost the game.");
                hangmanDTO.setHangmanGameStatus(HangmanGameStatus.LOST);
                hangmanDTO.setCurrentWordState(wordToGuess);
                return new HangmanGameResult(HangmanGuessResult.WRONG, hangmanDTO);

            }
            // 남은 기회가 있으면 계속 진행
            log.info("Decreasing chances left.");
            return new HangmanGameResult(HangmanGuessResult.WRONG, hangmanDTO);

        }

        // 맞춘 경우 - 현재 단어 상태 업데이트
        StringBuilder current = new StringBuilder(hangmanDTO.getCurrentWordState());
        for (int i = 0; i < wordToGuess.length(); i++) {
            // StringBuilder를 사용하여 특정 인덱스의 문자를 교체
            if (wordToGuess.charAt(i) == letter) {
                current.setCharAt(i, letter);
            }
        }

        // Update DTO
        hangmanDTO.setCurrentWordState(current.toString());
        // 게임이 끝났는지 확인
        if (this.getGameStatus(hangmanDTO, wordToGuess) == HangmanGameStatus.WON) {
            log.info("The player has won the game!");
            hangmanDTO.setHangmanGameStatus(HangmanGameStatus.WON);
            return new HangmanGameResult(HangmanGuessResult.CORRECT, hangmanDTO);
        }

        // 아직 게임이 끝나지 않았으면 계속 진행
        log.info("The player guessed correctly.");
        return new HangmanGameResult(HangmanGuessResult.CORRECT, hangmanDTO);
    }

    /**
     * Get the current game status
     *
     * @return GameStatus (WON, LOST, ONGOING)
     */
    private HangmanGameStatus getGameStatus(HangmanDTO hangmanDTO, String wordToGuess) {
        if (hangmanDTO.getCurrentWordState().equals(wordToGuess)) {
            return HangmanGameStatus.WON;
        } else if (hangmanDTO.getChancesLeft() <= 0) {
            return HangmanGameStatus.LOST;
        } else {
            return HangmanGameStatus.ONGOING;
        }
    }
}
