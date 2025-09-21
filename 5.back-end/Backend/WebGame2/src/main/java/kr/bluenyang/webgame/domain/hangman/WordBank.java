package kr.bluenyang.webgame.domain.hangman;

import java.util.*;

// WordBank class to manage categories and words for a Hangman game
public class WordBank {

    // Map for storing categories and their corresponding words
    private static final Map<String, List<String>> categories = new HashMap<>();
    private static final Random random = new Random();

    // static initializer block to populate the categories map
    static {
        categories.put("Fruits", Arrays.asList("apple", "banana", "orange", "grape", "strawberry", "watermelon", "pineapple", "mango", "cherry", "peach"));
        categories.put("Animals", Arrays.asList("lion", "tiger", "elephant", "monkey", "giraffe", "zebra", "penguin", "kangaroo", "dolphin", "octopus"));
        categories.put("Countries", Arrays.asList("korea", "japan", "china", "canada", "france", "germany", "brazil", "egypt", "india", "russia"));
        categories.put("Sports", Arrays.asList("soccer", "basketball", "baseball", "tennis", "golf", "swimming", "volleyball", "badminton", "boxing", "skiing"));
        categories.put("Programming Languages", Arrays.asList("java", "python", "javascript", "typescript", "ruby", "swift", "kotlin", "rust", "golang", "scala"));
    }

    /**
     * returns the list of available categories.
     *
     * @return array of category names
     */
    public String[] getCategories() {
        return categories.keySet().toArray(new String[0]);
    }

    /**
     * returns a random word from the specified category.
     *
     * @param category the category from which to select a random word
     * @return a random word from the specified category, or null if the category does not exist or has no words
     */
    public String getRandomWord(String category) {
        List<String> words = categories.get(category);
        if (words != null && !words.isEmpty()) {
            int index = random.nextInt(words.size());
            return words.get(index);
        }
        return null;
    }

    /**
     * returns a random category name from the available categories.
     *
     * @return a random category name, or null if there are no categories
     */
    public String getRandomCategory() {
        String[] categoryArray = getCategories();
        if (categoryArray.length > 0) {
            int index = random.nextInt(categoryArray.length);
            return categoryArray[index];
        }
        return null;
    }
}
