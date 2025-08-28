package com.mc.algorithm_quiz.datastructer;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = sc.nextInt();

            List<Integer> trash = new ArrayList<>();

            int card = solution(trash, n);
            System.out.println("Trash: " + trash);
            System.out.println("Last card: " + card);
        }
    }

    private static int solution(List<Integer> trash, int n) {
        Queue<Integer> queue = new LinkedList<>();


        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            trash.add(queue.poll());
            queue.offer(queue.poll());
        }

        if (queue.isEmpty()) return 0;
        return queue.poll();
    }
}
