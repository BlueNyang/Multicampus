package com.example.sec02;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.util.Arrays;

@WebServlet("/insertMember")
public class JoinServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("JoinServlet init method called");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String phone = request.getParameter("phonF") + "-" + request.getParameter("phonS") + "-" + request.getParameter("phonT");

        System.out.println("name: " + request.getParameter("name"));
        System.out.println("id: " + request.getParameter("id"));
        System.out.println("pw: " + request.getParameter("pw"));
        System.out.println("phone: " + phone);
        System.out.println("grade: " + request.getParameter("grade"));
        System.out.println("interest: " + Arrays.toString(request.getParameterValues("interests")));
        System.out.println("department: " + request.getParameter("department"));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
