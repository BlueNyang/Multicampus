package com.mc.adventure.items;

import com.mc.adventure.items.data.DamageWeight;

import java.util.Random;

public class Equipment implements DamageWeight {
    private final String name;
    private final int atk;
    private final int def;
    private final EquipSlot slot;
    private final String effect;

    public Equipment(String name, int atk, int def, EquipSlot slot, String effect) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.slot = slot;
        this.effect = effect;
    }

    public String getName() {
        return this.name;
    }

    public EquipSlot getSlot() {
        return this.slot;
    }

    public String getEffect() {
        return this.effect;
    }

    @Override
    public int calAttackWeight(int damage) {
        if (this.atk == 0) return damage;
        return damage + new Random().nextInt(this.atk, this.atk * 2);
    }

    @Override
    public int calDefenceWeight(int damage) {
        if (this.def == 0) return damage;
        return damage - new Random().nextInt(this.def, this.def * 2);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (ATK: %d, DEF: %d)", this.slot, this.name, this.atk, this.def);
    }
}
