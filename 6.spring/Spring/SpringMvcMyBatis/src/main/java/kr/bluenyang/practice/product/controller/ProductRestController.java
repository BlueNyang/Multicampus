package kr.bluenyang.practice.product.controller;

import kr.bluenyang.practice.product.model.ProductVO;
import kr.bluenyang.practice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService service;

    @RequestMapping("/product/productSearch3")
    public List<ProductVO> productSearch3(@RequestParam HashMap<String, Object> param) {
        return service.searchProduct(param);
    }
}
