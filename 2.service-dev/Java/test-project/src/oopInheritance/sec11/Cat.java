package oopInheritance.sec11;

public class Cat extends Animal {
    @Override
    public void show() {
        System.out.println("Cat");
    }

    @Override
    public void sound() {
        System.out.println("Meow");
    }

    public void catMethod() {
        System.out.println("Cat method");
    }
}
