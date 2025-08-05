package genericCollection.sec14;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx2 {
    public static void main(String[] ignoredArgs) {
        HashMap<String, String> map = new HashMap<>();
        // Using with Set
        //HashSet<Pair<String, String>> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("----- Enter key-value pairs -----");
            while (true) {
                // input: key=value
                System.out.print("Enter a word (or 'exit' to quit). Format is 'key=value': ");
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                String[] parts = input.split("=");
                if (parts.length != 2) {
                    System.out.println("Invalid input format. Please use 'key=value'.");
                    continue;
                }
                String key = parts[0].trim();
                String value = parts[1].trim();

                map.put(key, value);
                //set.add(new Pair<>(key, value));
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        System.out.println("----------------");
        System.out.println("----- Search worlds -----");

        try {
            while (true) {
                System.out.print("Enter a key to search (or 'exit' to quit): ");
                String key = scanner.nextLine();
                if ("exit".equalsIgnoreCase(key)) {
                    break;
                }

                String value = map.get(key);
                // String value = set.stream()
                //         .filter(pair -> pair.getKey().equals(key))
                //         .map(Pair::getValue)
                //         .findFirst()
                //         .orElse(null);

                if (value != null) {
                    System.out.println("Value for '" + key + "' in korean: " + value);
                } else {
                    System.out.println("Key '" + key + "' not found.");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
