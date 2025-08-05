package genericCollection.sec16;

import java.util.Hashtable;
import java.util.Scanner;

public class HashTableEx {
    public static void main(String[] ignoredArgs) {
        // HashTable is very similar to HashMap, but it's synchronized and does not allow null keys or values.
        // It is part of the legacy collection framework and is generally not recommended for new code.

        // Example usage of HashTable
        Hashtable<String, String> table = new Hashtable<>();

        table.put("spring", "12");
        table.put("summer", "123");
        table.put("autumn", "123");
        table.put("winter", "123");

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter the id and password");
            while (true) {
                System.out.print("ID (or type 'exit' to quit): ");
                String id = scanner.nextLine();
                if ("exit".equalsIgnoreCase(id)) {
                    break;
                }
                
                System.out.print("Password: ");
                String password = scanner.nextLine();


                // Check if the entered id and password match any entry in the hashtable
                if (table.containsKey(id) && table.get(id).equals(password)) {
                    System.out.println("Login successful!");
                    break;
                } else {
                    System.out.println("Invalid ID or password.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Exiting the program.");
        }
    }
}
