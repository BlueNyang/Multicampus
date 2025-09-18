package kr.bluenyang.practice.aop.sec02;

public class Circle {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void showResult() {
        System.out.println("Circle area: " + (3.14 * radius * radius));
        System.out.println("Circle circumference: " + (2 * 3.14 * radius));
    }
}
