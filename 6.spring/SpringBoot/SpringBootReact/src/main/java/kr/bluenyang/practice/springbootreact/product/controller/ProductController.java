package kr.bluenyang.practice.springbootreact.product.controller;

import kr.bluenyang.practice.springbootreact.product.model.ProductDTO;
import kr.bluenyang.practice.springbootreact.product.model.ProductSearchDTO;
import kr.bluenyang.practice.springbootreact.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @GetMapping("/productList")
    public List<ProductDTO> productList() {
        log.info("productList - called");
        return service.listAllProduct();
    }

    @GetMapping("/productDetail/{prdNo}")
    public ProductDTO productDetail(@PathVariable String prdNo) {
        log.info("productDetail - called");
        return service.findProductByPrdNo(prdNo);
    }

    @PostMapping("/insertProduct")
    public String insertProduct(@RequestBody ProductDTO dto) {
        log.info("insertProduct - called");
        return service.insertProduct(dto);
    }

    @GetMapping("/productUpdateInfo/{prdNo}")
    public ProductDTO productUpdate(@PathVariable String prdNo) {
        log.info("productUpdate - called");
        return service.findProductByPrdNo(prdNo);
    }

    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody ProductDTO dto) {
        log.info("updateProduct - called");
        service.updateProduct(dto);
    }

    @DeleteMapping("/deleteProduct/{prdNo}")
    public void deleteProduct(@PathVariable String prdNo) {
        log.info("deleteProduct - called");
        service.deleteProduct(prdNo);
    }

    @PostMapping("/searchProduct")
    public List<ProductDTO> searchProduct(@RequestBody ProductSearchDTO dto) {
        log.info("searchProduct - called");
        return service.searchProduct(dto);
    }
}
