package com.mc.algorithm.f_bruteforce.quiz;

public class Quiz {
    public static void main(String[] args) {
        q1(20);
    }

    private static void q1(int n) {
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

        System.out.println("The " + n + "th the apocalypse number is: " + result);

    }
}
