package kr.bluenyang.practice.membercontrol.domain.product;

import lombok.Getter;

@Getter
public class Product {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdMaker;
    private String prdColor;
    private int ctgNo;

    public Product() {
    }

    public Product(String prdNo, String proName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
        this.prdNo = prdNo;
        this.prdName = proName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
        this.prdColor = prdColor;
        this.ctgNo = ctgNo;
    }
}
