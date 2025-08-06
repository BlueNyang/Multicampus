package oopInheritance.sec06;

public class Computer extends Calculator {

    @Override
    double areaCircle(double r) {
        System.out.println("Executing areaCircle() in Computer class");
        return Math.PI * r * r;
    }
}
