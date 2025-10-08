package kr.bluenyang.practice.springbootex.order.service;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.order.model.OrderInfoVO;

import java.util.List;

public interface OrderService {

    // Order processing methods

    List<CartItemViewDTO> prepareOrderForm(int[] cartNo, int[] cartQty, String memId);

    void completeOrder(OrderInfoVO vo);
}
