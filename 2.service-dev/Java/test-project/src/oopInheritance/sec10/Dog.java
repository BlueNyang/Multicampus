package oopInheritance.sec10;

public class Dog extends Animal {
    @Override
    public void show() {
        System.out.println("Dog");
    }

    @Override
    public void sound() {
        System.out.println("Bark");
    }
}
