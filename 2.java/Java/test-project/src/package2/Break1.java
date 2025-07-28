package package2;

public class Break1 {
    public static void main(String[] ignoredArgs) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                break; // Stop the loop on the first even number
            }
            System.out.println(i); // Print odd numbers
        }
        // This will only print odd numbers until the first even number is encountered
        // Output: 1
    }
}
