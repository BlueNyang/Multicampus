package com.mc.algorithm.aOT;

import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        // Prompt the user to input an odd number
        int input = 0;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            input = sc.nextInt();
        }

        for (int y = 0; y < input; y++) {
            for (int x = 0; x < input; x++) {
                if ((x - y <= 0 && x + y < input)
                        || (y + x >= input - 1 && x - y >= 0)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
