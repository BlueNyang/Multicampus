package com.mc.algorithm.f_bruteforce;

import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(1000);
//        System.out.println(Arrays.toString(arr));

        SortUtil.measure("Selection Sort", () -> {
            selectionSort(arr);
//            System.out.println(Arrays.toString(arr));
        });
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = indexOfMan(arr, i);
            SortUtil.swap(arr, i, minIndex);
        }
    }

    private static int indexOfMan(int[] arr, int i) {
        int minIndex = i;
        for (int j = i + 1; j < arr.length; j++) {
            minIndex = arr[j] < arr[minIndex] ? j : minIndex;
        }
        return minIndex;
    }
}
