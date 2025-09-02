package com.mc.algorithm_quiz.bruteforce;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int n = sc.nextInt();

            System.out.println("The " + n + "th the apocalypse number is: " + q1(n));
        }
    }

    private static int q1(int n) {
        int count = 0;
        int result = 666;
        while (count < n) {
            String str = String.valueOf(result);
            if (str.contains("666")) {
                count++;
            }
            if (count < n) {
                result++;
            }
        }
        return result;
    }
}
