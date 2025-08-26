package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

public class Coffee {
    private final String name;
    private final int price;
    private final int purchasePrice;
    private final int safetyStock;
    private int stock;
    private int salesCnt;

    public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt) {
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.safetyStock = safetyStock;
        this.salesCnt = salesCnt;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getStock() {
        return stock;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public int getSalesCnt() {
        return salesCnt;
    }

    public void provide(int cnt) {
        deductStock(cnt);
        addSalesCnt(cnt);
        checkSafetyStock();
    }

    private void checkSafetyStock() {
        if (stock <= safetyStock) {
            Purchase purchase = new Purchase(this, safetyStock * 2);

            if (purchase.proceed()) {
                System.out.println("system : Successfully purchased to secure safety stock.");
                return;
            }
            ;

            System.out.println("system : Failed to purchase to secure safety stock.");
        }
    }

    private void addSalesCnt(int cnt) {
        this.salesCnt += cnt;
    }

    private void deductStock(int cnt) {
        this.stock -= cnt;
    }

    public void addStock(int cnt) {
        this.stock += cnt;
    }
}
