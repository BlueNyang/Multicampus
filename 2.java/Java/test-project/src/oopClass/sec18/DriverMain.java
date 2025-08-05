package oopClass.sec18;

public class DriverMain {
    public static void main(String[] ignoredArgs) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.driver(bus); // Output: Bus is running
        driver.driver(taxi); // Output: Taxi is running
    }
}
