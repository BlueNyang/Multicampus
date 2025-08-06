package oopInheritance.sec12;

public class Circle extends DrawingObject {

    public Circle(String penColor) {
        this.penColor = penColor;
    }

    @Override
    void draw() {
        System.out.println("Drawing a circle with color: " + penColor);
    }
}
