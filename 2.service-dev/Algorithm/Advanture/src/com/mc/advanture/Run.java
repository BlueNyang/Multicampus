package com.mc.advanture;

import com.mc.advanture.characters.Player;
import com.mc.advanture.events.EventResult;
import com.mc.advanture.events.EventSelector;
import com.mc.advanture.events.data.Event;
import com.mc.advanture.utils.ScanInput;

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
                System.out.println("Game Over! You have been defeated.");
                return;
            } else if (res == EventResult.EXIT) {
                ExitGame("Player chose to exit. Goodbye!");
                return;
            }
        }
        System.out.println("********************************");
        ExitGame("Congratulations! You have survived all the days!");
    }

    private static void ExitGame(String message) {
        System.out.println("You chose to exit the game. Goodbye!");
        ScanInput.getInstance().close();
        System.exit(0);
    }
}
