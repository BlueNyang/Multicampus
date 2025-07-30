package oopInheritance.sec01;

public class Child extends Parent {
    private int c;

    public void setChild() {
        c = 20;
    }

    public void showChild() {
        super.showParent();
        System.out.println("Child: " + c);
    }
}
