package com.mc.a_encapsulation.method;

public class AutumnConcert {
    public void start() {
        System.out.println("Autumn Concert Start");
        Player player = new Player("guitar");
        player.play();
        System.out.println("Autumn Concert End");
    }
}
