package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.dao.CartDAO;
import kr.bluenyang.practice.springbootex.cart.model.Cart;
import kr.bluenyang.practice.springbootex.cart.model.CartDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartReqDTO;
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
    public void insertCartItem(CartReqDTO cartItem) {
        log.info("insertCartItem - insert item: {}", cartItem.getPrdNo());
        var entity = cartItem.toEntity();
        log.info("insertCartItem - converted entity");
        try {
            dao.insertCartItem(entity);
            log.info("insertCartItem - item inserted");
        } catch (Exception e) {
            log.error("insertCartItem - error inserting item: {}", e.getMessage());
        }
    }

    @Override
    public List<CartItemViewDTO> getCartItem(String memId) {
        log.info("getCartItem - for member: {}", memId);
        try {
            return dao.getCartItems(memId);
        } catch (Exception e) {
            log.error("getCartItem - error retrieving items: {}", e.getMessage());
            return List.of();
        }
    }

    @Override
    public void updateCartQuantity(CartReqDTO cartItem) {
        log.info("updateCartItem - update item: {}", cartItem.getPrdNo());

        log.info("updateCartItem - checking existing item");
        var origin = dao.findCartItem(cartItem.getPrdNo(), cartItem.getMemId());
        if (origin == null) {
            log.warn("updateCartItem - item not found");
            return;
        }

        log.info("updateCartItem - item found, preparing update");
        var updateAttrDTO = new CartDTO();
        updateAttrDTO.setCartNo(origin.getCartNo());
        updateAttrDTO.setCartQty(origin.getCartQty() + cartItem.getCartQty());

        try {
            dao.updateCartItem(updateAttrDTO);
            log.info("updateCartItem - item updated");
        } catch (Exception e) {
            log.error("updateCartItem - error updating item: {}", e.getMessage());
        }
    }

    @Override
    public int deleteCartItems(List<String> cartNoList, String memId) {
        log.info("deleteCartItems - deleting items for member: {}", memId);

        if (cartNoList == null || cartNoList.isEmpty()) {
            log.warn("deleteCartItems - no items to delete");
            return 0;
        }

        int deletedCount = 0;
        for (String cartNo : cartNoList) {
            var originEntity = dao.findCartItemByNo(cartNo);
            if (originEntity == null) {
                log.warn("deleteCartItems - item {} not found", cartNo);
                continue;
            } else if (!originEntity.getMemId().equals(memId)) {
                log.warn("deleteCartItems - item {} does not belong to member {}", cartNo, memId);
                continue;
            }

            if (tryDeleteItem(cartNo)) {
                deletedCount++;
            }
        }


        return deletedCount;
    }

    @Override
    public boolean checkPrdInCart(String prdNo, String memId) {
        log.info("checkPrdInCart - checking product: {} for member: {}", prdNo, memId);
        var item = dao.findCartItem(prdNo, memId);

        if (item == null) {
            log.info("checkPrdInCart - product not found in cart");
            return false;
        }

        log.info("checkPrdInCart - product found in cart");
        return true;
    }

    private boolean tryDeleteItem(String cartNo) {
        try {
            dao.deleteCartItem(cartNo);
            return true;
        } catch (Exception e) {
            log.error("deleteCartItems - error deleting item {}: {}", cartNo, e.getMessage());
            return false;
        }
    }
}
