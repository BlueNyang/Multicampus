package kr.bluenyang.practice.springbootex.cart.service;

import kr.bluenyang.practice.springbootex.cart.model.CartItemViewDTO;
import kr.bluenyang.practice.springbootex.cart.model.CartVO;

import java.util.List;

public interface CartService {
    /**
     * Add an item to the cart.
     *
     * @param vo CartVO containing cart item details
     */
    void insertCartItem(CartVO vo);

    /**
     * Retrieve cart items for a specific member.
     *
     * @param memId Member ID
     * @return List of CartItemViewDTO representing the cart items
     */
    List<CartItemViewDTO> getCartItem(String memId);

    /**
     * Update the quantity of a cart item.
     *
     * @param vo CartVO containing updated cart item details
     */
    void updateCartQuantity(CartVO vo);

    /**
     * Update the quantity of a cart item by cart number.
     *
     * @param cartNo  Cart item number
     * @param cartQty New quantity
     */
    void updateCartQuantity(int cartNo, int cartQty);

    /**
     * Delete items from the cart.
     *
     * @param cartNo List of cart item numbers to delete
     * @param memId  Member ID
     */
    void deleteCartItems(List<String> cartNo, String memId);

    /**
     * Check if a product is already in the cart for a specific member.
     *
     * @param prdNo Product number
     * @param memId Member ID
     * @return true if the product is in the cart, false otherwise
     */
    boolean checkPrdInCart(String prdNo, String memId);

    void clearCart(String memId);
}
