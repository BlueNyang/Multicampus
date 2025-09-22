package kr.bluenyang.webgame.game.hangman.dto;

import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;

// HangmanGame의 정보를 담아 전달하는 DTO
// Service 객체와 Controller 객체 사이에서 사용
public record HangmanGameInfo(SecretWordVO secretWord, HangmanDTO dto) {
}
