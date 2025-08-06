package genericCollection.sec04;

public class UtilMain {
    public static void main(String[] ignoredArgs) {
        Box<Integer> box1 = Util.boxing(100);
        System.out.println("Boxed value: " + box1.get());

        Box<String> box2 = Util.boxing("Hello, World!");
        System.out.println("Boxed value: " + box2.get());
    }
}
