package com.example.sec02;


import java.io.IOException;
import java.io.Serial;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookInsert")
public class BookServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init(ServletConfig config) throws ServletException {
        System.out.println("BookServlet init method called");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Date = request.getParameter("bookYear") + "-" + request.getParameter("bookMonth") + "-" + request.getParameter("bookDay");
        
        System.out.println("bookNo: " + request.getParameter("bookNo"));
        System.out.println("bookTitle: " + request.getParameter("bookTitle"));
        System.out.println("bookAuthor: " + request.getParameter("bookAuthor"));
        System.out.println("bookPrice: " + request.getParameter("bookPrice"));
        System.out.println("bookDate: " + Date);
        System.out.println("bookStock: " + request.getParameter("bookStock"));
        System.out.println("pubNo: " + request.getParameter("pubNo"));
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}