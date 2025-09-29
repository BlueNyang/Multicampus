package kr.bluenyang.practice.springbootmybatis.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // @ResponseBody
    // @RequestMapping("/")
    // public String home() {
    //     System.out.println("Hello Spring Boot!");
    //     return "Hello Spring Boot!";
    // }
    @GetMapping("")
    public String home(Model model) {
        System.out.println("Hello Spring Boot!");
        model.addAttribute("message", "Hello Spring Boot!");
        return "hello";
    }
}
