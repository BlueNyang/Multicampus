package kr.bluenyang.practice.membercontrol.command.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.ProductDAO;
import kr.bluenyang.practice.membercontrol.domain.product.ProductDTO;
import kr.bluenyang.practice.membercontrol.utils.XSSPreventer;

import java.io.IOException;

public class ProductUpdateAction implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ProductDAO.getInstance().updateProduct(new ProductDTO(
                        XSSPreventer.execute(req.getParameter("prdNo")),
                        XSSPreventer.execute(req.getParameter("prdName")),
                        Integer.parseInt(req.getParameter("prdPrice")),
                        XSSPreventer.execute(req.getParameter("prdMaker")),
                        XSSPreventer.execute(req.getParameter("prdColor")),
                        Integer.parseInt(req.getParameter("ctgNo"))
                ).toEntity()
        );

        req.getSession().setAttribute("message", "updatedProduct");
        return "redirect:productView.do";
    }
}
