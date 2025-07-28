package package2;

import java.util.Scanner;

public class Loop {
    public static void main(String[] ignoredArgs) {
        // Looping Statements in Java
        // for, while, do-while

        // for loop
        System.out.println("For Loop:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter dan (2-9): ");
        int dan = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d * %d = %d%n", dan, i, dan * i);
        }

        sc.close();
    }
}
