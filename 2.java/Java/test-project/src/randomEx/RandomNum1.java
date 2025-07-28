package randomEx;

public class RandomNum1 {
    public static void main(String[] ignoredArgs) {
        int[] randomNumbers = new int[10];
        int epochs = 10000000;

        for (int i = 0; i < epochs; i++) {
            double num = Math.random();
            num *= 10;
            num = Math.floor(num);

            randomNumbers[(int) num]++;
        }

        System.out.println("Random numbers generated:");
        System.out.println("Epochs: " + epochs);
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.printf("%d: %.2f%%\t", i, (double) randomNumbers[i] * 100 / epochs);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
