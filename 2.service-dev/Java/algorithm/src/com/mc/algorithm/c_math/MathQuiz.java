package com.mc.algorithm.c_math;

public class MathQuiz {
    public static void main(String[] args) {
        System.out.println("This number is a prime number? : " + isPrime(11));
        System.out.println("Greatest common divisor of 12 and 18: " + gcd(12, 18));
        System.out.println("Least common multiple of 12 and 18: " + lcm(12, 18));
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 5: " + factorialTail(5, 1));
    }

    private static int factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers are not allowed for factorial.");
        if (n <= 1) return 1;

        return n * factorial(n - 1);
    }

    private static int factorialTail(int n, int res) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers are not allowed for factorial.");
        if (n <= 1) return res;

        res = n * res;
        return factorialTail(--n, res);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int i = 3; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
