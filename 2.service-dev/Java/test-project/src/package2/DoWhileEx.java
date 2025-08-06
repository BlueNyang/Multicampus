package package2;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] ignoredArgs) {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.print("Enter a number: ");
            num = sc.nextInt();
            if (num != 7) {
                System.out.println("Try again!");
            }
        } while (num != 7);

        System.out.println("You entered 7, exiting the loop.");
        sc.close();
    }
}
