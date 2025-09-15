package kr.bluenyang.practice.jsp.sec10;


import java.time.LocalDate;

public record MemberVO(String id, String pwd, String name, String email, LocalDate joinDate) {
}
