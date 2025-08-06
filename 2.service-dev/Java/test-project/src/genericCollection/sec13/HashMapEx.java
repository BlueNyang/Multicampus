package genericCollection.sec13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] ignoredArgs) {
        // HashMap: unable to store duplicate keys but allows duplicate values.
        // (key, value) pair: collection of key-value pairs to store data.
        // separate data through a key: key is unique, value can be duplicated.
        Map<String, Integer> map = new HashMap<>();

        map.put("홍길동", 90);
        map.put("이몽룡", 80);
        map.put("성춘향", 95);
        map.put("홍길동", 85); // Duplicate key, value will be updated

        System.out.println("Map size: " + map.size());

        // get() method retrieves the value associated with a key.
        System.out.println("홍길동's score: " + map.get("홍길동"));

        // whole map iteration
        System.out.println("--------------------------------");
        System.out.println("All entries in the map:");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.keySet());
        }

        // KeySet variable
        Set<String> keySet = map.keySet();
        System.out.println("--------------------------------");
        System.out.println("KeySet size: " + keySet.size());
        for (String key : keySet) {
            System.out.println("Key: " + key);
        }

        // whole map iteration using (key, value) pair
        System.out.println("--------------------------------");
        System.out.println("All entries in the map using entrySet:");
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        // whole map iteration using entrySet()
        System.out.println("--------------------------------");
        System.out.println("All entries in the map using entrySet:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        System.out.println("--------------------------------");
        System.out.println(map.entrySet());

        // if a key does not exist, get() returns null
        System.out.println(map.get("변학도"));
    }
}
