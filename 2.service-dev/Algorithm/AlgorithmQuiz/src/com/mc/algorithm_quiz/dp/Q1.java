package com.mc.algorithm_quiz.dp;

import com.mc.algorithm_quiz.util.SortUtil;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};

        SortUtil.measure("q1", () -> {
            System.out.println("max = " + solution(arr));
        });

    }

    private static int solution(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0] + arr[1], arr[1]);

        int max = dp[0];
        for (int i = 2; i < n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i - 1] + arr[i];
            }
            if (dp[i] > max) max = dp[i];
        }

        System.out.println("dp: " + Arrays.toString(dp));
        return max;
    }
}
