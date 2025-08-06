package arrayType;

public class Array04_Copy2 {
    public static void main(String[] ignoredArgs) {
        // 새로운 배열 생성 후 원본 배열의 원소값을 저장
        int[] a = {1, 2, 3, 4};
        int[] b = new int[4];

        // 깊은 복사: 원본 배열의 각 원소를 새로운 배열에 복사
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        ArrayCopyCommon.printArrays(a, b);

        System.out.println();
        b[0] = 10; //b배열 원소값 변환

        ArrayCopyCommon.printArrays(a, b);
    }
}
