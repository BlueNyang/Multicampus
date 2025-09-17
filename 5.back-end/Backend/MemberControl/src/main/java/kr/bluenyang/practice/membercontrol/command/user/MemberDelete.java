package kr.bluenyang.practice.membercontrol.command.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.MemberDAO;

import java.io.IOException;

public class MemberDelete implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        MemberDAO.getInstance().deleteMember(request.getParameter("id"));
        request.getSession().setAttribute("message", "deletedMember");
        return "redirect:memberView.do";
    }
}
