package com.mc.i_proxy;

public class Run {
    public static void main(String[] args) {
        new DeveloperProxy(new Man()).develop();
        System.out.println("===================");
        new DeveloperProxy(new Woman()).develop();
        System.out.println("===================");
        new DeveloperProxy(new Child()).develop();
    }
}
