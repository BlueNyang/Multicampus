package oopClass.sec06;

public class Circle {
    int radius;

    public void setCircle(int r) {
        radius = r;
    }

    public float area() {
        setCircle(5);
        return (float) (Math.PI * radius * radius);
    }
}
