package refType;

public class StringEquals {
    public static void main(String[] ignoredArgs) {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";

        if (strVar1 == strVar2) {
            System.out.println("strVar1과 strVar2는 참조가 같습니다.");
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다릅니다.");
        }

        if (strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 내용이 같습니다.");
        } else {
            System.out.println("strVar1과 strVar2는 내용이 다릅니다.");
        }

        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");

        if (strVar3 == strVar4) {
            System.out.println("strVar3과 strVar4는 참조가 같습니다.");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다릅니다.");
        }

        if (strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 내용이 같습니다.");
        } else {
            System.out.println("strVar3과 strVar4는 내용이 다릅니다.");
        }
    }
}
