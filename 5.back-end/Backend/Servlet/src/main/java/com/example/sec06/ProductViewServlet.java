package com.example.sec06;


import java.io.IOException;
import java.io.Serial;
import java.util.List;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/prodView")
public class ProductViewServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

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
        response.setContentType("text/html;charset=UTF-8");
        var productList = (List<ProductVO>) request.getAttribute("productList");

        var out = response.getWriter();
        out.println("<!DOCTYPE html>"
                + "<html><head><meta charset='UTF-8' />"
                + "<title>Product List</title>"
                + " <link rel=\"stylesheet\" href=\"style.css\" />"
                + " <style>"
                + " table, th, td { border: 1px solid black; }"
                + "th, td { padding: 4px 8px; }"
                + "</style></head>"
                + "<body>"
                + "<span> Product List </span>"
                + "<table>"
                + "<tr><th>Product ID</th><th>Name</th><th>Price</th><th>Stock</th><th>Delete</th></tr>"
        );
        for (ProductVO vo : productList) {
            out.println("<tr><td>" + vo.getProductId()
                    + "</td><td>" + vo.getProductName()
                    + "</td><td>" + vo.getPrice()
                    + "</td><td>" + vo.getStock()
                    + "</td><td>"
                    + "<a href='/Servlet/deleteProd?productId=" + vo.getProductId() + "'>delete</a>"
                    + "</td></tr>");
        }
        out.println("</table></body></html>");
    }
}