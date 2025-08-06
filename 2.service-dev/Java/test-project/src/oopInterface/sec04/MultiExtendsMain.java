package oopInterface.sec04;

public class MultiExtendsMain {
    public static void main(String[] ignoredArgs) {
        ImplementationC c = new ImplementationC();

        // InterfaceA: c reference variable is cast to InterfaceA
        InterfaceA ia = c;
        ia.methodA();

        // InterfaceB: c reference variable is cast to InterfaceB
        InterfaceB ib = c;
        ib.methodB();

        // InterfaceC: c reference variable is cast to InterfaceC
        InterfaceC ic = c;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
