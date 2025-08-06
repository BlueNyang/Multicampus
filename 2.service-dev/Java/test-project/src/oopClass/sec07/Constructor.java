package oopClass.sec07;

public class Constructor {
    private int x;
    private int y;

    // Default constructor
    public Constructor(int x) {
        this.x = x;
    }

    public void show() {
        System.out.printf("x: %d\n", this.x);
    }

    public static void main(String[] ignoredArgs) {
        // Create an instance of Constructor using the default constructor
        Constructor obj = new Constructor(5);

        // Show the value of x
        obj.show();
    }
}
