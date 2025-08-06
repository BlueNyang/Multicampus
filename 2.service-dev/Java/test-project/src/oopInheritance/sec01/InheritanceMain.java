package oopInheritance.sec01;

public class InheritanceMain {
    public static void main(String[] ignoredArgs) {
        Child ob = new Child();
        ob.setChild();
        ob.setParent();
        ob.showChild();
        ob.showParent();

        Parent pa = new Parent();
        pa.setParent();
        pa.showParent();
        // pa.setChild(); // This line would cause a compile-time error since Parent cannot access Child's methods.
        // pa.showChild(); // This line would also cause a compile-time error since Parent cannot access Child's methods.
    }
}
