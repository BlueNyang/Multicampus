package arrayType;

public class ArrayCopyCommon {
    static void printArrays(int[] a, int[] b) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : b) {
            System.out.print(i + " ");
        }
    }
}
