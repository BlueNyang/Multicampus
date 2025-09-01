package com.mc.algorithm_quiz.bruteforce;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateNineDwarfs();
            solution(list);
            System.out.println("The seven dwarfs are: " + list);
        }
    }

    private static void solution(List<Integer> list) {
        int total = list.stream().mapToInt(Integer::intValue).sum();
        int target = total - 100;

        List<Integer> toRemove = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    toRemove.add(list.get(i));
                    toRemove.add(list.get(j));
                    break;
                }
            }
            if (toRemove.size() == 2) {
                break;
            }
        }

        for (Integer integer : toRemove) {
            list.remove(integer);
        }

        Collections.sort(list);
    }

    private static List<Integer> generateNineDwarfs() {
        List<Integer> dwarfs = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            dwarfs.add(1);
        }

        for (int i = 0; i < 93; i++) {
            int idx = random.nextInt(7);
            dwarfs.set(idx, dwarfs.get(idx) + 1);
        }

        for (int i = 0; i < 2; i++) {
            dwarfs.add(random.nextInt(100));
        }

        Collections.shuffle(dwarfs);

        return dwarfs;
    }
}
