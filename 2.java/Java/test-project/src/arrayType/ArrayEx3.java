package arrayType;

import java.util.Arrays;
import java.util.Random;

public class ArrayEx3 {
    public static void main(String[] ignoredArgs) {
        int[] lottoNumbers = new int[6];
        Random random = new Random();
        int count = 0;

        while (count < 6) {
            int number = random.nextInt(45) + 1; // Generate a number between 1 and 45
            boolean isDuplicate = false;

            // Check for duplicates
            for (int i = 0; i < count; i++) {
                if (lottoNumbers[i] == number) {
                    isDuplicate = true;
                    break;
                }
            }

            // If no duplicate, add the number to the array
            if (!isDuplicate) {
                lottoNumbers[count] = number;
                count++;
            }
        }

        Arrays.sort(lottoNumbers);

        System.out.print("Lotto Numbers: ");
        System.out.println(Arrays.toString(lottoNumbers));
    }
}
