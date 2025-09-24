package kr.bluenyang.practice.sec02;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Slf4j
@Controller
public class Sec02Controller {

    @RequestMapping("/")
    public String index() {
        return "sec02/index";
    }

    @RequestMapping("/index")
    public String index2() {
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

    @RequestMapping("/redirect")
    public String redirect() {
        log.info("Redirecting to /showInfo");
        return "redirect:showInfo";
    }

    @RequestMapping("/redirectParam1")
    public String redirectParam1() {
        log.info("Redirecting with parameters");
        String nation = "Republic of Korea";
        try {
            nation = URLEncoder.encode(nation, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return String.format("redirect:showRedirectParam/?nation=%s", nation);
    }

    @RequestMapping("/redirectParam2")
    public String redirectParam2(Model model) {
        log.info("Redirecting with redirectParam model");
        String nation = "Republic of Korea";
        model.addAttribute("nation", nation);
        return "redirect:showRedirectParam";
    }

    @RequestMapping("/redirectParam3")
    public String redirectParam3(RedirectAttributes redirectAttributes) {
        log.info("Redirecting with redirectAttribute");
        String nation = "Republic of Korea";
        redirectAttributes.addAttribute("nation", nation); // URL query parameter
        return "redirect:showRedirectParam";
    }

    @RequestMapping("/showRedirectParam")
    public String showRedirectParam(@RequestParam("nation") String nation, Model model) {
        model.addAttribute("nation", nation);
        return "sec02/showRedirectParam";
    }
}
