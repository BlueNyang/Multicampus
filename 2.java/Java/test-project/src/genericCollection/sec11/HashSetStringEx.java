package genericCollection.sec11;

import java.util.Set;
import java.util.HashSet;

public class HashSetStringEx {
    public static void main(String[] ignoredArgs) {
        Set<String> set = new HashSet<>();

        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple"); // Duplicate will not be added
        set.add("Date");

        set.add(new String("Orange"));
        set.add(new String("Orange")); // Duplicate will not be added

        int size = set.size();
        System.out.println("Size of the set: " + size);

        //  Iterator<String> it = set.iterator();
        //  System.out.println("Elements in the set:");
        //  while (it.hasNext()) {
        //      String fruit = it.next();
        //      System.out.println(fruit);
        //  }

        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("--------------------");

        set.remove("Apple");
        set.remove("Date");
        System.out.println("Total elements after removal: " + set.size());
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("--------------------");

        set.clear();
        System.out.println("Total elements after clearing: " + set.size());
        if (set.isEmpty()) {
            System.out.println("The set is empty.");
        } else {
            System.out.println("The set is not empty.");
        }
    }
}
