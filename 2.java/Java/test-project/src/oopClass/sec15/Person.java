package oopClass.sec15;

public class Person {
    final String nationality = "korean";
    String name;
    final String ssn;
    final String temp;

    public Person(String ssn, String name, String temp) {
        this.ssn = ssn; // the final field ssn must be initialized in the constructor
        this.name = name;
        this.temp = temp;
    }

    public static void main(String[] ignoredArgs) {
        Person p1 = new Person("123456-1234567", "Kim", "abc");

        System.out.println(p1.nationality);
        System.out.println(p1.name);
        System.out.println(p1.ssn);

        // p1.nationality = "USA"; // This line will cause a compile time error
    }
}
