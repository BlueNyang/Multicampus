package oopInheritance.sec09;

public class PolymorphismMain {
    public static void main(String[] ignoredArgs) {
        Child child = new Child();

        Parent parent;
        parent = child;

        parent.method1();
        // parent.method2(); // This line would cause a compile-time error because method2() is not defined in Parent
    }
}
