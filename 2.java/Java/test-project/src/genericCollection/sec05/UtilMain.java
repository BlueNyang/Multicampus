package genericCollection.sec05;

public class UtilMain {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("apple", 10);
        Pair<String, Integer> pair2 = new Pair<>("apple", 10);
        Pair<String, Integer> pair3 = new Pair<>("banana", 20);

        // Compare pairs
        boolean result1 = Util.compare(pair1, pair2); // true
        boolean result2 = Util.compare(pair1, pair3); // false

        System.out.println("pair1 equals pair2: " + result1);
        System.out.println("pair1 equals pair3: " + result2);
    }
}
