package oopException.sec01;

public class NullPointerExceptionEx {
    public static void main(String[] ignoredArgs) {
        // exception occurs when trying to access a method or field of an object that is null.
        String data = null;
        int[] arr = {1, 2, 3};

        String data1 = "100";
        String data2 = "a100";


        // System.out.println(data.toString()); // Uncommenting the above line will throw a NullPointerException because data is null.
        // System.out.println(arr[5]); // Uncommenting the above line will throw an ArrayIndexOutOfBoundsException because index 5 is out of bounds for the array.

        int value1 = Integer.parseInt(data1); // This will work fine
        System.out.println("Parsed value1: " + value1);
        // int value2 = Integer.parseInt(data2); // This will throw a NumberFormatException because "a100" is not a valid integer
    }
}
