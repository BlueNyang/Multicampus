package kr.bluenyang.practice.aop.sec01;

public class Rect {
    private int width, height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void showRectResult() {
        System.out.println("Area: " + (width * height));
        System.out.println("Perimeter: " + 2 * (width + height));
    }
}
