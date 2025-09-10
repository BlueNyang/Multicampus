package com.example.sec06;

public class ProductVO {
    private String productId;
    private String productName;
    private int price;
    private int stock;

    public ProductVO() {
    }

    public ProductVO(String productId, String productName, int price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
