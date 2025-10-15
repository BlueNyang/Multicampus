package kr.bluenyang.practice.springbootreact.product.controller;

import kr.bluenyang.practice.springbootreact.product.model.ProductDTO;
import kr.bluenyang.practice.springbootreact.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("/productList")
    public List<ProductDTO> productList() {
        return service.listAllProduct();
    }

    @GetMapping("/productDetail/{prdNo}")
    public ProductDTO productDetail(@PathVariable String prdNo) {
        return service.findProductByPrdNo(prdNo);
    }
}
