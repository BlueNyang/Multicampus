package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.dao.CartDAO;
import kr.bluenyang.practice.springbootex.cart.model.Cart;
import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartDAO dao;

    @Override
    public void insertCartItem(Cart cartItem) {

    }

    @Override
    public List<CartItemViewDTO> getCartItem(String memId) {
        log.info("getCartItem - for member: {}", memId);
        return dao.getCartItems(memId);
    }
}
