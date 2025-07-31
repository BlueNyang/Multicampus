package oopInheritance.sec10;

public class Cat extends Animal {
    @Override
    public void show() {
        System.out.println("Cat");
    }

    @Override
    public void sound() {
        System.out.println("Meow");
    }
}
