package com.mc.d_strategy.items;

import java.util.Random;

public class Equipment implements DamageWeight {
    private final String name;
    private final int atk;
    private final int def;
    private final Slot slot;
    private final String effect;
    private final Random random = new Random();

    public Equipment(String name, int atk, int def, Slot slot, String effect) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.slot = slot;
        this.effect = effect;
    }

    public String getName() {
        return this.name;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public String getEffect() {
        return this.effect;
    }

    @Override
    public int calAttackWeight(int damage) {
        if (this.atk == 0) return damage;
        return random.nextInt(damage + this.atk, damage + this.atk * 2);
    }

    @Override
    public int calDefenceWeight(int damage) {
        return damage - (damage * def / 100);
    }
}
