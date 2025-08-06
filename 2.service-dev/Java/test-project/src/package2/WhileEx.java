package package2;

import java.util.Scanner;

public class WhileEx {
    public static void main(String[] ignoredArgs) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.print("Enter a number: ");
        num = sc.nextInt();

        while (num != 7) {
            System.out.println("Try again!");
            System.out.print("Enter a number: ");
            num = sc.nextInt();
        }
    }
}
