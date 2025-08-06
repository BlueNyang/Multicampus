package oopClass.sec11;

public class Test {
    // 인스턴스 멤버 vs static 멤버
    // 인스턴스 멤버 : 객체를 통해서만 접근 가능한 멤버(변수/메서드), 객체가 생성될 때 객체별로 하나씩 생성
    //				다른 객체들과 공유하지 않음, 객체가 사라지면 함께 사라짐
    int width;
    int height;

    // static : 클래스에 고정된 필드와 메서드 즉 클래스 고정 멤버
    // static 멤버 : 클래스를 통해서도 접근 가능(객체 생성 없이 클래스로 바로 접근해 사용)
    // 				특정 클래스를 통해서 생성된 모든 객체들이 공유해서 사용
    //				프로그램 시작될 때 이미 생성됨(객체보다 먼저 생성됨)

    static int width1, height1;

    public void area() { // 객체 생성 후 사용해야 함
        System.out.println(width*height);
    }

    static void area1() { // 객체 생성 없이 클래스명으로 접근 가능한 메서드
        System.out.println(width1*height1);
    }
}
