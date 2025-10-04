package kr.bluenyang.practice.springbootex.cart.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService service;

    @GetMapping("")
    public String cartListView(Model model, HttpSession httpSession) {
        log.info("cartListView - Display cart items");
        var memId = (String) httpSession.getAttribute("authId");
        var itemList = service.getCartItem(memId);

        log.info("cardListView - found {} items in cart", itemList.size());
        model.addAttribute("itemList", itemList);

        // Return the view name for displaying the cart items
        return "cart/cartListView";
    }
}
