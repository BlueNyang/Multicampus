package kr.bluenyang.practice.springbootmybatis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/hello-jsp")
    public String helloJsp(Model model) {
        model.addAttribute("message", "Hello, Spring Boot with JSP!");
        return "index"; // ViewResolver가 "/WEB-INF/views/hello.jsp"로 조합
    }
}
