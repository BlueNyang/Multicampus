package oopClass.sec11;

public class TestEx {

    public static void main(String[] args) {
        // 인스턴스 멤버
        Test t1 = new Test();
        t1.width = 100;
        t1.area();

        Test t2 = new Test();
        t2.width = 500;
        t2.area();

        // static 멤버 사용
        // 객체 통해서도 접근은 가능, class 통해서 접근을 권장
        // t1.width1 = 500; 이거보다
        Test.width1 = 600; // 이게 좋음
        // t2.area1(); 이거보다
        Test.area1(); // 이게 좋음

    }

}
