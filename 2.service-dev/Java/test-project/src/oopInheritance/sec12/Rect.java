package oopInheritance.sec12;

public class Rect extends DrawingObject {
    public Rect(String penColor) {
        this.penColor = penColor;
    }

    @Override
    void draw() {
        System.out.println("Drawing a rectangle with color: " + penColor);
    }
}
