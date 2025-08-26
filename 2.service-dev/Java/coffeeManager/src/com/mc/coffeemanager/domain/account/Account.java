package com.mc.coffeemanager.domain.account;

public class Account {
    private int balance = 100000;
    private int sales;
    private int purchase;
    private static Account instance;

    public static Account getInstance(int balance) {
        if (instance == null) {
            instance = new Account(balance);
        }

        return instance;
    }

    public static Account getInstance() {
        return getInstance(0);
    }

    private Account(int balance) {
        super();
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getSales() {
        return sales;
    }

    public int getPurchase() {
        return purchase;
    }

    public void registerSales(int price) {
        this.balance += price;
        this.sales += price;
    }

    public boolean registerPurchase(int price) {
        if (price > balance) {
            return false;
        }

        this.balance -= price;
        this.purchase += price;
        return true;
    }
}

