package multiThread.sec03;

public class BeepThreadMain {
    public static void main(String[] ignoredArgs) {
        Thread thread = new BeepThread();

        thread.start();
    }
}
