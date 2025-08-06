package arrayType;

import java.util.Scanner;

public class Array02_Input {
    public static void main(String[] ignoredArgs) {
        Scanner sc = new Scanner(System.in);
        String[] name = new String[5];

        System.out.println("이름 입력 : ");
        for (int i = 0; i < name.length; i++) {
            System.out.printf("name[%d] :", i);
            name[i] = sc.next();
        }

        System.out.println("명단 출력");
        for (int i = 0; i < name.length; i++) {
            System.out.printf("name[%d] = %s%n", i, name[i]);

        }
    }
}
