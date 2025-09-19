package kr.bluenyang.practice.sec03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
    @RequestMapping("/product/productForm")
    public String productForm(Model model) {
        return "sec03/product/productForm";
    }

    @RequestMapping("/product/newProduct")
    public String productForm(@RequestParam("prdNo") String prdNo,
                              @RequestParam("prdName") String prdName,
                              @RequestParam("prdPrice") String prdPrice,
                              @RequestParam("prdCompany") String prdCompany,
                              @RequestParam("prdDate") String prdDate,
                              @RequestParam("prdStock") String prdStock,
                              Model model) {

        model.addAttribute("prdNo", prdNo);
        model.addAttribute("prdName", prdName);
        model.addAttribute("prdPrice", prdPrice);
        model.addAttribute("prdCompany", prdCompany);
        model.addAttribute("prdDate", prdDate);
        model.addAttribute("prdStock", prdStock);

        return "sec03/product/productResult";
    }
}
