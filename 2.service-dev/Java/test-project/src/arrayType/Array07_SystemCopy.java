package arrayType;

public class Array07_SystemCopy {
    public static void main(String[] ignoredArgs) {
        int[] a = {1, 2, 3, 4};
        int[] b = new int[4];

        System.arraycopy(a, 0, b, 0, a.length);

        ArrayCopyCommon.printArrays(a, b);
    }
}
