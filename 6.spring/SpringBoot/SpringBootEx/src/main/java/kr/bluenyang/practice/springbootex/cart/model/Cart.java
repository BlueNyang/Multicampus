package kr.bluenyang.practice.springbootex.cart.model;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode(of = "cartNo")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cart {
    private int cartNo;
    private String memId;
    private String prdNo;
    private int cartQty;
}
