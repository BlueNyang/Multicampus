package kr.bluenyang.practice.membercontrol.command.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.ProductDAO;
import kr.bluenyang.practice.membercontrol.domain.product.ProductDTO;

import java.io.IOException;

public class ProductUpdateGet implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        req.setAttribute(
                "product",
                ProductDTO.fromEntity(
                        ProductDAO.getInstance().getProduct(
                                req.getParameter("prdNo")
                        )
                )
        );

        return "productUpdateForm.jsp";
    }
}
