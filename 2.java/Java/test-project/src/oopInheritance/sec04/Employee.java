package oopInheritance.sec04;

public class Employee {
    private String empNo;
    private String name;
    private String part;

    public Employee(String empNo, String name, String part) {
        this.empNo = empNo;
        this.name = name;
        this.part = part;
    }

    @Override
    public String toString() {
        return "Employee Number: " + empNo + "\n" +
                "Name: " + name + "\n" +
                "Part: " + part + "\n";
    }
}
