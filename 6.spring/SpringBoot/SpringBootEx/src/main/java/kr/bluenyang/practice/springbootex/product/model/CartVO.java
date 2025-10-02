package kr.bluenyang.practice.springbootex.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartVO {
    // DB 테이블에 있는 필드
    private int cartNo;
    private String memId;
    private String prdNo;
    private int cartQty;
}
