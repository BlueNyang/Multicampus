package oopInheritance.sec08;

public class MyCar {
    public int speed;

    public void speedUp() {
        speed++;
    }

    final public void stop() {
        System.out.println("Stop the car");
        speed = 0;
    }
}
