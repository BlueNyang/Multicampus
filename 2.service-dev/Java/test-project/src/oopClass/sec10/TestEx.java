package oopClass.sec10;

public class TestEx {
    public static void main(String[] ignoredArgs) {
        Test t1 = new Test();
        t1.width = 100;
        t1.height = 200;
        Test.area(); // Static method called using class name

        Test t2 = new Test();
        t2.width = 50;
        Test.area();
    }
}
