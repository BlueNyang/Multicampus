package com.example.sec04;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/first05")
public class FirstServlet05 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("processed by FirstServlet");

        String name = "안";
        String encodedName = URLEncoder.encode(name, StandardCharsets.UTF_8);
        int age = 25;

        RequestDispatcher dispatcher = request.getRequestDispatcher("second05?name=" + encodedName + "&age=" + age);
        dispatcher.forward(request, response);
    }
}