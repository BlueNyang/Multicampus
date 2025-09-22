package kr.bluenyang.webgame.game.hangman.util;

import kr.bluenyang.webgame.game.hangman.model.SecretWordVO;

// WordGenerator class to generate a random word and its category
public class WordGenerator {
    public static SecretWordVO getRandomWord() {
        WordBank wordBank = new WordBank();

        String category = wordBank.getRandomCategory();
        String word = wordBank.getRandomWord(category);

        return new SecretWordVO(word, category);
    }
}
