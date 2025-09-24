package kr.bluenyang.practice.sec02.controller;

import kr.bluenyang.practice.sec02.dao.ProductDAO;
import kr.bluenyang.practice.sec02.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductDAO dao;

    @RequestMapping("")
    public String prdIndex() {
        return "sec02/index";
    }

    @RequestMapping("/product/productSelect")
    public String prdSelect(Model model) {

        List<ProductDTO> prdList = dao.memberSelect();
        model.addAttribute("prdList", prdList);
        model.addAttribute("prdListSize", prdList.size());

        return "sec02/product/productSelect";
    }
}
