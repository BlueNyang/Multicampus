package kr.bluenyang.practice.sec01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Sec01Controller {
    @RequestMapping("/newView")
    public String newView() {
        return "sec01/newView";
    }
}
