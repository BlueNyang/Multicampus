package oopInheritance.sec04;

public class Manager extends Employee {
    private String position;

    public Manager(String empNo, String name, String part, String position) {
        super(empNo, name, part);
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Position: " + position + "\n";
    }
}
