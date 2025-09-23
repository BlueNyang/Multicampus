package kr.bluenyang.practice.sec03;

import kr.bluenyang.practice.sec03.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
public class ProductController {
    @RequestMapping("/product/productForm")
    public String productForm(Model model) {
        return "sec03/product/productForm";
    }

    @RequestMapping("/product/productForm2")
    public String productForm2(Model model) {
        return "sec03/product/productForm2";
    }

    @RequestMapping("/product/productForm3")
    public String productForm3(Model model) {
        return "sec03/product/productForm3";
    }

    @RequestMapping("/product/productForm4")
    public String productForm4(Model model) {
        return "sec03/product/productForm4";
    }

    @RequestMapping("/product/productSearchForm")
    public String productSearchForm(Model model) {
        return "sec03/product/productSearchForm";
    }

    @RequestMapping("/product/newProduct")
    public String productForm(HttpServletRequest request, Model model) {
        String prdNo = request.getParameter("prdNo");
        String prdName = request.getParameter("prdName");
        String prdPrice = request.getParameter("prdPrice");
        String prdCompany = request.getParameter("prdCompany");
        String prdDate = request.getParameter("prdDate");
        String prdStock = request.getParameter("prdStock");
        insertModel(model, prdNo, prdName, prdPrice, prdCompany, prdDate, prdStock);
        return "sec03/product/productResult";
    }

    @RequestMapping("/product/newProduct2")
    public String productForm2(@RequestParam("prdNo") String prdNo,
                               @RequestParam("prdName") String prdName,
                               @RequestParam("prdPrice") String prdPrice,
                               @RequestParam("prdCompany") String prdCompany,
                               @RequestParam("prdDate") String prdDate,
                               @RequestParam("prdStock") String prdStock,
                               Model model) {
        insertModel(model, prdNo, prdName, prdPrice, prdCompany, prdDate, prdStock);
        return "sec03/product/productResult";
    }

    @RequestMapping("/product/newProduct3")
    public String productForm3(Product product) {
        return "sec03/product/productResult3";
    }

    @RequestMapping("/product/newProduct4")
    public String productForm4(@ModelAttribute("prd") Product product) {
        return "sec03/product/productResult4";
    }

    @RequestMapping("/product/productDetailView/{prdName}")
    public String productDetailView(@PathVariable String prdName) {
        log.info("prdName:{}", prdName);
        return "sec03/product/productResult";
    }

    @RequestMapping("/product/productDetailView/{prdName}/{prdStock}/{prdNo}")
    public String productDetailView2(@PathVariable String prdName,
                                     @PathVariable String prdStock,
                                     @PathVariable String prdNo) {
        log.info("prdNo:{}", prdNo);
        log.info("prdName:{}", prdName);
        log.info("prdStock:{}", prdStock);
        return "sec03/product/productResult";
    }

    @RequestMapping("/product/productSearch")
    public String productSearch(
            @RequestParam HashMap<String, Object> params,
            Model model) {
        log.info("type:{}", params.get("type"));
        log.info("keyword:{}", params.get("keyword"));

        List<Product> productList = Arrays.asList(
                new Product(
                        "4",
                        "세탁기",
                        3000000,
                        "삼성",
                        LocalDate.of(2023, 6, 1),
                        20
                ),
                new Product(
                        "5",
                        "냉장고",
                        2000000,
                        "LG",
                        LocalDate.of(2023, 5, 1),
                        30
                )
        );

        model.addAttribute("productList", productList);

        return "sec03/product/productSearchResult";
    }

    private void insertModel(Model model, String prdNo, String prdName, String prdPrice, String prdCompany, String prdDate, String prdStock) {
        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("prdPrice", prdPrice);
        model.addAttribute("prdCompany", prdCompany);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("prdStock", prdStock);
    }
}
