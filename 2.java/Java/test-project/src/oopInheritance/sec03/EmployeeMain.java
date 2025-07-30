package oopInheritance.sec03;

public class EmployeeMain {
    public static void main(String[] ignoredArgs) {
        EmployeeToString emp1 = new EmployeeToString("1234", "Alice", "HR");
        EmployeeToString emp2 = new EmployeeToString("5678", "Bob", "IT");

        System.out.println(emp1);
    }
}
