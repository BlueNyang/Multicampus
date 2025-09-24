package kr.bluenyang.practice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {
    @RequestMapping("/")
    public String index() {
        log.info("MainController - viewIndex() called");
        return "index";
    }
}
