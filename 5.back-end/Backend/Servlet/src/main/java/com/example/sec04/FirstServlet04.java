package com.example.sec04;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/first04")
public class FirstServlet04 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("processed by FirstServlet");

        // Processing
        String name = "ahn";
        String korName = "안";
        String encodedKorName = URLEncoder.encode(korName, StandardCharsets.UTF_8);
        int age = 25;

        response.sendRedirect("second04?name=" + name + "&korName=" + encodedKorName + "&age=" + age);
    }
}