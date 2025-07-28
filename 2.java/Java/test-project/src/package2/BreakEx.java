package package2;

import java.util.Scanner;

public class BreakEx {
    public static void main(String[] ignoredArgs) {
        int balance = 100000;
        Scanner sc = new Scanner(System.in);

        System.out.println("Current balance: " + balance);
        do {
            System.out.print("Enter amount to withdraw (0 to exit): ");
            int withdrawal = sc.nextInt();

            if (withdrawal == 0) {
                System.out.println("Exiting...");
                break;
            } else if (withdrawal < 0) {
                System.out.println("Invalid amount. Please enter a positive number.");
            } else if (withdrawal > balance) {
                System.out.println("Insufficient funds. Current balance: " + balance);
                break;
            } else {
                balance -= withdrawal;
            }
        } while (balance > 0);
    }
}
