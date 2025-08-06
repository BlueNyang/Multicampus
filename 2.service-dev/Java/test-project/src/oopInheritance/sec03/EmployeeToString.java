package oopInheritance.sec03;

public class EmployeeToString {
    private String empNo;
    private String name;
    private String part;

    public EmployeeToString(String empNo, String name, String part) {
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
