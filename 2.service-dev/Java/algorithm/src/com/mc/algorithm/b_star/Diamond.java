package com.mc.algorithm.b_star;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        // Prompt the user to input an odd number
        int input = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter an even number: ");
            input = sc.nextInt();
        }

        // Check if the input is an even number
        if (input % 2 == 0) {
            System.out.println("Please enter an even number.");
            return;
        } else if (input < 1) {
            System.out.println("Please enter a positive even number greater than 0.");
            return;
        }

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                // Calculate the number of spaces needed for the diamond shape
                int counter = Math.abs(input / 2 - i);

                // Print spaces and stars
                if (j >= counter && j < input - counter) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            // Move to the next line
            System.out.println();
        }

    }
}
