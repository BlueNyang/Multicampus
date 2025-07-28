package package2;

public class Continue1 {
    public static void main(String[] ignoredArgs) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue; // Skip odd numbers
            }
            System.out.println(i); // Print odd numbers
        }
    }
}
