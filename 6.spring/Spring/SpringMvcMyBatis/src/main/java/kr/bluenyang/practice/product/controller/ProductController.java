package kr.bluenyang.practice.product.controller;

import kr.bluenyang.practice.product.model.ProductVO;
import kr.bluenyang.practice.product.service.ProductService;
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

    @RequestMapping("/listAllProduct")
    public String listAllProduct(Model model) {
        List<ProductVO> prdList = service.listAllProduct();
        model.addAttribute("prdList", prdList);
        return "product/productListView";
    }

    @RequestMapping("/detailProduct/{prdNo}")
    public String detailProduct(@PathVariable String prdNo, Model model) {
        ProductVO prd = service.findProductByPrdNo(prdNo);

        log.info("prdNo:{}", prd.getPrdNo());

        model.addAttribute("prd", prd);

        return "product/productDetailView";
    }

    @RequestMapping("/updateProductForm/{prdNo}")
    public String updateProductForm(@PathVariable String prdNo, Model model) {
        ProductVO prd = service.findProductByPrdNo(prdNo);
        model.addAttribute("prd", prd);
        return "product/updateProductForm";
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(ProductVO prd) {
        service.updateProduct(prd);
        return "redirect:/product/productListView";
    }

    @RequestMapping("/insertProductForm")
    public String insertProductForm() {
        return "product/newProductForm";
    }

    @RequestMapping("/insertProduct")
    public String insertProduct(ProductVO prd) {
        service.insertProduct(prd);
        return "redirect:/listAllProduct";
    }

    @RequestMapping("/deleteProduct/{prdNo}")
    public String deleteProduct(@PathVariable String prdNo) {
        service.deleteProduct(prdNo);
        return "redirect:/listAllProduct";
    }
}
