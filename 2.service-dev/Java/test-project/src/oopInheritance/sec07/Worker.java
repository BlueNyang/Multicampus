package oopInheritance.sec07;

public class Worker {
    final private String name;
    final private String regiNo;

    public Worker(String name, String regiNo) {
        this.name = name;
        this.regiNo = regiNo;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nRegistration No: " + regiNo;
    }
}
