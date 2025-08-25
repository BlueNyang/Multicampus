package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

public class QuickSortRecursive {
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(100000);
        SortUtil.measure("QuickSortRecursive", () -> {
//            System.out.println("Before: " + Arrays.toString(arr));

            quickSort(arr, 0, arr.length - 1);

//            System.out.println("After: " + Arrays.toString(arr));
        });
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = QuickSort.partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }
}
