package multiThread.sec02;

import java.awt.*;

public class BeepPrintEx2 {
    public static void main(String[] ignoredArgs) {
        Thread thread = new Thread(() -> {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            }
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Beep " + (i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
