package kr.bluenyang.practice.springbootex.auth.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.auth.model.MemberEditDTO;
import kr.bluenyang.practice.springbootex.auth.model.MemberVO;
import kr.bluenyang.practice.springbootex.auth.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    // Service
    private final MemberService service;

    // Login Form
    @GetMapping("/loginForm")
    public String loginForm() {
        log.info("[loginForm] Login Form");
        return "auth/loginForm";
    }

    // Login 처리
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pwd, HttpSession session) {
        log.info("[login] Login");

        // 로그인 시도
        String resultName = service.tryLogin(id, pwd);

        // 로그인 성공 시 세션에 정보 저장
        if (resultName != null) {
            log.info("[login] Login Success");
            session.setAttribute("authId", id);
            session.setAttribute("authUser", resultName);
            return "success";
        } else {
            // 로그인 실패
            log.info("[login] Login Failed");
            return "failed";
        }
    }

    // Logout 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("[logout] Logout");
        // 세션 무효화
        session.invalidate();

        // 홈으로 리다이렉트
        return "redirect:/";
    }

    // Join Form
    @GetMapping("/joinForm")
    public String joinForm() {
        log.info("[joinForm] Join Form");
        return "auth/joinForm";
    }

    // ID 중복 체크
    @ResponseBody
    @PostMapping("/idDupCheck")
    public String idDupCheck(@RequestParam String userId) {
        log.info("[idDupCheck] ID Duplication Check");
        String status = service.idDupCheck(userId);

        // 상태 로그 및 반환
        log.info("[idDupCheck] ID Duplication Check: {}", status);
        if (status != null) {
            return status;
        }
        return "error";
    }

    // Join 처리
    @ResponseBody
    @PostMapping("/join")
    public String join(@RequestBody MemberVO joinData) {
        log.info("[join] Join: {}", joinData.getMemId());
        try {
            // 회원 가입 시도
            service.joinMember(joinData);
            return "success";
        } catch (Exception e) {
            // 예외 발생 시 로그 및 실패 반환
            log.error("[join] Join Failed: {}", e.getMessage());
            return "failed";
        }
    }

    @GetMapping("/manage")
    public String manage(Model model, HttpSession session) {
        log.info("[manage] Manage Members");

        // 세션에서 인증된 사용자 ID 가져오기
        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            // 인증되지 않은 접근 시 홈으로 리다이렉트
            log.info("[manage] Unauthorized Access Attempt");
            return "redirect:/";
        }

        // 해당 사용자의 정보 가져오기
        model.addAttribute("memberInfo", service.getMember(authId));
        return "auth/editForm";
    }

    // Edit 처리
    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody MemberEditDTO member) {
        log.info("[edit] Edit Member: {}", member.getMemId());
        try {
            // 회원 정보 수정 시도
            return service.updateMember(member);
        } catch (Exception e) {
            log.error("[edit] Edit Failed: {}", e.getMessage());
            // 예외 발생 시 실패 반환
            return "failed";
        }
    }

    // Unregister 처리
    @ResponseBody
    @PostMapping("/unregister")
    public String unregister(@RequestBody MemberEditDTO member, HttpSession session) {
        log.info("[unregister] Unregister Member");

        // 세션에서 인증된 사용자 ID 가져오기
        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            log.info("[unregister] Unauthorized Access Attempt");
            // 인증되지 않은 접근 시 홈으로 리다이렉트
            return "redirect:/";
        }

        try {
            // 회원 탈퇴 시도
            return service.unregisterMember(member);
        } catch (Exception e) {
            // 예외 발생 시 로그 및 실패 반환
            log.error("[unregister] Unregister Failed: {}", e.getMessage());
            return "failed";
        }
    }
}
