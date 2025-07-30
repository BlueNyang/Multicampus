package oopInheritance.sec07;

public class Car {
    String carNo;
    String carName;
    String carMaker;
    int catYear;

    public Car(String carNo, String carName, String carMaker, int catYear) {
        this.carNo = carNo;
        this.carName = carName;
        this.carMaker = carMaker;
        this.catYear = catYear;
    }

    @Override
    public String toString() {
        return String.format("Car No: %s%nName: %s%nMaker: %s%nYear: %d%n",
                carNo, carName, carMaker, catYear);
    }
}
