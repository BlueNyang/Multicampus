package oopClass.sec02;

import java.util.Scanner;

public class Rectangle {
    int width;
    int height;

    public void input() {
        try (Scanner sc = new Scanner(System.in)) {
            width = sc.nextInt();
            height = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter two integers for width and height.");
        }
    }

    public void area() {
        if (width <= 0 || height <= 0) {
            System.out.println("Width and height must be positive integers.");
        } else {
            int area = width * height;
            System.out.println("Area of the rectangle: " + area);
        }
    }
}
