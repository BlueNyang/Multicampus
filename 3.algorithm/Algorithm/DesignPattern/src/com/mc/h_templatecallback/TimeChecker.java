package com.mc.h_templatecallback;

public class TimeChecker {

    public void checkTime(Timer target) {
        long start = System.currentTimeMillis();

        target.start();

        long end = System.currentTimeMillis();
        System.out.printf("소요시간 : %s \n", end - start);
    }

}
