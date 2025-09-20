package kr.bluenyang.webgame.dto.hangman;

import kr.bluenyang.webgame.service.hangman.HangmanGuessResult;

public record HangmanGameResult(HangmanGuessResult hangmanGameResult, HangmanDTO dto) {
}
