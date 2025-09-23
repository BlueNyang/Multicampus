package kr.bluenyang.practice.sec03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sec03Controller {
    @RequestMapping("/")
    public String sec03Index() {
        return "sec03/index";
    }

    @RequestMapping("/index")
    public String sec03Index2() {
        return "sec03/index";
    }
}
