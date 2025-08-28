package com.mc.algorithm.e_search;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 9999;
        int[] nums = {1, 3, 5, 10, 113, 5634, 9999, 24821, 33333, 55555};

        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // Avoid potential overflow

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1;
    }
}
