package oopException.sec02;

import java.util.Scanner;

public class ExceptionEx {
    public static void main(String[] ignoredArgs) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();
            int result = num1 / num2;

            System.out.println("Result: " + result);
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero. Please enter a non-zero second number.");
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
