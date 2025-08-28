package com.mc.coffeemanager.domain.purchase;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;

public class Purchase {
    private final Coffee coffee;
    private final int purchaseCnt;
    private final int purchasePrice;

    public Purchase(Coffee coffee, int cnt) {
        this.coffee = coffee;
        this.purchaseCnt = cnt;
        this.purchasePrice = coffee.getPurchasePrice() * cnt;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getPurchaseCnt() {
        return purchaseCnt;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public boolean proceed() {
        Account account = Account.getInstance();
        if (account.registerPurchase(purchasePrice)) {
            System.out.println("system : Successfully purchased " + coffee.getName() + "[" + purchaseCnt + "]");
            coffee.addStock(purchaseCnt);
            return true;
        }

        System.out.println("system : Failed to purchase");
        return false;
    }
}
