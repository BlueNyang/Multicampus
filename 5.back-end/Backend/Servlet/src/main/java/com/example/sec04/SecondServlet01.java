package com.example.sec04;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/second01")
public class SecondServlet01 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;


    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("SecondServlet Start");
    }

    /**
     * @see Servlet#destroy()
     */
    public void destroy() {
        System.out.println("SecondServlet End");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("processed by SecondServlet");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "  <meta charset='UTF-8'>"
                + "  <link rel='stylesheet' href='style.css'>"
                + "  <title>Second Servlet01</title>"
                + "</head>"
                + "<body>"
                + "  <span>Hello World! - SecondServlet01</span>"
                + "</body>"
                + "</html>");
    }
}