package kr.bluenyang.webgame.game.hangman.util;

import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;

public class WordGenerator {
    public static SecretWordVO getRandomWord() {
        WordBank wordBank = new WordBank();

        String category = wordBank.getRandomCategory();
        String word = wordBank.getRandomWord(category);

        return new SecretWordVO(word, category);
    }
}
