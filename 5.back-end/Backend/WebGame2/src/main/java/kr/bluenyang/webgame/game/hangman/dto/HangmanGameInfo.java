package kr.bluenyang.webgame.game.hangman.dto;

import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;

// HangmanGame의 정보를 담아 전달하는 DTO
public record HangmanGameInfo(SecretWordVO secretWord, HangmanDTO dto) {
}
