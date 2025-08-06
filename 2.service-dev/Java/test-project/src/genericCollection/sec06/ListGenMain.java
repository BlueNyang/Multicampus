package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;

public class ListGenMain {
    public static void main(String[] ignoredArgs) {
        List<String> list = new ArrayList<String>();

        list.add("java");
        list.add("database");
        list.add("html");
        list.add("java"); // able to add duplicate items

        System.out.println("List size: " + list.size());
        System.out.println("List contents:");
        for (String item : list) System.out.println(item);

        System.out.println("-----");
        list.remove(1);

        System.out.println("After removing item at index 1:");
        System.out.println("List contents:");
        for (String item : list) System.out.println(item);

        list.add("Multimedia");
        System.out.println("-----");

        for (String item : list) System.out.println(item + ": " + item.length());
        System.out.println("-----");
        for (String item : list) System.out.println(item.length());
    }
}
