package com.mc.algorithm.d_datastructure.map;

import com.mc.algorithm.d_datastructure.set.MyHashSetP3;

import java.util.ArrayList;
import java.util.List;

public class ExRun {
    public static void main(String[] args) {
        System.out.println(solution("hashtable"));
        System.out.println(solution("samsung"));
        System.out.println(solution("aabb"));
    }

    public static List<Character> solution(String input) {
        MyHashMap<Character, Integer> map = new MyHashMap<>();

        int maxCount = 0;
        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            maxCount = Math.max(maxCount, map.get(c));
        }

        MyHashSetP3<Entry<Character, Integer>> resultSet = map.getEntrySet();
        List<Character> result = new ArrayList<>();

        for (Entry<Character, Integer> entry : resultSet) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }

        return result;
    }
}
