package oopException.sec03;

public class CatchOrderEx {
    public static void main(String[] args) {
        // when multiple catch blocks are present, they are executed sequentially from top to bottom
        // The collected exception handling classes are implemented by inheriting from the Exception class
        // The parent class Exception handles all exceptions
        try {
            String data = "a3";
            int arr[] = {1, 2, 3};
            int var1 = Integer.parseInt(data);
            int var2 = arr[5];
            System.out.println(var1 + 10);
        } catch (NumberFormatException e) {
            System.out.println("오류발생 : 변환오류");
        } catch (Exception e) {
            // Exception is the parent class of all exceptions, so it will catch any exception that is not caught by the previous catch blocks
            System.out.println("오류발생 : 상위 클래스");
        } finally {
            System.out.println("예외 발생 여부와 상관없이 실행되는 finally 블럭");
        }
    }
}
