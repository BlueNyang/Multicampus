package com.example.sec03;


import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Start Thread");
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Request Method : GET");
        this.doHandle(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Request Method : POST");
        this.doHandle(request, response);
    }

    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>Insert title here</title>"
                + "<link rel='stylesheet' href='style.css' />"
                + "</head>"
                + "<body>"
        );
        out.println("<span>user_id : " + user_id + "</span><br>");
        out.println("<span>user_pw : " + user_pw + "</span><br>");
        out.println("</body></html>");
    }
}