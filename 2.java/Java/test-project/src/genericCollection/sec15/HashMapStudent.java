package genericCollection.sec15;

import java.util.LinkedHashMap;

public class HashMapStudent {
    public static void main(String[] ignoredArgs) {
        // Map<Student, Integer> map = new HashMap<>(); // No guaranteed order
        LinkedHashMap<Student, Integer> map = new LinkedHashMap<>(); // Maintains insertion order

        // Same when storing entry in a map except that a key is a custom class instance.
        map.put(new Student(1, "Alice"), 90);
        map.put(new Student(2, "Alice"), 85);
        map.put(new Student(3, "Charlie"), 95); // Separate students by sNo. There's a rule that no students with the same number exist.
        // The following line will replace the value for the existing key
        // update shen the same key is used - hashCode() and equals() methods are used to find the key
        map.put(new Student(3, "Charlie"), 100);

        for (Student k : map.keySet()) {
            System.out.println("Key: " + k + ", Value: " + map.get(k));
        }
    }
}
