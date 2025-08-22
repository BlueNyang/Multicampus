package com.mc.algorithm.f_bruteforce;

import com.mc.algorithm.util.SortUtil;

public class BubbleSort {
    public static void main(String[] args) {
        SortUtil.measure("Bubble Sort", () -> {
            int[] arr = SortUtil.createRandomIntArray(1000);
            bubbleSort(arr);
        });

        SortUtil.measure("Bubble Sort (Optimized)", () -> {
            int[] arr = SortUtil.createRandomIntArray(1000);
            bubbleSort2(arr);
        });
    }

    private static void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[i] > arr[j]) {
                    SortUtil.swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void bubbleSort2(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[i] > arr[j]) {
                    SortUtil.swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
    }
}
