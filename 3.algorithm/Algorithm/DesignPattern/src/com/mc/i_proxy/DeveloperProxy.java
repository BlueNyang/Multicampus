package com.mc.i_proxy;

public class DeveloperProxy implements Developer {
    Developer developer;

    public DeveloperProxy(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void develop() {
        System.out.println("[system] 출근 카드를 찍는다");

        try {
            developer.develop();
        } catch (Exception e) {
            System.out.println("쉬는 날");
        } finally {
            System.out.println("퇴근");
        }
    }
}
