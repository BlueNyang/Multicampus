package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

// Top-Down Merge Sort
public class MergeSort {
    public static void main(String[] args) {
        SortUtil.measure("Merge Sort (Top-Down)", () -> {
            int[] arr = SortUtil.createRandomIntArray(100000);
//            System.out.print("Original array:\t");
//            System.out.println(Arrays.toString(arr));

            arr = mergeSort(arr);

//            System.out.print("Sorted array: \t");
//            System.out.println(Arrays.toString(arr));
        });
    }

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        int[] res = merge(left, right);
        return res;
    }

    private static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p1 = 0, p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] <= b[p2]) {
                res[p1 + p2] = a[p1];
                p1++;
            } else {
                res[p1 + p2] = b[p2];
                p2++;
            }
        }

        while (p1 < a.length) {
            res[p1 + p2] = a[p1];
            p1++;
        }

        while (p2 < b.length) {
            res[p1 + p2] = b[p2];
            p2++;
        }

        return res;
    }
}
