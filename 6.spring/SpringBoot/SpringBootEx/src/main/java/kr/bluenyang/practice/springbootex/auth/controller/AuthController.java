package kr.bluenyang.practice.springbootex.auth.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.auth.model.MemberDTO;
import kr.bluenyang.practice.springbootex.auth.model.MemberEditDTO;
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
    private final MemberService service;

    @GetMapping("/loginForm")
    public String loginForm() {
        log.info("[loginForm] Login Form");
        return "auth/loginForm";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pwd, HttpSession session) {
        log.info("[login] Login");
        String resultName = service.tryLogin(id, pwd);
        if (resultName != null) {
            log.info("[login] Login Success");
            session.setAttribute("authId", id);
            session.setAttribute("authUser", resultName);
            return "success";
        } else {
            log.info("[login] Login Failed");
            return "failed";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.info("[logout] Logout");
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        log.info("[joinForm] Join Form");
        return "auth/joinForm";
    }

    @ResponseBody
    @PostMapping("/idDupCheck")
    public String idDupCheck(@RequestParam String userId) {
        log.info("[idDupCheck] ID Duplication Check");
        String status = service.idDupCheck(userId);

        log.info("[idDupCheck] ID Duplication Check: {}", status);
        if (status != null) {
            return status;
        }
        return "error";
    }

    @ResponseBody
    @PostMapping("/join")
    public String join(@RequestBody MemberDTO joinData) {
        log.info("[join] Join: {}", joinData.getMemId());
        try {
            service.joinMember(joinData);
            return "success";
        } catch (Exception e) {
            log.error("[join] Join Failed: {}", e.getMessage());
            return "failed";
        }
    }

    @GetMapping("/manage")
    public String manage(Model model, HttpSession session) {
        log.info("[manage] Manage Members");

        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            log.info("[manage] Unauthorized Access Attempt");
            return "redirect:/";
        }

        model.addAttribute("memberInfo", service.getMember(authId));
        return "auth/editForm";
    }

    @ResponseBody
    @PostMapping("/edit")
    public String edit(@RequestBody MemberEditDTO member) {
        log.info("[edit] Edit Member: {}", member.getMemId());
        try {
            return service.updateMember(member);
        } catch (Exception e) {
            log.error("[edit] Edit Failed: {}", e.getMessage());
            return "failed";
        }
    }

    @ResponseBody
    @PostMapping("/unregister")
    public String unregister(@RequestBody MemberEditDTO member, HttpSession session) {
        log.info("[unregister] Unregister Member");

        String authId = (String) session.getAttribute("authId");
        if (authId == null) {
            log.info("[unregister] Unauthorized Access Attempt");
            return "redirect:/";
        }

        try {
            return service.unregisterMember(member);
        } catch (Exception e) {
            log.error("[unregister] Unregister Failed: {}", e.getMessage());
            return "failed";
        }
    }
}
