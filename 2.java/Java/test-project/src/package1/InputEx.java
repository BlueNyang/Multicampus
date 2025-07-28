package package1;

import java.text.MessageFormat;
import java.util.Scanner;

public class InputEx {
    public static void main(String[] ignoredArgs) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.println("Number 1: ");
        num1 = sc.nextInt();
        System.out.println("Number 2: ");
        num2 = sc.nextInt();

        System.out.println(MessageFormat.format("Sum of the two numbers: {0}", num1 + num2));

        sc.nextFloat();

        sc.next();

        sc.close();
    }
}
