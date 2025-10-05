package kr.bluenyang.practice.springbootex.cart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private int cartNo;
    private String memId;
    private String prdNo;
    private int cartQty;
}
