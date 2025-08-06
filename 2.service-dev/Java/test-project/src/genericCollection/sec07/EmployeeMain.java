package genericCollection.sec07;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeMain {
    public static void main(String[] ignoredArgs) {
        ArrayList<Employee> list = new ArrayList<Employee>();

        Employee e1 = new Employee(100, "John", 3000);
        Employee e2 = new Employee(101, "Jane", 4000);

        list.add(e1);
        list.add(e2);
        list.add(new Employee(102, "Jack", 2000));

        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println();

        Iterator<Employee> it = list.iterator();
        while (it.hasNext()) {
            Employee employee = it.next();
            System.out.println(employee);
        }
    }
}
