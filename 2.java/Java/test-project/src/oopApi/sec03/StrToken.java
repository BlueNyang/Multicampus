package oopApi.sec03;

import java.util.StringTokenizer;

public class StrToken {
    public static void main(String[] args) {
        //StringTokenizer 클래스를 사용하여 문자열을 토큰으로 분리
        //메서드 : countTokens() - 남아있는 토큰 수
        //        hasMoreTokens() - 다음 토큰이 있는지 여부
        //        nextToken() - 다음 토큰을 반환
        //        netToken() - 다음 토큰을 반환하고, 구분자를 제거한 후 다음 토큰으로 이동(하나씩 꺼내옴)
        String text = "홍길동,김문수,박연수";
        StringTokenizer st = new StringTokenizer(text, ",");
        System.out.println("토큰의 개수: " + st.countTokens()); // 남아있는 토큰 수 출력
        while (st.hasMoreTokens()) { // 다음 토큰이 있는지 확인
            String token = st.nextToken(); // 다음 토큰을 가져옴
            System.out.println("토큰: " + token); // 토큰 출력
        }
    }
}
