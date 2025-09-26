package kr.bluenyang.practice.product.controller;

import kr.bluenyang.practice.product.model.ProductVO;
import kr.bluenyang.practice.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProductController {
    private final IProductService service;

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
        return "redirect:/product/listAllProduct";
    }

    @RequestMapping("/insertProductForm")
    public String insertProductForm() {
        return "product/newProductForm";
    }

    @RequestMapping("/insertProduct")
    public String insertProduct(ProductVO prd) {
        service.insertProduct(prd);
        return "redirect:/product/listAllProduct";
    }

    @RequestMapping("/deleteProduct/{prdNo}")
    public String deleteProduct(@PathVariable String prdNo) {
        service.deleteProduct(prdNo);
        return "redirect:/product/listAllProduct";
    }

    /// //////////////////////////////////////////////////////
    // AJAX
    // POST 방식
    @ResponseBody
    @RequestMapping("/prdNoCheck")
    public String prdNoCheck(@RequestParam String prdNo) {
        log.info("prdNoCheck");
        return checkPrdNo(prdNo);
    }

    // GET 방식
    @ResponseBody
    @RequestMapping("/prdNoCheck2/{prdNo}")
    public String prdNoCheck2(@PathVariable String prdNo) {
        log.info("prdNoCheck2");
        return checkPrdNo(prdNo);
    }

    // fetch() GET 방식 - 요청 url에 쿼리스트링으로 전달
    @ResponseBody
    @RequestMapping("/prdNoCheck3")
    public String prdNoCheck3(@RequestParam String prdNo) {
        log.info("prdNoCheck3");
        return checkPrdNo(prdNo);
    }

    // axios GET 방식
    @ResponseBody
    @RequestMapping("/prdNoCheck4/{prdNo}")
    public String prdNoCheck4(@PathVariable String prdNo) {
        log.info("prdNoCheck4");
        return checkPrdNo(prdNo);
    }

    // fetch() GET 방식 - 요청 url에 쿼리스트링으로 전달
    @ResponseBody
    @RequestMapping("/prdNoCheck5")
    public String prdNoCheck5(@RequestParam String prdNo) {
        log.info("prdNoCheck5");
        return checkPrdNo(prdNo);
    }

    private String checkPrdNo(String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        log.info("prdNo_result:{}", prdNo_result);
        String result = "available";
        if (prdNo_result != null) {
            result = "unavailable";
        }
        return result;
    }

    @RequestMapping("/prdSearchForm")
    public String prdSearchForm() {
        return "product/productSearchForm1";
    }

    @ResponseBody
    @RequestMapping("/productSearch1")
    public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param) {
        log.info("productSearch1 - type: {}, keyword:{}", param.get("type"), param.get("keyword"));
        return service.searchProduct(param);
    }
}
