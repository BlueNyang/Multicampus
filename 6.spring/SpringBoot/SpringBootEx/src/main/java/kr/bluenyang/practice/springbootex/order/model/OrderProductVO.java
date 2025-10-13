package kr.bluenyang.practice.springbootex.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductVO {
    private String ordNo;
    private String prdNo;
    private int ordQty;
}
