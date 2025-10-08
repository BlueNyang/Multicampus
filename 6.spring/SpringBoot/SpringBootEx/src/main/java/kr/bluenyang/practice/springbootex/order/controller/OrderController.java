package kr.bluenyang.practice.springbootex.order.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.auth.service.MemberService;
import kr.bluenyang.practice.springbootex.order.model.OrderInfoVO;
import kr.bluenyang.practice.springbootex.order.service.OrderService;
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
    private final MemberService memberService;
    private final OrderService orderService;

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

        var cartList = orderService.prepareOrderForm(cartNo, cartQty, memId);

        model.addAttribute("memDTO", memberService.getMember(memId));
        model.addAttribute("cartList", cartList);

        return "order/orderForm";
    }

    @PostMapping("/orderComplete")
    public String orderInsert(OrderInfoVO vo,
                              @RequestParam String hp1,
                              @RequestParam String hp2,
                              @RequestParam String hp3) {
        String hp = hp1 + "-" + hp2 + "-" + hp3;
        vo.setOrdRcvPhone(hp);

        orderService.completeOrder(vo);

        return "order/orderCompleteView";
    }
}
