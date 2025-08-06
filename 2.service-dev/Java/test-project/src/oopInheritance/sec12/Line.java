package oopInheritance.sec12;

public class Line extends DrawingObject {

    // Constructor
    public Line(String penColor) {
        this.penColor = penColor;
    }


    @Override
    void draw() {
        System.out.println("Line drawn with color: " + penColor);
    }
}
