package view;

import java.util.Scanner;

public class ResultView {
    public static void success(String message) {
        System.out.println("Success: " + message);
    }

    public static void error(String message) {
        System.out.println("Error: " + message);
    }

    public static void waitForEnter(Scanner sc) {
        System.out.print("작업이 완료되었습니다. 계속하려면 Enter 키를 누르세요...");
        sc.nextLine();
    }
}
