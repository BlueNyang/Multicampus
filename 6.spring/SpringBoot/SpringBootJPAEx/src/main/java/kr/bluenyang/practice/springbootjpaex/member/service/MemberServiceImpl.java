package kr.bluenyang.practice.springbootjpaex.member.service;

import java.util.Optional;

import jakarta.transaction.Transactional;
import kr.bluenyang.practice.springbootjpaex.member.model.ChangePwdReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.LoginReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.Member;
import kr.bluenyang.practice.springbootjpaex.member.model.MemberDTO;
import kr.bluenyang.practice.springbootjpaex.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository repo;
    private final PasswordEncoder pwdEncoder;

    // 암호화한 비밀번호로 로그인 체크
    // (1) id를 전달해서 존재하면 DB에 있는 비밀번호(암호화된 비밀번호)를 반환 받음
    // (2) 입력해서 전달받은 평문의 비밀번호와 암호화된 비밀번호 비교해서 일치하는지 체크
    @Override
    public Optional<String> tryLogin(LoginReqDTO dto) {
        log.info("loginCheck - try login user: {}", dto.getMemId());

        var validRes = validateMember(dto.getMemId(), dto.getMemPwd());
        if (validRes.isPresent()) {
            log.info("loginCheck - login failed: {}", validRes.get());
            return Optional.empty();
        }

        // 로그인 성공 시 회원 이름 반환
        log.info("loginCheck - login success");
        return repo.findById(dto.getMemId()).map(Member::getMemName);
    }

    @Override
    public String idCheck(String id) {
        log.info("idCheck - try id check: {}", id);
        var member = repo.findById(id);
        return member.isPresent() ? "available" : "unavailable";
    }


    @Override
    public void insertMember(MemberDTO dto) {
        var member = MemberDTO.toEntity(dto);

        String encodedPwd = pwdEncoder.encode(member.getMemPwd());
        member.changePwd(encodedPwd);
        repo.save(member);
    }

    @Override
    public MemberDTO getMemberInfo(String memId) {
        return repo.findById(memId).map(Member::toDTO).orElse(null);

    }

    @Override
    @Transactional
    public String updateMember(MemberDTO dto) {
        var memberOpt = repo.findById(dto.getMemId());

        if (memberOpt.isEmpty()) {
            log.info("updateMember - No such user: {}", dto.getMemId());
            return "no_such_user";
        }

        if (!pwdEncoder.matches(dto.getMemPwd(), memberOpt.get().getMemPwd())) {
            log.info("updateMember - Password mismatch for user: {}", dto.getMemId());
            return "incorrect_password";
        }

        var member = memberOpt.get();
        member.changeMemberInfo(MemberDTO.toEntity(dto));

        return "success";
    }

    @Override
    @Transactional
    public String changePassword(ChangePwdReqDTO dto) {
        log.info("changePassword - try change password for user: {}", dto.getMemId());

        Optional<Member> memberOpt = repo.findById(dto.getMemId());

        if (memberOpt.isEmpty()) {
            log.info("changePassword - No such user: {}", dto.getMemId());
            return "no_such_user";
        }

        if (!pwdEncoder.matches(dto.getCurrentPwd(), memberOpt.get().getMemPwd())) {
            log.info("changePassword - Password mismatch for user: {}", dto.getMemId());
            return "incorrect_password";
        }

        var member = memberOpt.get();
        String encodedNewPwd = pwdEncoder.encode(dto.getNewPwd());
        member.changePwd(encodedNewPwd);
        
        return "success";
    }

    @Override
    public String unregisterMember(MemberDTO dto) {
        return "";
    }

    private Optional<String> validateMember(String memId, String memPwd) {
        var originPwd = repo.getPwdByMemId(memId);

        if (originPwd.isEmpty()) {
            log.info("validateMember - No such user");
            return Optional.of("no_such_user");
        }

        if (!pwdEncoder.matches(memPwd, originPwd.get())) {
            log.info("validateMember - Password mismatch");
            return Optional.of("incorrect_password");
        }

        return Optional.empty();
    }
}
