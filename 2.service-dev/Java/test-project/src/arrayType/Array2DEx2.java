package arrayType;

import java.util.*;

public class Array2DEx2 {
    public static void main(String[] ignoredArgs) {
        String[][] words = {
                {"chair", "의자"},
                {"computer", "컴퓨터"},
                {"integer", "정수"},
        };

        // Shuffle the word array to randomize the order of questions
        // 추가적으로 words 배열을 List로 변환하여 섞기
        shuffleArray(words);

        System.out.println("영어 단어와 뜻을 맞추는 게임입니다.");
        Game(words);
        System.out.println("모든 문제가 끝났습니다.");
    }

    private static void shuffleArray(String[][] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static void Game(String[][] words) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < words.length; i++) {
                System.out.printf("Q%d. %s의 뜻은? : ", i + 1, words[i][0]);
                String answer = sc.nextLine();
                if (words[i][1].equals(answer)) {
                    System.out.println("정답입니다!");
                } else {
                    System.out.printf("틀렸습니다. %s의 뜻은 %s 입니다.%n", words[i][0], words[i][1]);
                }
            }
            // try-with-resources 구문을 사용하여 Scanner를 자동으로 닫음
        } catch (Exception e) {
            System.out.println("입력 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
