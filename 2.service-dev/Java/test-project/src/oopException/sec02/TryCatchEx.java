package oopException.sec02;

public class TryCatchEx {
    public static void main(String[] ignoredArgs) {
        int[] arr = {1, 2, 3};
        try {
            Class class1 = Class.forName("java.lang.String");
            System.out.println("Class found: " + class1.getName());

            System.out.println(arr[5]);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}
