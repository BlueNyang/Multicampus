package kr.bluenyang.practice.springbootex.product.model;

import kr.bluenyang.practice.springbootex.product.vo.Money;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Product {
    private String prdNo;
    private String prdName;
    private Money prdPrice;
    private String prdCompany;
    private int stock;
    private String prdDesc;
    private String prdImg;
    private String ctgId;

    @Builder
    public Product(String prdNo, String prdName, Money prdPrice, String prdCompany, int stock, String prdDesc, String prdImg, String ctgId) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdCompany = prdCompany;
        this.stock = stock;
        this.prdDesc = prdDesc;
        this.prdImg = prdImg;
        this.ctgId = ctgId;
    }
}
