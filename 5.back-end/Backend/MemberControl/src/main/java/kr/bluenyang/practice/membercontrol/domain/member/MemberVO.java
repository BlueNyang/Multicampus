package kr.bluenyang.practice.membercontrol.domain.member;


import java.time.LocalDate;

public record MemberVO(String id, String pwd, String name, String email, LocalDate joinDate) {
}
