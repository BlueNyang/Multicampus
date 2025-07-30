package oopClass.sec10;

public class ReservationEx {
    public static void main(String[] ignoredArgs) {
        // 기본 값 생성자 사용
        Reservation res1 = new Reservation();
        res1.showReservation();

        // 값이 있는 생성자 사용
        Reservation res2 = new Reservation("KE1001", "홍길동", "Incheon", "New York", 1600000, "A38");
        res2.showReservation();
    }
}
