package arrayType;

public class Array01_Clone {
    public static void main(String[] ignoredArgs) {
        // Object.clone()메소드 사용한 깊은 복사
        int[] a = {1, 2, 3, 4};
        int[] b = a.clone();

        ArrayCopyCommon.printArrays(a, b);

        System.out.println();
        b[0] = 10; //b배열 원소값 변환

        ArrayCopyCommon.printArrays(a, b);
    }
}
