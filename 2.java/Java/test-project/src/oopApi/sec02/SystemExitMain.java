package oopApi.sec02;

public class SystemExitMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                // 프로그램을 강제 종료
                System.exit(0); // 0은 정상 종료를 의미
            }
        }
        System.out.println("종료되지 않았습니다.");
    }
}
