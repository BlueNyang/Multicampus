package kr.bluenyang.practice.springbootex.cart.dao;

import kr.bluenyang.practice.springbootex.cart.model.Cart;
import kr.bluenyang.practice.springbootex.cart.model.CartDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartDAO {
    void insertCartItem(Cart item);

    List<CartItemViewDTO> getCartItems(String memId);

    Cart findCartItem(@Param("prdNo") String prdNo, @Param("memId") String memId);

    Cart findCartItemByNo(String cartNo);

    void updateCartItem(CartDTO updateAttrDTO);

    void deleteCartItem(String cartNo);
}
