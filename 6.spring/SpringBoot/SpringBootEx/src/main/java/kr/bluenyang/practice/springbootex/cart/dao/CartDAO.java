package kr.bluenyang.practice.springbootex.cart.dao;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartDAO {
    void insertCartItem(CartVO item);

    List<CartItemViewDTO> getCartItems(String memId);

    CartVO findCartItem(@Param("prdNo") String prdNo, @Param("memId") String memId);

    CartVO findCartItemByNo(int cartNo);

    void updateCartItem(CartVO updateAttrDTO);

    void deleteCartItem(List<String> cartNo);
}
