package kr.bluenyang.practice.sec03;

import kr.bluenyang.practice.sec03.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
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

    @RequestMapping("/student/studentForm3")
    public String studentFormView3() {
        return "sec03/student/studentForm3";
    }

    @RequestMapping("/student/studentForm4")
    public String studentFormView4() {
        return "sec03/student/studentForm4";
    }

    @RequestMapping("/student/studentForm5")
    public String studentFormView5() {
        return "sec03/student/studentForm5";
    }

    @RequestMapping("/student/studentSearchForm")
    public String studentSearchView() {
        return "sec03/student/studentSearchForm";
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

    // 3.Command Object: 파라미터명과 값을 받을 변수명이 같은 경우, Annotation 생략 가능
    // !! Student 클래스의 멤버변수명과 form 태그의 name 속성명이 같아야 함 !!
    @RequestMapping("/student/newStudent3")
    public String insertStudent3(Student student) {
//        model.addAttribute("student", student);
        return "sec03/student/studentResult3";
    }

    // 3.Command Object: 파라미터명과 값을 받을 변수명이 같은 경우, Annotation 생략 가능
    // !! Student 클래스의 멤버변수명과 form 태그의 name 속성명이 같아야 함 !!
    @RequestMapping("/student/newStudent4")
    public String insertStudent4(@ModelAttribute("studentInfo") Student student) {
//        model.addAttribute("student", student);
        return "sec03/student/studentResult4";
    }

    @RequestMapping("/student/newStudent5")
    public String insertStudent5(Student student) {
        return "sec03/student/studentResult5";
    }

    @RequestMapping("/student/studentDetailView/{studentId}")
    public String studentDetailView(@PathVariable String studentId) {
        log.info("studentId:{}", studentId);
        return "sec03/student/studentResult";
    }

    @RequestMapping("/student/studentDetailView/{stdId}/{stdName}/{stdYear}")
    public String studentDetailView(@PathVariable String stdId,
                                    @PathVariable String stdName,
                                    @PathVariable String stdYear) {
        log.info("stdId:{}", stdId);
        log.info("stdName:{}", stdName);
        log.info("stdYear:{}", stdYear);
        return "sec03/student/studentResult";
    }

    // ---------------------------------------------------------------------------
    @RequestMapping("/student/studentSearch")
    public String studentSearch(@RequestParam HashMap<String, Object> params,
                                Model model) {
        log.info("type:{}", params.get("type"));
        log.info("keyword:{}", params.get("keyword"));

        Student student = new Student("2024001", "홍길동", 1, null);
        Student student2 = new Student("2022005", "홍길동", 3, null);

        List<Student> studentList = Arrays.asList(student, student2);
        model.addAttribute("studentList", studentList);

        return "sec03/student/studentSearchResult";
    }
}
