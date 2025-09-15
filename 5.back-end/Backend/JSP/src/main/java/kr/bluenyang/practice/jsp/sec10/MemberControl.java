package kr.bluenyang.practice.jsp.sec10;


import java.io.IOException;
import java.io.Serial;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exs/*")
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
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getPathInfo();

        System.out.println(command);

        switch (command) {
            case "/memberSelect" -> this.doMemSelect(request, response);
            case "/memberDelete" -> this.doMemDelete(request, response);
            case "/memberUpdate" -> this.doMemUpdateGet(request, response);
            default -> this.handleWrongAccess(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getPathInfo();

        System.out.println(command);

        switch (command) {
            case "/memberSelect" -> this.doMemSelect(request, response);
            case "/memberDelete" -> this.doMemDelete(request, response);
            case "/memberInsert" -> this.doMemInsert(request, response);
            case "/memberUpdate" -> this.doMemUpdatePost(request, response);
            default -> this.handleWrongAccess(request, response);
        }
    }

    private void doMemSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");


        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.memberSelect();

        request.setAttribute("memberList", list);

        request.getRequestDispatcher("/ex/memberListView.jsp").forward(request, response);
    }

    private void doMemDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO dao = new MemberDAO();
        dao.deleteMember(request.getParameter("id"));

        response.sendRedirect("memberSelect");
    }

    private void doMemInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO dao = new MemberDAO();
        dao.insertMember(
                new MemberVO(
                        request.getParameter("id"),
                        request.getParameter("pwd"),
                        request.getParameter("name"),
                        request.getParameter("email"),
                        LocalDate.parse(request.getParameter("joinDate"))
                )
        );

        response.sendRedirect("memberSelect");
    }

    private void doMemUpdateGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO dao = new MemberDAO();
        MemberVO member = dao.getMember(request.getParameter("id"));

        request.setAttribute("member", member);

        request.getRequestDispatcher("/ex/memberUpdateForm.jsp").forward(request, response);
    }

    private void doMemUpdatePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        MemberDAO dao = new MemberDAO();
        dao.updateMember(
                new MemberVO(
                        request.getParameter("id"),
                        request.getParameter("pwd"),
                        request.getParameter("name"),
                        request.getParameter("email"),
                        null
                )
        );

        response.sendRedirect("memberSelect");
    }

    private void handleWrongAccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.getRequestDispatcher("/ex/wrongAccess").forward(request, response);
    }
}