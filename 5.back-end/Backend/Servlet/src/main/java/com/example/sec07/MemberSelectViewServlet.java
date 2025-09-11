package com.example.sec07;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memSelectView")
public class MemberSelectViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        MemberDAO dao = new MemberDAO();
        List<MemberVO> list = dao.memberSelect();

        out.println("<!DOCTYPE html>");
        out.println("""
                <html>
                <head>
                  <meta charset='UTF-8'>
                  <title>Insert title here</title>
                  <link rel='stylesheet' href='style.css'>
                </head>
                <body>
                  <h2>회원목록</h2>
                  <table>
                    <tr>
                      <th>아이디</th>
                      <th>비밀번호</th>
                      <th>이름</th>
                      <th>이메일</th>
                      <th>가입일</th>
                      <th>삭제</th>
                    </tr>
                """
        );
        for (MemberVO vo : list) {
            out.println("<tr>");
            out.println("<td>" + vo.getId() + "</td>");
            out.println("<td>" + vo.getPwd() + "</td>");
            out.println("<td>" + vo.getName() + "</td>");
            out.println("<td>" + vo.getEmail() + "</td>");
            out.println("<td>" + vo.getJoinDate() + "</td>");
            out.println("<td><a href='/Servlet/memDelete?id=" + vo.getId() + "'>삭제</a></td>");
            out.println("</tr>");
        }
        out.println("""
                  </table>
                </body>
                </html>
                """
        );
        out.close();
    }
}