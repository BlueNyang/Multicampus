package oopInheritance.sec11;

public class CastMain {
    public static void main(String[] ignoredArgs) {
        Animal ani = null;

        ani = new Cat();
        ani.show();
        ani.sound();

        ani.animalMethod();

        // declare a Cat Class reference variable
        // type of ani is Animal, a Ref object is referencing an object of a Cat type
        // Down-Casting
        Cat c = (Cat) ani;
        c.animalMethod();

        Animal aa = new Animal();
        // Cat cc = (Cat) aa; // This will throw a ClassCastException at runtime
        if (aa instanceof Cat) {
            Cat cc = (Cat) aa; // This will throw a ClassCastException at runtime
            cc.catMethod();
        } else {
            System.out.println("aa is not an instance of Cat");
        }
    }
}
