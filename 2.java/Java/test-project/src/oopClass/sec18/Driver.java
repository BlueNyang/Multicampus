package oopClass.sec18;

public class Driver {
    public <T extends Vehicle> void driver(T t) {
        t.run();
    }
}
