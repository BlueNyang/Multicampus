package com.example.sec01;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet; //상속
import jakarta.servlet.http.HttpServletRequest; //http 요청관련
import jakarta.servlet.http.HttpServletResponse; //http 응답관련

public class FirstServlet extends HttpServlet {

    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void init(ServletConfig config) throws ServletException {
        System.out.println("init method call");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet method call");
    }
}