package com.mc.a_encapsulation.method;

public class SpringConcert {
    public void start() {
        System.out.println("Start Spring Concert");
        Player player = new Player("Violin");
        player.play();
        System.out.println("End Spring Concert");
    }
}
