package oopInheritance.sec02;

class A {
    public A() {
        System.out.println("default constructor of A");
    }

    public A(int x) {
        System.out.println("parameterized constructor of A with value: " + x);
    }
}

class B extends A {
    public B() {
        System.out.println("default constructor of B");
    }

    public B(int x) {
        super(x);
        System.out.println("parameterized constructor of B with value: " + x);
    }
}

class C extends B {
    public C() {
        System.out.println("default constructor of C");
    }

    public C(int x) {
        super(x);
        System.out.println("parameterized constructor of C with value: " + x);
    }
}

public class SuperConstTest {
    public static void main(String[] ignoredArgs) {
        C c = new C();
        C c1 = new C(10);
    }
}
