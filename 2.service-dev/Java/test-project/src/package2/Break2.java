package package2;

public class Break2 {
    public static void main(String[] ignoredArgs) {
        for (char c = 'a'; c <= 'z'; c++) {
            for (char d = 'a'; d <= 'z'; d++) {
                if (d == 'g') {
                    break; // Stop the inner loop when 'd' is 'g'
                }
                System.out.println(c + " " + d); // Print pairs of characters
            }
        }
    }
}
