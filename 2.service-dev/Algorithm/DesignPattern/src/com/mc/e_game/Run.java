package com.mc.e_game;

import com.mc.e_game.characters.Player;
import com.mc.e_game.events.EventResult;
import com.mc.e_game.events.EventSelector;
import com.mc.e_game.events.data.Event;
import com.mc.e_game.utils.ScanInput;

public class Run {
    private static final int ITERATIONS = 8;

    public static void main(String[] args) {
        System.out.println("E-Game Start!");
        Player player = new Player("Hero", 100, 20, 10);
        EventSelector eventSelector = new EventSelector();

        for (int i = 0; i < ITERATIONS; i++) {
            Event event;
            if (i == ITERATIONS - 1) {
                System.out.println("============Final Day============");
                event = eventSelector.getFinalEvent();
            } else {
                System.out.println("============Day " + (i + 1) + "============");
                event = eventSelector.getNewRandomEvent();
            }

            EventResult res = event.startEvent(player);
            if (res == EventResult.FAILED) {
                System.out.println("Game Over!");
                ScanInput.getInstance().close();
                return;
            }
        }
        System.out.println("********************************");
        System.out.println("Congratulations! You have survived all the days!");
        ScanInput.getInstance().close();
    }
}
