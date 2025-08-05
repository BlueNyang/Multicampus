package genericCollection.sec08;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class LinkedListMain {
    public static void main(String[] ignoredArgs) {
        final int SIZE = 100000;

        List<String> listArrList = new ArrayList<>();
        List<String> listLinedList = new LinkedList<>();

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        long startTime = System.nanoTime();

        for (int i = 0; i < SIZE; i++) {
            listArrList.add("Element " + i);
        }
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        System.out.println("Time taken to add 100000 elements to ArrayList: " + timeTaken + " ns, " + (timeTaken / 1000000.0) + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            listLinedList.add("Element " + i);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("Time taken to add 100000 elements to LinkedList: " + timeTaken + " ns, " + (timeTaken / 1000000.0) + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add("Element " + i);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("Time taken to add 100000 elements to ArrayList (using ArrayList): " + timeTaken + " ns, " + (timeTaken / 1000000.0) + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add("Element " + i);
        }
        endTime = System.nanoTime();
        timeTaken = endTime - startTime;
        System.out.println("Time taken to add 100000 elements to LinkedList (using LinkedList): " + timeTaken + " ns, " + (timeTaken / 1000000.0) + "ms");
    }
}
