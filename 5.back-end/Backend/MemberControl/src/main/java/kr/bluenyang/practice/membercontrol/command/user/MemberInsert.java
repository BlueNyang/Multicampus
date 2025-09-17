package kr.bluenyang.practice.membercontrol.command.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.MemberDAO;
import kr.bluenyang.practice.membercontrol.domain.member.MemberVO;
import kr.bluenyang.practice.membercontrol.utils.XSSPreventer;

import java.io.IOException;
import java.time.LocalDate;

public class MemberInsert implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO.getInstance().insertMember(
                new MemberVO(
                        XSSPreventer.execute(request.getParameter("id")),
                        XSSPreventer.execute(request.getParameter("pwd")),
                        XSSPreventer.execute(request.getParameter("name")),
                        XSSPreventer.execute(request.getParameter("email")),
                        LocalDate.parse(request.getParameter("joinDate"))
                )
        );

        request.getSession().setAttribute("message", "addedMember");
        return "redirect:memberView.do";
    }
}
