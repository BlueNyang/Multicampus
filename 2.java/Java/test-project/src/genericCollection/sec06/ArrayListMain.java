package genericCollection.sec06;

import java.util.ArrayList;

public class ArrayListMain {
    public static void main(String[] ignoredArgs) {
        // when if not using generics
        ArrayList list = new ArrayList();
        list.add("apple");
        list.add(10);
        list.add(3.14);
        list.add("apple"); // able to add duplicate items

        for (Object item : list) System.out.println(item);

        list.add(0, "changed");
        list.remove(1);

        System.out.println("After modifications:");
        for (Object item : list) System.out.println(item);

        System.out.println("-----");

        // when using generics
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("apple");
        // stringList.add(10); // This line would cause a compile-time error
        stringList.add("banana");
        stringList.add("cherry");
        stringList.add("apple"); // able to add duplicate items
        for (String item : stringList) {
            System.out.println(item);
        }
    }
}
