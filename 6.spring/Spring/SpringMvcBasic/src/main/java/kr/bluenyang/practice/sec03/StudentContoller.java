package kr.bluenyang.practice.sec03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentContoller {

    @RequestMapping("/student/studentForm")
    public String studentFormView() {
        return "sec03/student/studentForm";
    }

    @RequestMapping("/student/studentForm2")
    public String studentFormView2() {
        return "sec03/student/studentForm2";
    }

    @RequestMapping("/student/newStudent")
    public String insertStudent(HttpServletRequest request, Model model) /* throws Exception */ {
//        request.setCharacterEncoding("UTF-8");
        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String year = request.getParameter("year");

        model.addAttribute("no", no);
        model.addAttribute("name", name);
        model.addAttribute("year", year);

        return "sec03/student/studentResult";
    }

    // 2.@ReuestParam: 파라미터명과 값을 받을 변수명이 같은 경우, Annotation 생략 가능
    @RequestMapping("/student/newStudent2")
    public String insertStudent2(@RequestParam("no") String no,
                                 @RequestParam("name") String name,
                                 @RequestParam("year") String year,
                                 Model model) {
        model.addAttribute("no", no);
        model.addAttribute("name", name);
        model.addAttribute("year", year);

        return "sec03/student/studentResult";
    }
}
