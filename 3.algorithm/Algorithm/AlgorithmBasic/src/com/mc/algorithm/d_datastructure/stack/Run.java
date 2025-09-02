package com.mc.algorithm.d_datastructure.stack;

import java.util.HashMap;
import java.util.Map;

public class Run {
    public static void main(String[] args) {
        System.out.println("{}()[]  \t:\t" + solution("{}()[]"));
        System.out.println("{()[]()}\t:\t" + solution("{()[]()}"));
        System.out.println("{([}])} \t:\t" + solution("{([}])}"));
        System.out.println("{[[((멀) 티캠 {퍼} [스])]]} \t:\t" + solution("{[[((멀) 티캠 {퍼} [스])]]}"));
        System.out.println("{[{{(멀) 티캠))) {퍼} [스])]} \t:\t" + solution("{[{{(멀) 티캠))) {퍼} [스])]}"));
    }

    public static boolean solution(String input) {
        MyStack<Character> stack = new MyStack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char c : input.toCharArray()) {
            if ("({[".indexOf(c) != -1) {
                stack.push(c);
            } else if (")}]".indexOf(c) != -1) {
                if (map.get(stack.pop()).equals(c)) {
                    continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
