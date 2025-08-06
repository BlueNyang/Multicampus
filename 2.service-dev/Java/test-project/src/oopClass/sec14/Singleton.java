package oopClass.sec14;

public class Singleton {
    // Singleton instance
    // only one instance of Singleton can exist for the entire application

    // create a static field with its own class type - create an object of Singleton class
    private static final Singleton singleton = new Singleton();

    // Restrict access to the constructor as private, preventing initializing to use from outside the class
    private Singleton() {
    }

    // Implement a method returning the object reference variable with public static
    public static Singleton getInstance() {
        return singleton;
    }
}
