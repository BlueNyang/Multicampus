package com.mc.adventure.items;

public class Food {
    private final String name;
    private final int hpRestore;
    private int stock;

    public Food(String name, int hpRestore) {
        this.name = name;
        this.hpRestore = hpRestore;
        this.stock = 1;
    }

    public String getName() {
        return this.name;
    }

    public int getHpRestore() {
        return this.hpRestore;
    }

    public int getStock() {
        return this.stock;
    }

    public void addStock(int amount) {
        this.stock += amount;
    }
}
