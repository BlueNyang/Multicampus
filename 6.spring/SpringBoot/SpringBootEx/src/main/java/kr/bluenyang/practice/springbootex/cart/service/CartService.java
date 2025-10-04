package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.model.Cart;
import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;

import java.util.List;

public interface CartService {
    void insertCartItem(Cart cartItem);

    List<CartItemViewDTO> getCartItem(String memId);
}
