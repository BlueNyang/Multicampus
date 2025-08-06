package oopClass.sec14;

public class SingletonMain {
    public static void main(String[] ignoredArgs) {
        // Singleton singleton = new Singleton(); // This line will cause a compile-time error
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if (singleton == singleton2) {
            System.out.println("Both references point to the same Singleton instance.");
        } else {
            System.out.println("Different instances were created.");
        }
    }
}
