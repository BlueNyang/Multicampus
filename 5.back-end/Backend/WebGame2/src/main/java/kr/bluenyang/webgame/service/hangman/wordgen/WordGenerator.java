package kr.bluenyang.webgame.service.hangman.wordgen;

import kr.bluenyang.webgame.domain.hangman.SecretWord;
import kr.bluenyang.webgame.domain.hangman.WordBank;

public class WordGenerator {
    public static SecretWord getRandomWord() {
        WordBank wordBank = new WordBank();

        String category = wordBank.getRandomCategory();
        String word = wordBank.getRandomWord(category);

        return new SecretWord(word, category);
    }
}
