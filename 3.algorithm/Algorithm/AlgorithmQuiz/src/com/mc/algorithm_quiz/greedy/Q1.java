package com.mc.algorithm_quiz.greedy;

import com.mc.algorithm_quiz.util.SortUtil;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        int n = 3465;
        int[] coins = {50, 10, 100, 1, 500};

        SortUtil.measure("q1", () -> {
            greedy(n, coins);
        });
    }

    private static void greedy(int n, int[] coins) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int coin : coins) {
            list.add(coin);
        }

        list.sort(Collections.reverseOrder());

        for (int coin : list) {
            map.put(coin, 0);
            while (n >= coin) {
                n -= coin;
                map.put(coin, map.get(coin) + 1);
            }
        }

        System.out.print("count: ");
        for (int coin : list) {
            System.out.print(coin + " : " + map.get(coin) + ", ");
        }
        System.out.println();
    }
}
