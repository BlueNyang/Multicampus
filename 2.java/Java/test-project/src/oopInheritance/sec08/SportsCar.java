package oopInheritance.sec08;

public class SportsCar extends MyCar {
    @Override
    public void speedUp() {
        speed += 10;
    }

//    @Override
//    public void stop() { // Cannot override the "final" method from MyCar
//        System.out.println("Stop the sports car");
//        speed = 0;
//    }
}
