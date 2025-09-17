package kr.bluenyang.practice.membercontrol.command.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.bluenyang.practice.membercontrol.command.Command;
import kr.bluenyang.practice.membercontrol.dao.ProductDAO;

import java.io.IOException;

public class ProductDelete implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ProductDAO.getInstance().deleteProduct(req.getParameter("prdNo"));
        req.getSession().setAttribute("message", "deletedProduct");
        return "redirect:productView.do";
    }
}
