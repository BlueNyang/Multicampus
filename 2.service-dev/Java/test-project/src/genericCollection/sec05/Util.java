package genericCollection.sec05;

public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.equals(p2);
    }
}
