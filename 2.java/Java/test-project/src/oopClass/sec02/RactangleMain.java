package oopClass.sec02;

public class RactangleMain {
    public static void main(String[] ignoredArgs) {
        Rectangle r = new Rectangle();
        r.input();
        r.area();

        Rectangle r1 = new Rectangle();
        r1.width = 100;
        r1.height = 200;
        r1.area();
    }
}
