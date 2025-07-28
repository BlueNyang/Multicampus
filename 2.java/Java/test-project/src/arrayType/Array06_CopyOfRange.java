package arrayType;

import java.util.Arrays;

public class Array06_CopyOfRange {
    public static void main(String[] ignoredArgs) {
        // Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스+1) : 원본배열에서 시작인덱스 ~ 끝인덱스까지 원소 복사 후 새로운 배열 생성
        int[] a = {1, 2, 3, 4};
        int[] b = Arrays.copyOfRange(a, 1, 3);

        ArrayCopyCommon.printArrays(a, b);

        System.out.println();
        b[0] = 10; //b배열 원소값 변환

        ArrayCopyCommon.printArrays(a, b);
    }
}
