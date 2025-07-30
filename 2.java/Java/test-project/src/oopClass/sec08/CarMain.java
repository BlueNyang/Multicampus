package oopClass.sec08;

public class CarMain {

    public static void main(String[] ignoredArgs) {
        Car car = new Car("12가 3456", "Avante", "Hyundai", 2020, 100);
        car.printCarInfo();

        Car car2 = new Car();
        car2.setCarInfo("34나 5678", "Sonata", "Hyundai", 2021, 2000);
        car2.printCarInfo();
    }
}
