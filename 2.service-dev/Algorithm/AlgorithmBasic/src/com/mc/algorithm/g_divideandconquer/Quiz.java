package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

import java.util.*;


public class Quiz {
    public static void main(String[] args) {
//        cpuCacheTest();

        SortUtil.measure("q1", () -> {
            System.out.println("result: " + q1_stack(2, 50));
//            System.out.println("result: " + q1(2, 50));
        });
    }

    private static long q1(long a, long b) {
        // a ^ b;
        if (b == 1) return a;
        if (b == 0) return 1;

        if (b % 2 == 0) {
            long half = q1(a, b / 2);
            return half * half;
        } else {
            return a * q1(a, b - 1);
        }
    }

    private static long q1_stack(long a, long b) {
        Stack<Long> stack = new Stack<>();

        while (b != 0) {
            if (b % 2 == 0) {
                stack.push(null);
                b = b / 2;
            } else {
                stack.push(a);
                b = b - 1;
            }
        }

        long result = 1L;
        while (!stack.isEmpty()) {
            Long val = stack.pop();
            if (val != null) {
                result *= val;
            } else {
                result *= result;
            }
        }

        return result;
    }

    private static void cpuCacheTest() {
        int size = 10240;
        int[][] dArr = new int[size][size];

        SortUtil.measure("", () -> {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    dArr[i][j] = i + j;
                }
            }
        });

        SortUtil.measure("", () -> {
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size; i++) {
                    dArr[i][j] = i + j;
                }
            }
        });
    }
}
