package kr.bluenyang.practice.sec02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Sec02Controller {

    @RequestMapping("/")
    public String index() {
        return "sec02/index";
    }

    @RequestMapping("/showInfo")
    public String showInfo(Model model) {
        model.addAttribute("name", "BlueNyang");
        model.addAttribute("age", 23);
        return "sec02/showInfo";
    }

    @RequestMapping("/showInfo2")
    public ModelAndView showInfo2(ModelAndView mv) {
        mv.addObject("name", "John Doe");
        mv.addObject("address", "123 Main St");
        mv.setViewName("sec02/showInfo2");
        return mv;
    }

    @RequestMapping("/showInfo3")
    public ModelAndView showInfo3(Model model, ModelAndView mv) {
        model.addAttribute("name", "Alice");
        mv.addObject("name", "Bob");
        mv.addObject("age", 30);
        mv.addObject("address", "123 Main St");
        mv.setViewName("sec02/showInfo3");
        model.addAttribute("address", "123 Main St");
        return mv;
    }
}
