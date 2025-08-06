package genericCollection.sec02;

public class BoxGenMain {
    public static void main(String[] ignoredArgs) {
        Box<String> box = new Box<>();
        box.set("Hello, Generics!");
        String content = box.get();
        System.out.println("Box contains: " + content);
    }
}
