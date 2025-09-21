package kr.bluenyang.webgame.game.hangman.service;

import kr.bluenyang.webgame.game.hangman.dto.HangmanGameInfo;
import kr.bluenyang.webgame.game.hangman.dto.HangmanGameResult;

public interface HangmanGameService {
    HangmanGameInfo createNewGame();

    HangmanGameResult guessLetter(HangmanGameInfo hangmanGameInfo, char letter);
}
