package kr.bluenyang.practice.springbootex.auth.service;

import kr.bluenyang.practice.springbootex.auth.model.MemberDTO;
import kr.bluenyang.practice.springbootex.auth.model.MemberEditDTO;

public interface MemberService {
    String tryLogin(String id, String pwd);

    String idDupCheck(String id);

    void joinMember(MemberDTO dto);

    MemberDTO getMember(String id);

    String updateMember(MemberEditDTO dto);

    String unregisterMember(MemberEditDTO dto);
}
