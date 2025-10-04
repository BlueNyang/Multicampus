package kr.bluenyang.practice.springbootex.cart.dao;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartDAO {
    List<CartItemViewDTO> getCartItems(String memId);
}
