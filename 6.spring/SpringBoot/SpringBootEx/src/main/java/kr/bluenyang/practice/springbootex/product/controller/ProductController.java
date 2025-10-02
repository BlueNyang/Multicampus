package kr.bluenyang.practice.springbootex.product.controller;

import kr.bluenyang.practice.springbootex.product.model.ProductVO;
import kr.bluenyang.practice.springbootex.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    // main 페이지
    @RequestMapping("/")
    public String viewIndex() {
        return "index"; // 메인페이지 뷰
    }

    // 전체 상품 조회
    @RequestMapping("/listAllProduct")
    public String listAllProduct(Model model) {
        // 1. service 메소드 호출
        ArrayList<ProductVO> prdList = service.listAllProduct();
        // 2. model에 prdList 저장
        model.addAttribute("prdList", prdList);
        // 3. 뷰 페이지 결정 후 반환
        return "product/productListView";
    }

    // 상품 등록 폼 요청
    @RequestMapping("/newProductForm")
    public String newProductForm() {
        return "product/newProductForm";
    }

    // 상품 등록 요청 -> 로직 처리
    @RequestMapping("/insertProduct")
    public String insertProduct(ProductVO vo) {
        // 1. insert 기능을 처리할 service method 호출(파라미터로 전달된 입력값을 command 객체에 저장해서 전송)
        service.insertProduct(vo);
        // 2. 상품 등록 후에 등록 확인 위해서 전체상품목록을 뷰로 결정 - 전체상품 조회 재요청
        return "redirect:/product/listAllProduct";
        // 프론트컨트롤러가 반환받아서 redirect: 뒤의 uri로 요청을 하도록 브라우저에 응답신호 보냄
        // return "product/productListView";//뷰페이지는 출력되지만 데이터 표현되지 않음
    }

    // 상품 상세 정보
    @RequestMapping("/detailViewProduct/{prdNo}")
    public String detailViewProduct(@PathVariable String prdNo, Model model) {
        // 1. 상품 번호 전송해서 관련 정보 반환
        ProductVO prd = service.detailViewProduct(prdNo);
        // 2. 반환 정보 모델에 저장
        model.addAttribute("prd", prd);
        // 3. view 페이지 결정
        return "product/productDetailView";
    }

    // 상품정보 수정 요청 처리 - 수정폼  : /product/updateProductForm/1003
    @RequestMapping("/updateProductForm/{prdNo}")
    public String updateProductForm(@PathVariable String prdNo, Model model) {
        ProductVO prd = service.detailViewProduct(prdNo);
        model.addAttribute("prd", prd);
        return "product/updateProductForm";
    }

    // 상품정보 수정 로직 처리
    @RequestMapping("/updateProduct")
    public String updateProduct(ProductVO prd) {
        service.updateProduct(prd);
        return "redirect:/product/listAllProduct";
    }

    // 상품정보 삭제 로직 처리
    @RequestMapping("/deleteProduct/{prdNo}")
    public String deleteProduct(@PathVariable String prdNo) {
        service.deleteProduct(prdNo);
        return "redirect:/product/listAllProduct";
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////
    // ajax 처리 연습////////////

    // 상품정보 중복 확인 처리
    @ResponseBody // method단위로 rest 구성
    @RequestMapping("/prdNoCheck")
    public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // ajax get 방식 요청 처리 - 요청 url에 상품번호가 포함됨
    // 상품정보 중복 확인 처리
    @ResponseBody
    @RequestMapping("/prdNoCheck1/{prdNo}")
    public String prdNoCheck1(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // fetch() get 방식 요청 처리 - 요청 url에 상품번호가 포함됨
    // 상품정보 중복 확인 처리
    @ResponseBody
    @RequestMapping("/prdNoCheck2/{prdNo}")
    public String prdNoCheck2(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }


    // fetch() post 방식 요청 처리 - 네트워크 data body key에 상품번호가 포함됨
    // 상품정보 중복 확인 처리
    @ResponseBody
    @RequestMapping("/prdNoCheck3")
    public String prdNoCheck3(@RequestBody String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // axios() get 방식 요청 처리 - 요청 url에 상품번호가 포함됨
    // 상품정보 중복 확인 처리
    @ResponseBody
    @RequestMapping("/prdNoCheck4/{prdNo}")
    public String prdNoCheck4(@PathVariable String prdNo) {
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // axios() post 방식 요청 처리 - 요청 url에 상품번호가 포함됨
    // 상품정보 중복 확인 처리
    @ResponseBody
    @RequestMapping("/prdNoCheck5")
    public String prdNoCheck5(@RequestBody HashMap<String, String> map) {
        String prdNo = map.get("prdNo");
        String prdNo_result = service.prdNoCheck(prdNo);
        System.out.println(prdNo);
        String result = "available";
        if (prdNo_result != null) {
            result = "no_available";
        }
        return result;
    }

    // 상품검색 폼 요청 처리
    @RequestMapping("/productSearchForm1")
    public String productSearchForm1() {
        return "product/productSearchForm1";
    }

    // 상품 검색 처리
    // 파라미터 2개 전송됨 : 검색기준,검색어 : type:prdName keyword:모니터
    @ResponseBody
    @RequestMapping("/productSearch1")
    public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param, Model model) {
        ArrayList<ProductVO> prdList = service.productSearch(param);
        // model.addAttribute("prdList",prdList);

        return prdList; // ArrayList 반환
    }

    // 상품검색 폼2 요청 처리
    @RequestMapping("/productSearchForm2")
    public String productSearchForm2() {
        return "product/productSearchForm2";
    }

    // 상품 검색 처리2
    // 파라미터 2개 전송됨 : 검색기준,검색어 : type:prdName keyword:모니터
    @RequestMapping("/productSearch2")
    public String productSearch2(@RequestParam HashMap<String, Object> param, Model model) {
        ArrayList<ProductVO> prdList = service.productSearch(param);
        model.addAttribute("prdList", prdList);

        return "product/productSearchResultView";
    }

    // 상품검색 폼3 요청 처리
    @RequestMapping("/productSearchForm3")
    public String productSearchForm3() {
        return "product/productSearchForm3";
    }
}


















































