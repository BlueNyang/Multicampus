package kr.bluenyang.webgame.service.hangman.wordgen;

public class WordGenerator {
    public static Word getRandomWord() {
        WordBank wordBank = new WordBank();

        String category = wordBank.getRandomCategory();
        String word = wordBank.getRandomWord(category);

        return new Word(category, word);
    }
}
