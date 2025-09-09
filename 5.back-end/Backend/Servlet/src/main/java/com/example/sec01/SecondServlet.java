package com.example.sec01;


import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method call");
    }


    public void destroy() {
        System.out.println("destroy method call");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method call");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost method call");
    }
}