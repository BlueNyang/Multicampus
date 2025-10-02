package kr.bluenyang.practice.springbootex.auth.service;

import kr.bluenyang.practice.springbootex.auth.dao.MemberDAO;
import kr.bluenyang.practice.springbootex.auth.model.Member;
import kr.bluenyang.practice.springbootex.auth.model.MemberDTO;
import kr.bluenyang.practice.springbootex.auth.model.MemberEditDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO dao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String tryLogin(String id, String pwd) {
        Member member = dao.findMemberById(id);

        if (member == null) {
            log.info("[tryLogin] Login Failed - No such user");
            return null;
        }

        // Check password using PasswordEncoder
        if (!passwordEncoder.matches(pwd, member.getMemPwd())) {
            // if (pwd.equals(member.getMemPwd())) {
            log.info("[tryLogin] Login Success");
            return member.getMemName();
        }

        log.info("[tryLogin] Login Failed - Incorrect password");
        return null;
    }

    @Override
    public String idDupCheck(String id) {
        Member member = dao.findMemberById(id);

        if (member != null) {
            log.info("[idDupCheck] ID is already taken");
            return "duplicated";
        } else {
            log.info("[idDupCheck] ID is available");
            return "available";
        }
    }

    @Override
    public void joinMember(MemberDTO dto) {
        log.info("[joinMember] add New Member");

        // dto password encryption
        var pwd = dto.getMemPwd();
        dto.setMemPwd(passwordEncoder.encode(pwd));

        dao.insertMember(dto.toEntity());
    }

    @Override
    public MemberDTO getMember(String id) {
        log.info("[getMember] Get Member: {}", id);
        Member member = dao.findMemberById(id);
        if (member != null) {
            return new MemberDTO(member);
        }

        return null;
    }

    @Override
    public String updateMember(MemberEditDTO dto) {
        log.info("[updateMember] Update Member: {}", dto.getMemId());

        Member member = dao.findMemberById(dto.getMemId());
        if (member == null) {
            log.info("[updateMember] No such member");
            return "no_such_member";
        }

        if (!passwordEncoder.matches(dto.getMemPwd(), member.getMemPwd())) {
            log.info("[updateMember] Incorrect password");
            return "incorrect_password";
        }

        // dto password encryption
        var newPwd = dto.getNewMemPwd();
        dto.setNewMemPwd(passwordEncoder.encode(newPwd));

        dao.updateMember(dto.toEntity());
        return "success";
    }

    @Override
    public String unregisterMember(MemberEditDTO dto) {
        log.info("[unregisterMember] Remove Member: {}", dto.getMemId());
        Member member = dao.findMemberById(dto.getMemId());

        if (member == null) {
            log.info("[unregisterMember] No such member");
            return "no_such_member";
        } else if (!passwordEncoder.matches(dto.getMemPwd(), member.getMemPwd())) {
            log.info("[unregisterMember] Incorrect password");
            return "incorrect_password";
        }

        dao.deleteMember(dto.getMemId());
        return "success";
    }
}
