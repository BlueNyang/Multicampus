package com.mc.algorithm_quiz.datastructer;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter n for Josephus Problem: ");
            int n = sc.nextInt();
            System.out.print("Enter k for Josephus Problem: ");
            int k = sc.nextInt();

            // example: n = 7, k = 3
            System.out.println("Josephus Problem (n=" + n + ", k=" + k + "): " + josephus(n, k));
        }

    }

    public static List<Integer> josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            if (count == k) {
                result.add(current);
                count = 0;
            } else {
                queue.offer(current);
            }
        }

        return result;
    }
}
