package oopInheritance.sec07;

public class Automobile extends Car {
    String autoManual;

    public Automobile(String carNo, String carName, String carMaker, int catYear, String autoManual) {
        super(carNo, carName, carMaker, catYear);
        this.autoManual = autoManual;
    }

    @Override
    public String toString() {
        return String.format("%sTransmission: %s", super.toString(), autoManual);
    }
}
