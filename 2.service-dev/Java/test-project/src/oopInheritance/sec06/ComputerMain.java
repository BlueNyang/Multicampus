package oopInheritance.sec06;

public class ComputerMain {
    public static void main(String[] ignoredArgs) {
        double r = 10.0;

        Calculator cal = new Calculator();
        System.out.println("Area of circle with radius " + r + " is: " + cal.areaCircle(r));

        Computer comp = new Computer();
        System.out.println("Area of circle with radius " + r + " is: " + comp.areaCircle(r));

        Calculator cal2 = new Computer();
        System.out.println("Area of circle with radius " + r + " is: " + cal2.areaCircle(r));
    }
}
