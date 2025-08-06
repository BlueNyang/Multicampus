package oopClass.sec13;

public class Share {
    int a;
    static int staticA;

    public void set(int n) {
        a += n;
        staticA += n;
    }

    public int getA() {
        return a;
    }

    public int getStaticA() {
        return staticA;
    }

    static {
        int b = 1;
    }

    public static void main(String[] ignoredArgs) {
        Share s1, s2;

        s1 = new Share();
        s1.set(5);

        System.out.println("After setting s1:");
        System.out.printf("s1.a = %d\n", s1.getA());
        System.out.printf("s1.staticA = %d\n", s1.getStaticA());
        System.out.println();

        s2 = new Share();
        s2.set(5);

        System.out.println("After setting s2:");
        System.out.printf("s2.a = %d\n", s2.getA());
        System.out.printf("s2.staticA = %d\n", s2.getStaticA());
        System.out.printf("Share.staticA = %d\n", Share.staticA);
        System.out.printf("s1.staticA = %d\n", s1.getStaticA());
    }
}

class StaticBlock {
    int a;

    void method() {
    }

    static int staticA;

    static void staticMethod() {
    }

    static {
        int b = 1;
        // method1() {} // Cannot define instance methods in static block

        staticA = 10;
        staticMethod();
    }

    static {
        int c = 10;
        double bc = 5.0;
    }

    static void staticMethod2() {
        // this.a = 100; // Cannot access instance variables in static method
        
        StaticBlock s = new StaticBlock();
        s.a = 200;
        s.method();
    }
}
