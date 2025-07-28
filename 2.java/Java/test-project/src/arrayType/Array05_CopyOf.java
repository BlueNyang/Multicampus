package arrayType;

import java.util.Arrays;

public class Array05_CopyOf {
    public static void main(String[] ignoredArgs) {
        int[] a = {1, 2, 3, 4};
        int[] b = Arrays.copyOf(a, a.length);

        ArrayCopyCommon.printArrays(a, b);

        System.out.println();
        b[0] = 10; //b배열 원소값 변환

        ArrayCopyCommon.printArrays(a, b);
    }
}
