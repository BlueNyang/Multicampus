package arrayType;

public class Array11_2D1 {
    public static void main(String[] ignoredArgs) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20}
        };

        System.out.println("score[1][1] = " + score[1][1]); // 20

        for (int[] cols : score) {
            for (int val : cols) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}
