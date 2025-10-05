package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartReqDTO;

import java.util.List;

public interface CartService {
    void insertCartItem(CartReqDTO cartItem);

    List<CartItemViewDTO> getCartItem(String memId);

    void updateCartQuantity(CartReqDTO cartItem);

    int deleteCartItems(List<String> cartNo, String memId);

    boolean checkPrdInCart(String prdNo, String memId);
}
