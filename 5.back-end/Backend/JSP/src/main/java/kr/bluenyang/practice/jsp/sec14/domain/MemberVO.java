package kr.bluenyang.practice.jsp.sec14.domain;


import java.time.LocalDate;

public record MemberVO(String id, String pwd, String name, String email, LocalDate joinDate) {
}
