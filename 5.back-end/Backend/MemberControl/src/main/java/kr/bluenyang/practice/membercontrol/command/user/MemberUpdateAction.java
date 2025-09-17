package kr.bluenyang.practice.membercontrol.command.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.MemberDAO;
import kr.bluenyang.practice.membercontrol.domain.member.MemberVO;
import kr.bluenyang.practice.membercontrol.utils.XSSPreventer;

import java.io.IOException;

public class MemberUpdateAction implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO.getInstance().updateMember(
                new MemberVO(
                        XSSPreventer.execute(request.getParameter("id")),
                        XSSPreventer.execute(request.getParameter("pwd")),
                        XSSPreventer.execute(request.getParameter("name")),
                        XSSPreventer.execute(request.getParameter("email")),
                        null
                )
        );

        request.getSession().setAttribute("message", "updatedMember");
        return "redirect:memberView.do";
    }
}
