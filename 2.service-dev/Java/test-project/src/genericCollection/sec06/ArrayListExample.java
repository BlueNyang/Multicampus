package genericCollection.sec06;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] ignoredArgs) {
        final int SIZE = 4; // Number of strings to input
        ArrayList<String> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Enter a string>> ");
            String input = sc.nextLine();
            list.add(input);
        }
        sc.close();

        System.out.println("-----------------------");
        String maxLengthString = "";
        for (String item : list) {
            System.out.print(item + " ");
            if (item.length() > maxLengthString.length()) {
                maxLengthString = item;
            }
        }
        System.out.println();
        System.out.println("The longest string is: " + maxLengthString);
        System.out.println("The length of the longest string is: " + maxLengthString.length());
    }
}
