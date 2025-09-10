package com.example.sec05;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memView")
public class MemberViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
    }

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
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<MemberVO> memList = (ArrayList<MemberVO>) request.getAttribute("memberList");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html><head><meta charset='UTF-8' />"
                + "<title>Insert title here</title>"
                + " <link rel=\"stylesheet\" href=\"style.css\" />"
                + " <style>"
                + " table, th, td { border: 1px solid black; }"
                + "th, td { padding: 4px 8px; }"
                + "</style></head>"
                + "<body>"
                + "<span> Member List </span>"
                + "<table>"
                + "<tr><th>Id</th><th>Password</th><th>Name</th><th>Email</th><th>삭제</th></tr>"
        );
        for (MemberVO vo : memList) {
            out.println("<tr><td>" + vo.getId()
                    + "</td><td>" + vo.getPwd()
                    + "</td><td>" + vo.getName()
                    + "</td><td>" + vo.getEmail()
                    + "</td><td><a href='/Servlet/memDelete?id=" + vo.getId() + "'>삭제</a>"
                    + "</td></tr>"
            );
        }
        out.println("</table></body></html>");
    }
}