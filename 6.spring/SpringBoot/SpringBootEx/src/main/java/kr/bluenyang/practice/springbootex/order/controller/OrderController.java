package kr.bluenyang.practice.springbootex.order.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final CartService cartService;

    // 주문서 작성 요청 처리 - 카트 목록 보기에서 요청 발생
    // 주문서 회원정보, cart 상품 목록 정보가 필요
    @PostMapping("/orderForm")
    public String orderForm(@RequestParam int[] cartNo,
                            @RequestParam int[] cartQty,
                            Model model,
                            HttpSession session) {
        log.info("orderForm - Preparing order form");

        String memId = (String) session.getAttribute("authId");
        if (memId == null) {
            log.warn("orderForm - No user logged in, redirecting to login page");
            return "redirect:/auth/loginForm";
        }

        cartService.prepareOrderForm(cartNo, cartQty, memId);


        return null;
    }
}
