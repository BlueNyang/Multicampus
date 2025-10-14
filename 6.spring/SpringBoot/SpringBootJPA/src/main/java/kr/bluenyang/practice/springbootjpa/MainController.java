package kr.bluenyang.practice.springbootjpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainIndex() {
        return "index";
    }
}
