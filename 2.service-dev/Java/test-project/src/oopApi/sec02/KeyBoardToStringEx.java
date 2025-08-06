package oopApi.sec02;

import java.io.IOException;

public class KeyBoardToStringEx {
    public static void main(String[] args) throws IOException {
        // 사용자로 부터 키보드 입력을 받아 문자열로 변환하는 예제
        byte[] bytes = new byte[100]; // 입력을 받을 바이트 배열 생성
        System.out.print("입력: ");
        int readByteNo = System.in.read(bytes); // 읽은 바이트 수를 저장할 변수 //IoException 이 throws 처리되어있음 -> main에서 예외처리를 호출측으로 던짐

        //keyboard 입력은 Enter 키를 누르면 종료되므로, 마지막 두 바이트는 Enter 키에 해당하는'\n'이므로 제외(1바이트 추가됨)
        System.out.println(readByteNo - 1 + "바이트");
        String str = new String(bytes, 0, readByteNo); // 입력받은 바이트 배열을 문자열로 변환(enter 키 바이트 제외)
        System.out.println("입력한 문자열: " + str);
    }
}
