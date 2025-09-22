package kr.bluenyang.webgame.game.hangman.dto;

import kr.bluenyang.webgame.game.hangman.model.HangmanGameStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
// View Layer에서 나타낼 Data를 담는 DTO
public class HangmanDTO {
    private String currentWordState;
    private Set<Character> usedLetters;
    private int chancesLeft;
    private String hangmanVisual;
    private HangmanGameStatus hangmanGameStatus;

}
