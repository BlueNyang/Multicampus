package kr.bluenyang.practice.springbootjpaex.member.service;

import java.util.HashMap;

import kr.bluenyang.practice.springbootjpaex.member.model.Member;
import kr.bluenyang.practice.springbootjpaex.member.model.MemberDTO;
import kr.bluenyang.practice.springbootjpaex.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repo;
    private final PasswordEncoder pwdEncoder;

    // 암호화한 비밀번호로 로그인 체크
    // (1) id를 전달해서 존재하면 DB에 있는 비밀번호(암호화된 비밀번호)를 반환 받음
    // (2) 입력해서 전달받은 평문의 비밀번호와 암호화된 비밀번호 비교해서 일치하는지 체크
    @Override
    public String loginCheck(HashMap<String, Object> map) {
        // (1) id를 전달해서 존재하면 DB에 있는 비밀번호(암호화된 비밀번호)를 반환 받음
        String encodedPwd = repo.getPwdByMemId((String) map.get("id"));

        // (2) 입력해서 전달받은 평문의 비밀번호와 암호화된 비밀번호 비교해서 일치하는지 체크
        // matches(평문, 암호문) : 일치 여부 반환
        String result = "fail";
        if (encodedPwd != null && pwdEncoder.matches((String) map.get("pwd"), encodedPwd)) {
            result = "success";
        }
        return result;
    }

    @Override
    public String idCheck(String id) {
        var member = repo.findById(id);
        return member.isPresent() ? "available" : "unavailable";
    }


    @Override
    public void insertMember(MemberDTO dto) {
        var member = MemberDTO.toEntity(dto);

        String encodedPwd = pwdEncoder.encode(member.getMemPwd());
        member.changePwdForEncode(encodedPwd);
        repo.save(member);
    }

    @Override
    public MemberDTO myInfoUpdateForm(String memId) {
        return repo.findById(memId).map(Member::toDTO).orElse(null);

    }

    @Override
    public void myInfoUpdate(MemberDTO myInfo) {
        var member = MemberDTO.toEntity(myInfo);

        String encodedPwd = pwdEncoder.encode(member.getMemPwd());
        member.changePwdForEncode(encodedPwd);
        repo.save(member);
    }


}
