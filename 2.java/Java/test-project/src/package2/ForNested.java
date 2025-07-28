package package2;

public class ForNested {
    public static void main(String[] ignoredArgs) {
        // Nested for loop example
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%dx%d=%d\t", j, i, i * j);
            }
            System.out.println(); // Move to the next line after each inner loop
        }
    }
}
