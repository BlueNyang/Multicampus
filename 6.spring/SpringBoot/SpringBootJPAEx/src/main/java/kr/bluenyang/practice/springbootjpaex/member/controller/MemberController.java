package kr.bluenyang.practice.springbootjpaex.member.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootjpaex.member.model.ChangePwdReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.LoginReqDTO;
import kr.bluenyang.practice.springbootjpaex.member.model.MemberDTO;
import kr.bluenyang.practice.springbootjpaex.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {
    private final MemberService service;

    // 로그인 폼 열기
    @RequestMapping("/loginForm")
    public String loginForm() {
        log.info("loginForm - Request login form");
        return "auth/loginForm";
    }

    // 비밀번호 암호화 한 경우 로그인 처리
    @ResponseBody
    @RequestMapping("/login")
    public String loginCheck(LoginReqDTO param,
                             HttpSession session) {
        log.info("login - try login user: {}", param.getMemId());
        // 로그인 시도
        var resultName = service.tryLogin(param);

        // 로그인 성공 시 세션에 정보 저장
        if (resultName.isPresent()) {
            log.info("login - Login Success");

            session.setAttribute("authId", param.getMemId());
            session.setAttribute("authUser", resultName.get());
            return "success";
        } else {
            // 로그인 실패
            log.info("login - Login Failed");
            return "failed";
        }
    }


    // 로그아웃
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        log.info("logout - try logout user: {}", session.getAttribute("authId"));
        // 세션 무효화
        session.invalidate();

        // 홈으로 리다이렉트
        return "redirect:/";
    }

    // 회원가입 폼 열기
    // 로그인 폼 열기
    @RequestMapping("/joinForm")
    public String joinForm() {
        log.info("joinForm - request join form");
        return "auth/joinForm";
    }

    // ID 중복 체크
    @ResponseBody
    @RequestMapping("/idDupCheck")
    public String idDupCheck(@RequestParam("id") String id) {
        log.info("idDupCheck - try id check: {}", id);

        // DB에서 id 존재 여부 확인
        String status = service.idCheck(id);

        // 상태 로그 및 반환
        log.info("[idDupCheck] ID Duplication Check: {}", status);
        if (status != null) {
            return status;
        }

        return "error";
    }

    // 회원가입 처리
    @ResponseBody
    @RequestMapping("/join")
    public String join(MemberDTO dto,
                       @RequestParam("memHp1") String memHp1,
                       @RequestParam("memHp2") String memHp2,
                       @RequestParam("memHp3") String memHp3) { // 전화번호 3개 별도로 받아서(파라미터로), 다 더해서,vo에 저장(setter 사용해서)
        log.info("join - request register user: {}", dto.getMemId());

        String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
        dto.setMemHp(memHp);

        try {
            service.insertMember(dto);
            return "success";
        } catch (Exception e) {
            log.error("join - register failed: {}", e.getMessage());
            return "failed";
        }
    }

    @RequestMapping("/myPage")
    public String myPage() {
        log.info("myPage - request myPage");
        return "auth/myPage";
    }

    @RequestMapping("/myInfoUpdateForm")
    public String myInfoUpdateForm(HttpSession session, Model model) {
        log.info("myInfoUpdateForm - request getMemberInfo");


        // 세션에서 인증된 사용자 ID 가져오기
        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            // 인증되지 않은 접근 시 홈으로 리다이렉트
            log.info("[manage] Unauthorized Access Attempt");
            return "redirect:/";
        }

        model.addAttribute("memberInfo", service.getMemberInfo(authId));
        return "auth/updateForm";
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody MemberDTO dto) {
        log.info("edit - request edit user: {}", dto.getMemId());
        try {
            // 회원 정보 수정 시도
            return service.updateMember(dto);
        } catch (Exception e) {
            log.error("[edit] Edit Failed: {}", e.getMessage());
            // 예외 발생 시 실패 반환
            return "failed";
        }
    }

    @GetMapping("/changePwdForm")
    public String changePwdForm() {
        log.info("changePwdForm - request change password form");
        return "auth/changePwdForm";
    }

    @ResponseBody
    @PostMapping("/changePwd")
    public String changePwd(ChangePwdReqDTO param, HttpSession httpSession) {
        log.info("changePwd - request change password for user: {}", param.getMemId());

        try {
            var res = service.changePassword(param);
            if (res.equals("success")) {
                httpSession.invalidate();
            }
            return res;
        } catch (Exception e) {
            log.error("[changePwd] Change Password Failed: {}", e.getMessage());
            return "failed";
        }
    }

    @ResponseBody
    @PostMapping("/unregister")
    public String unregister(@RequestBody MemberDTO dto, HttpSession session) {
        log.info("unregister - request unregister user: {}", dto.getMemId());

        // 세션에서 인증된 사용자 ID 가져오기
        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            log.info("[unregister] Unauthorized Access Attempt");
            // 인증되지 않은 접근 시 홈으로 리다이렉트
            return "redirect:/";
        }

        try {
            // 회원 탈퇴 시도
            String result = service.unregisterMember(dto);
            if (result.equals("success")) {
                session.invalidate(); // 세션 무효화
            }
            return result;
        } catch (Exception e) {
            // 예외 발생 시 로그 및 실패 반환
            log.error("[unregister] Unregister Failed: {}", e.getMessage());
            return "failed";
        }
    }
}
