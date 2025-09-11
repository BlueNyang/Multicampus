package com.example.sec08.representation;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// View Servlet
@WebServlet("/prdView")
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        List<ProductVO> prdList = (List<ProductVO>) request.getAttribute("prdList");

        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Insert title here</title>
                    <link rel="stylesheet" href="style.css" />
                </head>
                <body>
                    <h2>상품 목록</h2>
                    <table>
                        <tr>
                            <th>상품번호</th>
                            <th>상품명</th>
                            <th>상품가격</th>
                            <th>제조사</th>
                            <th>상품색상</th>
                            <th>카테고리번호</th>
                            <th>삭제</th>
                        </tr>
                """
        );

        for (ProductVO prd : prdList) {
            out.println("<tr>");
            out.println("<td>" + prd.getPrdNo() + "</td>");
            out.println("<td>" + prd.getPrdName() + "</td>");
            out.println("<td>" + prd.getPrdPrice() + "</td>");
            out.println("<td>" + prd.getPrdMaker() + "</td>");
            out.println("<td>" + prd.getPrdColor() + "</td>");
            out.println("<td>" + prd.getCtgNo() + "</td>");
            out.println("<td><a href='/Servlet/prdDelete?prdNo=" + prd.getPrdNo() + "'>삭제</a></td>");
            out.println("</tr>");
        }
        out.println("""
                    </table>
                </body>
                </html>
                """
        );
    }
}