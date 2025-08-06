package arrayType;

import java.util.Scanner;

public class ArrayInputEx1 {
    public static void main(String[] ignoredArgs) {
        int[] num = new int[5]; // 길이가 5인 정수형 배열 생성

        Scanner sc = new Scanner(System.in);
        System.out.println("5개의 정수를 입력하세요:");

        for (int i = 0; i < num.length; i++) {
            System.out.print("num[" + (i + 1) + "]: ");
            num[i] = sc.nextInt(); // 사용자로부터 정수 입력받기
        }

        int max = num[0];
        System.out.print("\n입력한 값: ");
        for (int i : num) {
            System.out.print(i + " "); // 입력받은 정수 출력
            if (i > max) {
                max = i; // 더 큰 값이 있으면 최대값 갱신
            }
        }

        System.out.print("\n최대값: " + max + "\n"); // 최대값 출력
        sc.close();
    }
}
