package com.mc.algorithm.util;

@FunctionalInterface
public interface TimedTask extends Runnable {
    default void execute(String taskName) {
        long startTime = System.nanoTime();
        run();
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        double durationMilli = duration / 1_000_000.0;

        System.out.println(taskName + ": took " + durationMilli + " ms");
    }
}
