package kr.bluenyang.practice.springbootex.product.model;

import kr.bluenyang.practice.springbootex.product.vo.MoneyVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class Product {
    private String prdNo;
    private String prdName;
    private MoneyVO prdPrice;
    private String prdCompany;
    private int prdStock;
    private String prdDesc;
    private String prdImg;
    private String ctgId;

    @Builder
    public Product(String prdNo, String prdName, MoneyVO prdPrice, String prdCompany,
                   int prdStock, String prdDesc, String prdImg, String ctgId) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdCompany = prdCompany;
        this.prdStock = prdStock;
        this.prdDesc = prdDesc;
        this.prdImg = prdImg;
        this.ctgId = ctgId;
    }
}
