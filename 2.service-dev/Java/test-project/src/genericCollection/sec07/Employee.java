package genericCollection.sec07;

public class Employee {
    int eNo;
    String eName;
    int salary;

    public Employee(int eNo, String eName, int salary) {
        this.eNo = eNo;
        this.eName = eName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [eNo=" + eNo + ", eName=" + eName + ", salary=" + salary + "]";
    }
}
