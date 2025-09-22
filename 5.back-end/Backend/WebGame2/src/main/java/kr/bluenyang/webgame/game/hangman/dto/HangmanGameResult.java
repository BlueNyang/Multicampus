package kr.bluenyang.webgame.game.hangman.dto;

import kr.bluenyang.webgame.game.hangman.model.HangmanGuessResult;

// HangmanGame의 결과를 담아 전달하는 DTO
public record HangmanGameResult(HangmanGuessResult hangmanGameResult, HangmanDTO dto) {
}
