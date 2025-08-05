package multiThread.sec04;

public class MultiThreadEx {
    public static void main(String[] ignoredArgs) {
        MultiThread[] threads = new MultiThread[3];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MultiThread(i);
            threads[i].start();
        }

        System.out.println("All threads have finished execution.");
    }
}
