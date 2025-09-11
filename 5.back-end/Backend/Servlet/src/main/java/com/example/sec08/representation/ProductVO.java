package com.example.sec08.representation;

import lombok.Getter;

// View에 전달할 데이터를 담는 VO 클래스
@Getter
public class ProductVO {
    private String prdNo;
    private String prdName;
    private int prdPrice;
    private String prdMaker;
    private String prdColor;
    private int ctgNo;

    public ProductVO() {
    }

    public ProductVO(String prdNo, String prdName, int prdPrice, String prdMaker, String prdColor, int ctgNo) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdMaker = prdMaker;
        this.prdColor = prdColor;
        this.ctgNo = ctgNo;
    }

}
