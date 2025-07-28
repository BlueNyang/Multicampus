package randomEx;

import java.util.Random;

public class RandomNum2 {
    public static void main(String[] ignoredArgs) {
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int num = r.nextInt(10);
            System.out.println(num);
        }
    }
}
