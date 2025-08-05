package oopApi.sec02;

public class ByteToString {
    public static void main(String[] args) {
        // byte 배열의 수치를 문자열로 변환
        byte[] bytes = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33};

        String str1 = new String(bytes);
        System.out.println("문자열 1: " + str1);

        // byte 배열의 7번 인덱스부터 6개의 바이트를 읽어 문자열로 변환
        String str2 = new String(bytes, 7, 6);
        System.out.println("문자열 2: " + str2);
    }
}
