package kr.bluenyang.practice.membercontrol.command.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.ProductDAO;
import kr.bluenyang.practice.membercontrol.domain.product.ProductDTO;
import kr.bluenyang.practice.membercontrol.utils.XSSPreventer;

import java.io.IOException;

public class ProductInsert implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        ProductDAO.getInstance().insertProduct(
                new ProductDTO(
                        XSSPreventer.execute(request.getParameter("prdNo")),
                        XSSPreventer.execute(request.getParameter("prdName")),
                        Integer.parseInt(request.getParameter("prdPrice")),
                        XSSPreventer.execute(request.getParameter("prdMaker")),
                        XSSPreventer.execute(request.getParameter("prdColor")),
                        Integer.parseInt(request.getParameter("ctgNo"))
                ).toEntity()
        );

        request.getSession().setAttribute("message", "addedProduct");
        return "redirect:productView.do";
    }
}
