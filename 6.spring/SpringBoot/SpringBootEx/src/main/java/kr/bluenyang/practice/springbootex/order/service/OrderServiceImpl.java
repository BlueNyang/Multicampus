package kr.bluenyang.practice.springbootex.order.service;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CartService cartService;

    @Override
    public List<CartItemViewDTO> prepareOrderForm(int[] cartNo, int[] cartQty, String memId) {
        for (int i = 0; i < cartNo.length; i++) {
            cartService.updateCartQuantity(cartNo[i], cartQty[i]);
        }

        return cartService.getCartItem(memId);
    }
}
