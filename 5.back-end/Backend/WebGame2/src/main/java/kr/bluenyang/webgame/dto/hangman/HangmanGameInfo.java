package kr.bluenyang.webgame.dto.hangman;

import kr.bluenyang.webgame.domain.hangman.SecretWord;

// HangmanGame의 정보를 담아 전달하는 DTO
public record HangmanGameInfo(SecretWord secretWord, HangmanDTO dto) {
}
