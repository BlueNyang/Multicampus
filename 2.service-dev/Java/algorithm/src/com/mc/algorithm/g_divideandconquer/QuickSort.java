package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.d_datastructure.stack.MyStack;
import com.mc.algorithm.util.SortUtil;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = SortUtil.createRandomIntArray(100000);
        SortUtil.measure("QuickSortRecursive", () -> {
//            System.out.println("Before: " + Arrays.toString(arr));

            quickSort(arr, 0, arr.length - 1);

//            System.out.println("After: " + Arrays.toString(arr));
        });
    }

    private static void quickSort(int[] arr, int left, int right) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            int r = stack.pop();
            int l = stack.pop();
            if (l < r) {
                int pivot = partition(arr, l, r);
                stack.push(l);
                stack.push(pivot - 1);
                stack.push(pivot + 1);
                stack.push(r);
            }
        }
    }

    static int partition(int[] arr, int first, int last) {
        int pivot = getPivotIndex(arr, first, last);

        SortUtil.swap(arr, pivot, last);
        pivot = arr[last];

        int i = first - 1;
        for (int j = first; j < last; j++) {
            if (arr[j] <= pivot) {
                i++;
                SortUtil.swap(arr, i, j);
            }
        }
        SortUtil.swap(arr, i + 1, last);
        return i + 1;
    }

    private static int getPivotIndex(int[] arr, int first, int last) {
        int front = arr[first];
        int mid = arr[(first + last) / 2];
        int end = arr[last];

        if ((front >= mid && front <= end)
                || (front >= end && front <= mid)) {
            return first;
        } else if ((mid >= front && mid <= end)
                || (mid >= end && mid <= front)) {
            return (first + last) / 2;
        } else {
            return last;
        }
    }
}
