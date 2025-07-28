package arrayType;

public class Array08_Delete {
    public static void main(String[] ignoredArgs) {
        int[] num = {1, 2, 3, 4, 5};

        int[] newNum = new int[10];

        for (int i = 0; i < num.length; i++) {
            newNum[i] = num[i];
        }

        num = newNum;

        for (int n : newNum) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int n : num) {
            System.out.print(n + " ");
        }

        num = null;

        System.out.println();
        for (int n : newNum) {
            System.out.print(n + " ");
        }
    }
}
