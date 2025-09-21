package kr.bluenyang.webgame.service.hangman;

import kr.bluenyang.webgame.dto.hangman.HangmanGameInfo;
import kr.bluenyang.webgame.dto.hangman.HangmanGameResult;

public interface HangmanGameService {
    HangmanGameInfo createNewGame();

    HangmanGameResult guessLetter(HangmanGameInfo hangmanGameInfo, char letter);
}
