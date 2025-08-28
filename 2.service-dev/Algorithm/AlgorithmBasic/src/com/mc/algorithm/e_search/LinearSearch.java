package com.mc.algorithm.e_search;

public class LinearSearch {
    public static void main(String[] args) {
        int target = 999;
        int[] nums = {1, 6, 12, 17, 999, 22, 14, 6, 19};

        int index = linearSearch(nums, target);
        System.out.println(index);

        index = sentinelSearch(nums, target);
        System.out.println(index);
    }

    private static int sentinelSearch(int[] nums, int target) {
        int lastIndex = nums.length - 1;

        if (nums[lastIndex] == target) {
            return lastIndex; // If the target is at the last index, return it
        }

        nums[lastIndex] = target;
        int i = 0;
        while (nums[i] != target) {
            if (i == lastIndex) {
                return -1;
            }
            i++;
        }
        return i;
    }

    private static int linearSearch(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == target) {
                return i; // Return the index where the target is found
            }
            i++;
        }
        return -1; // Return -1 if the target is not found
    }
}
