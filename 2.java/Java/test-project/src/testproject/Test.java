package testproject;

class A {}

class B {
    // Multiple classes can be defined in a single .java file,
    // But only one class containing the main method must exist.
}

public class Test {
    public static void main(String[] args) {
        // This is the entry point of the Java application
        // Configure with "static" to enable the main method without an instance
        // The program will end when the main method completes - Only represented once in a project
        // Classes containing main methods must be public
        // The main method has no returned - It is void
        // String[] args: data delivered when the JVM calls main is delivered as args
        // Determine a type of variable as String[] because parameter is also Java variable
        System.out.println("Hello World!");
    }
}
