package com.mc.algorithm.h_dp;

import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

public class DynamicProgramming {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};

        SortUtil.measure("q1", () -> {
//            System.out.println("fiboRecursive(" + n + ") = " + fiboRecursive(n));
//            System.out.println("fiboDP(" + n + ") = " + fiboDP(n));
            System.out.println("dp_ex(arr) = " + dp_ex(arr));
        });

    }

    private static int fiboRecursive(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return fiboRecursive(n - 1) + fiboRecursive(n - 2);
    }

    private static int fiboDP(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println("dp: " + Arrays.toString(dp));

        return dp[n];
    }

    private static int dp_ex(int[] arr) {
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
