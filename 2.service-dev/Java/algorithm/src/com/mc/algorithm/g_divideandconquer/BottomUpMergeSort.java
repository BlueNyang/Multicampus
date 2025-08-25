package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

public class BottomUpMergeSort {
    public static void main(String[] args) {
        SortUtil.measure("Merge Sort (Bottom-Up)", () -> {
            int[] arr = SortUtil.createRandomIntArray(100000);
//            System.out.print("Original array:\t");
//            System.out.println(Arrays.toString(arr));

            bottomUpMergeSort(arr);

//            System.out.print("Sorted array: \t");
//            System.out.println(Arrays.toString(arr));
        });
    }

    static void bottomUpMergeSort(int[] arr) {
        int n = arr.length;
        for (int size = 1; size < n; size *= 2) { // log(n)
            for (int left = 0; left < n - size; left += 2 * size) { // n/size
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(arr, left, mid, right);
            }
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int lSize = mid - left + 1;
        int rSize = right - mid;

        if (rSize == 0 || lSize == 0) {
            return;
        }

        int[] leftArr = new int[lSize];
        int[] rightArr = new int[rSize];

        System.arraycopy(arr, left, leftArr, 0, lSize);
        System.arraycopy(arr, mid + 1, rightArr, 0, rSize);

        int i = 0, j = 0;
        int k = left;
        while (i < lSize && j < rSize) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < lSize) {
            arr[k++] = leftArr[i++];
        }

        while (j < rSize) {
            arr[k++] = rightArr[j++];
        }
    }
}
