package genericCollection.sec17;

import java.util.ArrayList;
import java.util.Collections;

public class SortCollection {
    static void printList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] ignoredArgs) {
        // sort, reverse methods that are available in the Collections class.
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Transformers");
        myList.add("Star Wars");
        myList.add("Matrix");
        myList.add("Terminator");
        myList.add("Avatar");

        System.out.println("List Order:"); // guaranteed order of insertion
        for (String s : myList) {
            System.out.print(s + " | ");
        }

        System.out.println("\nASCENDING Order:");
        Collections.sort(myList);
        printList(myList);

        System.out.println("DESCENDING Order:");
        Collections.reverse(myList);
        printList(myList);
    }
}
