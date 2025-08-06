package genericCollection.sec01;

public class BoxMain {
    public static void main(String[] ignoredArgs) {
        Box box = new Box();
        box.set("Hello, World!");

        String message = (String) box.get();
    }
}
