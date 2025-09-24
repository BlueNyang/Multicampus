package kr.bluenyang.practice.sec01.controller;

import kr.bluenyang.practice.sec01.model.ProductVO;
import kr.bluenyang.practice.sec01.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @RequestMapping("/")
    public String viewIndex() {
        return "sec01/index";
    }

    @RequestMapping("/product/listAllProduct")
    public String listAllProduct(Model model) {
        List<ProductVO> prdList = service.listAllProduct();
        model.addAttribute("prdList", prdList);
        return "sec01/product/productListView";
    }

    @RequestMapping("/product/detailProduct/{prdNo}")
    public String detailProduct(@PathVariable String prdNo, Model model) {
        ProductVO prd = service.findProductByPrdNo(prdNo);

        log.info("prdNo:{}", prd.getPrdNo());

        model.addAttribute("prd", prd);

        return "sec01/product/productDetailView";
    }
}
