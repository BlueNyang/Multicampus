package kr.bluenyang.practice.springbootex.cart.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    private int cartNo;
    private String memId;
    private String prdNo;
    int CartQty;
}
