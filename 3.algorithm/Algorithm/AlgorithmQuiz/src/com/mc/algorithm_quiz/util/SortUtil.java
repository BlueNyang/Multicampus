package com.mc.algorithm_quiz.util;

import java.util.Random;

public class SortUtil {
    public static int[] createRandomIntArray(int size) {
        return new Random().ints(size, 0, 100).toArray();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void measure(String taskName, TimedTask task) {
        task.execute(taskName);
    }
}
