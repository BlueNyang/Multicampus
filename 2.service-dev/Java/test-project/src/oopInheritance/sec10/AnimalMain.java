package oopInheritance.sec10;

public class AnimalMain {
    public static void main(String[] ignoredArgs) {
        Animal ani;
        ani = new Animal();
        ani.show();
        ani.sound();

        ani = new Cat();
        ani.show();
        ani.sound();

        ani = new Dog();
        ani.show();
        ani.sound();
    }
}
