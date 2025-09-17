package kr.bluenyang.practice.jsp.sec14;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.jsp.sec14.dao.MemberDAO;
import kr.bluenyang.practice.jsp.sec14.domain.MemberVO;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

@WebServlet("*.do")
public class MemberControl extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberControl() {
        super();
    }

    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        MemberDAO dao = MemberDAO.getInstance();
        List<MemberVO> list = dao.memberSelect();

        request.setAttribute("memberList", list);
        request.getRequestDispatcher("/sec14/memberListView.jsp").forward(request, response);
    }
}