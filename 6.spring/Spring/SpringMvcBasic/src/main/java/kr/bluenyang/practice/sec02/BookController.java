package kr.bluenyang.practice.sec02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @RequestMapping("/bookInfoView1")
    public String bookInfoView1(Model model) {
        model.addAttribute("title", "Spring Framework");
        model.addAttribute("price", 20000);
        return "sec02/bookInfoView";
    }

    @RequestMapping("/bookInfoView2")
    public ModelAndView bookInfoView2(ModelAndView mv) {
        mv.addObject("title", "Java Programming2");
        mv.addObject("price", 20000);
        mv.setViewName("sec02/bookInfoView");
        return mv;
    }
}
