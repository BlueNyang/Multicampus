package kr.bluenyang.practice.springbootreact;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MainController {

    @GetMapping("/hello")
    public String hello() {
        log.info("[manage] Hello World");
        return "Hello World! from Spring Boot to React";
    }
}
