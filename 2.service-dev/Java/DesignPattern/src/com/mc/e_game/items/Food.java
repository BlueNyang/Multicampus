package com.mc.e_game.items;

public class Food {
    private final String name;
    private final String effect;
    private final int hpRestore;
    private int stock;

    public Food(String name, String effect, int hpRestore) {
        this.name = name;
        this.effect = effect;
        this.hpRestore = hpRestore;
        this.stock = 1;
    }

    public String getName() {
        return this.name;
    }

    public String getEffect() {
        return this.effect;
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
