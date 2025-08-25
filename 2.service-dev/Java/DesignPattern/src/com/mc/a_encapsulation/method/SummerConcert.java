package com.mc.a_encapsulation.method;

public class SummerConcert {
    public void start() {
        System.out.println("Start Summer Concert");
        Player player = new Player("Piano");
        player.play();
        System.out.println("End Summer Concert");
    }
}
