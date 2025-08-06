package oopInheritance.sec05;

class SuperClass {
    int x;
    int y;

    public SuperClass() {
        System.out.println("Super class constructor called.");
        x = 5;
        y = 50;
    }
}

class Sub extends SuperClass {
    int x;

    public Sub() {
        x = 10;
    }

    public void show() {
        System.out.println("x: " + x);
        System.out.println("this.x: " + this.x);
        System.out.println("super.x: " + super.x);
        System.out.println("y(super): " + y);
    }
}

public class SuperRefMain {
    public static void main(String[] ignoredArgs) {
        new Sub().show();
    }
}
