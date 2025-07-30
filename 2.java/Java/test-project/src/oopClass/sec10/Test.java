package oopClass.sec10;

public class Test {
    int width;
    int height;

    void printArea() {
        System.out.println("Area: " + (width * height)); // Instance method uses instance variables
    }
    
    static void area() {
        System.out.println("Area: " + (100 * 200)); // Static method uses fixed values
    }
}
