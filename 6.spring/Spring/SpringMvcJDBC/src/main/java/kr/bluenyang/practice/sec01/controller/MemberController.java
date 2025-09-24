package kr.bluenyang.practice.sec01.controller;

import kr.bluenyang.practice.sec01.dao.MemberDAO;
import kr.bluenyang.practice.sec01.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    private MemberDAO dao;

    @RequestMapping("")
    public String viewIndex() {
        return "sec01/index";
    }

    @RequestMapping("/member/memberSelect")
    public String memberSelect(Model model) {
        List<MemberDTO> memList = dao.memberSelect();
        model.addAttribute("memList", memList);
        return "sec01/member/memberSelect";
    }
}
