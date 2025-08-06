package multiThread.sec02;

public class BeepPrintEx {
    public static void main(String[] ignoredArgs) {
        Runnable beepTask = new BeepTask();

        Thread thread = new Thread(beepTask);

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted: " + e.getMessage());
            }
        }
    }
}
