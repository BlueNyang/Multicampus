package oopClass.sec06;

public class CircleMain {
    public static void main(String[] ignoredArgs) {
        Circle ci = new Circle();

        ci.setCircle(5);

        float result = ci.area();
        System.out.println("Circle area: " + result);
    }
}
