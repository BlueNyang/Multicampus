package com.example.sec08.representation;


import java.io.IOException;
import java.io.Serial;
import java.util.List;

import com.example.sec08.domain.Product;
import com.example.sec08.infra.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Controller Servlet
@WebServlet("/prdSelect")
public class ProductSelectServlet extends HttpServlet {
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

        // DAO 객체 생성 및 데이터 조회
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.memberSelect();

        // Entity -> VO 변환
        List<ProductVO> prdList = list.stream()
                .map(prd -> new ProductVO(
                        prd.getPrdNo(),
                        prd.getPrdName(),
                        prd.getPrdPrice(),
                        prd.getPrdMaker(),
                        prd.getPrdColor(),
                        prd.getCtgNo()))
                .toList();

        request.setAttribute("prdList", prdList);
        request.getRequestDispatcher("prdView").forward(request, response);
    }
}