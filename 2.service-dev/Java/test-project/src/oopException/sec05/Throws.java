package oopException.sec05;

public class Throws {
    public static void main(String[] args) {
        // throw to the method that called it (throws clause)
        try {
            findclass();
        } catch (ClassNotFoundException e) {
            System.out.println("클래스가 존재하지 않습니다: " + e.getMessage());
        }
    }

    public static void findclass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.lang.String2");
    }
}
