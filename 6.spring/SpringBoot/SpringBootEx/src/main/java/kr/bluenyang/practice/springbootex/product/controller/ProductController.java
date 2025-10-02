package kr.bluenyang.practice.springbootex.product.controller;

import kr.bluenyang.practice.springbootex.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("")
    public String viewDefaultList(Model model) {
        log.info("view default list");

        var list = service.inquireAllProduct();
        model.addAttribute("productList", list);

        // 전체 product를 보여주는 view로 forwarding
        return "product/productListView";
    }

    @GetMapping("/productCtgList/{ctgId}")
    public String productCtgList(@PathVariable String ctgId, Model model) {
        log.info("get productCtgList: {}", ctgId);

        var list = service.findProductListByCtgId(ctgId);
        model.addAttribute("productList", list);

        // 카테고리별 product를 보여주는 view로 forwarding
        return "product/productListView";
    }

    @GetMapping("/productDetail/{prdId}")
    public String productDetail(@PathVariable String prdId, Model model) {
        log.info("get productDetail: {}", prdId);

        var prd = service.findProductByPrdId(prdId);
        model.addAttribute("product", prd);
        return "product/productDetailView";
    }
}
