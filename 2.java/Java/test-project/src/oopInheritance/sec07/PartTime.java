package oopInheritance.sec07;

public class PartTime extends Worker {
    private final int hours;
    private final int payPerHour;

    public PartTime(String regiNo, String name, int hours, int payPerHour) {
        super(name, regiNo);
        this.hours = hours;
        this.payPerHour = payPerHour;
    }

    final public int calculatePay() {
        return hours * payPerHour;
    }

    @Override
    public String toString() {
        return "pay per hour: " + payPerHour
                + "\nhours: " + hours
                + "\ntotal pay: " + calculatePay()
                + "\n" + super.toString();
    }
}
