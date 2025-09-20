package kr.bluenyang.webgame.dto.hangman;

import kr.bluenyang.webgame.domain.hangman.SecretWord;

public record HangmanGameInfo(SecretWord secretWord, HangmanDTO dto) {
}
