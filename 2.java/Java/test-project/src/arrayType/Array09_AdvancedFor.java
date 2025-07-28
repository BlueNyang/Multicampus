package arrayType;

public class Array09_AdvancedFor {
    public static void main(String[] ignoredArgs) {
        int[] scores = {95, 71, 84, 93, 89};

        for (int score : scores) {
            System.out.println("Score: " + score);
        }

        String[] flowers = {"Rose", "Sharon", "Azalea"};

        for (String flower : flowers) {
            System.out.print(flower + " ");
        }
        System.out.println();
    }
}
