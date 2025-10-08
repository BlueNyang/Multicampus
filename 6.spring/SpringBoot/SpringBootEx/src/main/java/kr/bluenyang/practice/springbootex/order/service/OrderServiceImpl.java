package kr.bluenyang.practice.springbootex.order.service;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.service.CartService;
import kr.bluenyang.practice.springbootex.order.dao.OrderDAO;
import kr.bluenyang.practice.springbootex.order.model.OrderInfoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CartService cartService;
    private final OrderDAO dao;

    @Override
    public List<CartItemViewDTO> prepareOrderForm(int[] cartNo, int[] cartQty, String memId) {
        log.info("prepareOrderForm - Preparing order form for user: {}", memId);

        for (int i = 0; i < cartNo.length; i++) {
            cartService.updateCartQuantity(cartNo[i], cartQty[i]);
        }

        return cartService.getCartItem(memId);
    }

    @Override
    public void completeOrder(OrderInfoVO vo) {
        log.info("completeOrder - Processing order completion");

        // 1. Generate Order Number
        // Format: yyyyMMddHHmmss + 4 random digits
        var strTime = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date(System.currentTimeMillis()));

        var rNum = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            rNum.append((int) (Math.random() * 10));
        }

        String ordNo = strTime.concat(rNum.toString());
        vo.setOrdNo(ordNo);
        log.info("completeOrder - Generated Order Number: {}", ordNo);

        dao.insertOrderInfo(vo);

        Map<String, Object> map = new HashMap<>();
        map.put("ordNo", vo.getOrdNo());
        map.put("memId", vo.getMemId());

        dao.insertOrderProduct(map);

        cartService.clearCart(vo.getMemId());
        log.info("completeOrder - Order processing completed for Order Number: {}", ordNo);
    }
}
