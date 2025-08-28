package com.mc.algorithm_quiz.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        solution(list);
        System.out.println("The seven dwarfs are: " + list);
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
                }
            }
        }

        list.removeAll(toRemove);
        Collections.sort(list);
    }
}
