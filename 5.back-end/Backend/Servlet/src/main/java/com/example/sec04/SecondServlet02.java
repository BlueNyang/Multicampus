package com.example.sec04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/second02")
public class SecondServlet02 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("processed by SecondServlet02");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "  <meta charset='UTF-8'>"
                + "  <link rel='stylesheet' href='style.css'>"
                + "  <title>Second Servlet02</title>"
                + "</head>"
                + "<body>"
                + "  <span>Hello World! - SecondServlet02</span>"
                + "</body>"
                + "</html>");
    }
}
