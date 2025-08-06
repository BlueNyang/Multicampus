package oopApi.sec05;

import java.util.Random;

public class RandomSeed {
    public static void main(String[] ignoredArgs) {
        Random r = new Random(3);

        for (int i = 0; i < 10; i++) {
            int x = r.nextInt(10) + 1;
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
