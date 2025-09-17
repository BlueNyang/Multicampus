package kr.bluenyang.practice.membercontrol.command.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.ProductDAO;
import kr.bluenyang.practice.membercontrol.domain.product.ProductDTO;

import java.io.IOException;

public class ProductView implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        var prdList = ProductDAO.getInstance()
                .getProductList()
                .stream()
                .map(ProductDTO::fromEntity)
                .toList();

        req.setAttribute("prdList", prdList);
        return "productListView.jsp";
    }
}
