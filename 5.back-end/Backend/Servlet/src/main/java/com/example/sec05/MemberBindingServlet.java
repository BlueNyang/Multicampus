package com.example.sec05;


import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/memBinding")
public class MemberBindingServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("MemberBindingServlet init method call");
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
        MemberVO vo1 = new MemberVO("kim", "1234", "김유신", "kim@google.com");
        MemberVO vo2 = new MemberVO("lee", "1111", "이순신", "lee@google.com");
        MemberVO vo3 = new MemberVO("hong", "2222", "홍길동", "hong@google.com");

        ArrayList<MemberVO> memList = new ArrayList<MemberVO>();
        memList.add(vo1);
        memList.add(vo2);
        memList.add(vo3);

        request.setAttribute("memberList", memList);

        request.getRequestDispatcher("memView").forward(request, response);
    }
}