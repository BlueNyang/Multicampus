package kr.bluenyang.practice.springbootex.cart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartReqDTO {
    private String memId;
    private String prdNo;
    private int cartQty;

    public Cart toEntity() {
        return Cart.builder()
                .memId(this.memId)
                .prdNo(this.prdNo)
                .cartQty(this.cartQty)
                .build();
    }
}
