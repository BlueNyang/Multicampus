package kr.bluenyang.practice.springbootex.product.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductVO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdCompany;
    private int prdStock;
    private String prdDesc;
    private String prdImg;
    private String ctgId;
}
