package kr.bluenyang.practice.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
    @RequestMapping("/vanillaLoginForm")
    public String vanillaLoginForm() {
        return "ajax/vanillaLoginForm";
    }

    @RequestMapping("/loginForm")
    public String loginForm() {
        return "ajax/loginForm";
    }

    @RequestMapping("/loginForm2")
    public String loginForm2() {
        return "ajax/loginForm2";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String pw) {
        String result;
        if (id.equals("abcd") && pw.equals("1234")) {
            result = "success";
        } else {
            result = "fail";
        }

        return result;
    }
}
