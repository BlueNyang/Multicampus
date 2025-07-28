package package2;

import java.util.Scanner;

public class Control {
    public static void main(String[] ignoredArgs) {
        // Control Flow Statements in Java
        // Conditional Statements: if, else if, else, switch

        Scanner sc = new Scanner(System.in);

        // if-else statement
        System.out.print("Enter your score: ");
        int score = sc.nextInt();

        if (score >= 90) {
            if (score >= 95) {
                System.out.println("Grade: A+");
            } else {
                System.out.println("Grade: A0");
            }
        } else if (score >= 80) {
            if (score >= 85) {
                System.out.println("Grade: B+");
            } else {
                System.out.println("Grade: B0");
            }
        } else if (score >= 70) {
            if (score >= 75) {
                System.out.println("Grade: C+");
            } else {
                System.out.println("Grade: C0");
            }
        } else if (score >= 60) {
            if (score >= 65) {
                System.out.println("Grade: D+");
            } else {
                System.out.println("Grade: D0");
            }
        } else {
            System.out.println("Grade: F");
        }

        // switch statement
        System.out.print("Enter your year of study (1-4): ");
        String year = sc.next();

        switch (year) {
            case "1":
                System.out.println("1st Year");
                break;
            case "2":
                System.out.println("2nd Year");
                break;
            case "3":
                System.out.println("3rd Year");
                break;
            case "4":
                System.out.println("4th Year");
                break;
            default:
                System.out.println("Invalid Year");
                break;
        }

        /////////////////////////////////////////////////////////////////////

        System.out.print("Enter the integer(0-100): ");
        int score1 = sc.nextInt();
        char grade1 = switch (score1 / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };

        System.out.printf("Your grade is %c%n", grade1);

        sc.close();
    }
}
