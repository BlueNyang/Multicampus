package com.mc.algorithm_quiz.datastructer;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        System.out.println("hashtable:\t" + solution("hashtable"));
        System.out.println("samsung:\t" + solution("samsung"));
        System.out.println("aabb:\t\t" + solution("aabb"));
    }

    public static List<Character> solution(String input) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxCount = 0;
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            maxCount = Math.max(maxCount, map.get(c));
        }

        Set<Map.Entry<Character, Integer>> resultSet = map.entrySet();
        List<Character> result = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : resultSet) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
