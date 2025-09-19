package kr.bluenyang.practice.sec03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sec03Controller {
    @RequestMapping("/")
    public String main() {
        return "sec03/index";
    }
}
