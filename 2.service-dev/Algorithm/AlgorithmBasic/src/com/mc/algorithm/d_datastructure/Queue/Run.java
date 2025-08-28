package com.mc.algorithm.d_datastructure.Queue;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        queueTest();
        System.out.println("Josephus Problem (n=7, k=3): " + josephus(7, 3));

    }

    public static void queueTest() {
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(queue.poll() + " ");
        }
    }

    public static List<Integer> josephus(int n, int k) {
        MyQueue<Integer> queue = new MyQueue<>(n);

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
