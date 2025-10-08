package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.dao.CartDAO;
import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartDAO cartDAO;

    @Override
    public void insertCartItem(CartVO vo) {
        log.info("insertCartItem - insert item: {}", vo.getPrdNo());
        try {
            cartDAO.insertCartItem(vo);
            log.info("insertCartItem - item inserted");
        } catch (Exception e) {
            log.error("insertCartItem - error inserting item: {}", e.getMessage());
        }
    }

    @Override
    public List<CartItemViewDTO> getCartItem(String memId) {
        log.info("getCartItem - for member: {}", memId);
        try {
            return cartDAO.getCartItems(memId);
        } catch (Exception e) {
            log.error("getCartItem - error retrieving items: {}", e.getMessage());
            return List.of();
        }
    }

    @Override
    public void updateCartQuantity(CartVO vo) {
        log.info("updateCartItem - update item: {}", vo.getPrdNo());

        log.info("updateCartItem - checking existing item");
        var origin = cartDAO.findCartItem(vo.getPrdNo(), vo.getMemId());
        if (origin == null) {
            log.warn("updateCartItem - item not found");
            return;
        }

        log.info("updateCartItem - item found, preparing update");
        var updateAttr = new CartVO();
        updateAttr.setCartNo(origin.getCartNo());
        updateAttr.setCartQty(vo.getCartQty());

        try {
            cartDAO.updateCartItem(updateAttr);
            log.info("updateCartItem - item updated");
        } catch (Exception e) {
            log.error("updateCartItem - error updating item: {}", e.getMessage());
        }
    }

    @Override
    public void updateCartQuantity(int cartNo, int cartQty) {
        log.info("updateCartItemByCartNo - update item: {}", cartNo);

        log.info("updateCartItemByCartNo - checking existing item");
        if (cartDAO.findCartItemByNo(cartNo) == null) {
            log.warn("updateCartItemByCartNo - item not found");
            return;
        }

        log.info("updateCartItemByCartNo - item found, preparing update");
        var updateAttr = new CartVO();
        updateAttr.setCartNo(cartNo);
        updateAttr.setCartQty(cartQty);

        try {
            cartDAO.updateCartItem(updateAttr);
            log.info("updateCartItemByCartNo - item updated");
        } catch (Exception e) {
            log.error("updateCartItemByCartNo - error updating item: {}", e.getMessage());
        }
    }

    @Override
    public void deleteCartItems(List<String> cartNoList, String memId) {
        log.info("deleteCartItems - deleting items for member: {}", memId);

        if (cartNoList == null || cartNoList.isEmpty()) {
            log.warn("deleteCartItems - no items to delete");
            return;
        }

        cartDAO.deleteCartItem(cartNoList);
    }

    @Override
    public boolean checkPrdInCart(String prdNo, String memId) {
        log.info("checkPrdInCart - checking product: {} for member: {}", prdNo, memId);
        var item = cartDAO.findCartItem(prdNo, memId);

        if (item == null) {
            log.info("checkPrdInCart - product not found in cart");
            return false;
        }

        log.info("checkPrdInCart - product found in cart");
        return true;
    }

    @Override
    public void clearCart(String memId) {
        log.info("clearCart");
        cartDAO.clearCart(memId);
    }
}
