package multiThread.sec02;

import java.awt.*;

public class BeepTask implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (InterruptedException e) {
                System.out.println("스레드가 인터럽트되었습니다: " + e.getMessage());
            }
        }
    }
}
