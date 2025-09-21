package kr.bluenyang.webgame.game.hangman.dto;

import kr.bluenyang.webgame.game.hangman.model.HangmanGuessResult;

public record HangmanGameResult(HangmanGuessResult hangmanGameResult, HangmanDTO dto) {
}
