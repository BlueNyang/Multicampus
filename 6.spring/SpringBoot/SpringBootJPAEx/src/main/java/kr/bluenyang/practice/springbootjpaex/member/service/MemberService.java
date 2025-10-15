package kr.bluenyang.practice.springbootjpaex.member.service;

import kr.bluenyang.practice.springbootjpaex.member.model.ChangePwdReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.LoginReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.MemberDTO;

import java.util.Optional;

public interface MemberService {
    // 로그인 체크
    Optional<String> tryLogin(LoginReqDTO dto);

    // id 중복체크
    String idCheck(String id);

    // 회원가입
    void insertMember(MemberDTO dto);

    // 회원정보 수정 Form
    MemberDTO getMemberInfo(String memId);

    // 회원정보 수정
    String updateMember(MemberDTO dto);

    String changePassword(ChangePwdReqDTO dto);

    String unregisterMember(MemberDTO dto);
}

