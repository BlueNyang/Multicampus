package kr.bluenyang.practice.springbootex.cart.controller;

import jakarta.servlet.http.HttpSession;
import kr.bluenyang.practice.springbootex.cart.model.CartVO;
import kr.bluenyang.practice.springbootex.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        if (memId == null) {
            log.warn("cartListView - No user logged in, redirecting to login page");
            return "redirect:/auth/loginForm";
        }

        var itemList = service.getCartItem(memId);

        log.info("cardListView - found {} items in cart", itemList.size());
        model.addAttribute("cartList", itemList);

        // Return the view name for displaying the cart items
        return "cart/cartListView";
    }

    @PostMapping("/insertCart")
    public String insertCart(@RequestParam String prdNo, @RequestParam int cartQty, HttpSession httpSession) {
        log.info("insertCart - Adding item to cart: {}", prdNo);

        CartVO vo = new CartVO();
        vo.setPrdNo(prdNo);
        vo.setCartQty(cartQty);

        String memId = (String) httpSession.getAttribute("authId");
        vo.setMemId(memId);

        if (service.checkPrdInCart(vo.getPrdNo(), memId)) {
            log.info("insertCart - Item already in cart, updating quantity");
            service.updateCartQuantity(vo);
        } else {
            log.info("insertCart - Item not in cart, adding new item");
            service.insertCartItem(vo);
        }

        return "redirect:/cart";
    }

    @ResponseBody
    @PostMapping("/deleteFromCart")
    public int deleteFromCart(@RequestParam("chkBoxArr") List<String> chkBoxArr, HttpSession httpSession) {
        log.info("deleteFromCart - Deleting items from cart");

        if (chkBoxArr == null || chkBoxArr.isEmpty()) {
            log.warn("deleteFromCart - No items selected for deletion");
            return 0;
        }

        String memId = (String) httpSession.getAttribute("authId");
        service.deleteCartItems(chkBoxArr, memId);

        log.info("deleteFromCart - Deleted items from cart");
        return chkBoxArr.size();
    }
}
