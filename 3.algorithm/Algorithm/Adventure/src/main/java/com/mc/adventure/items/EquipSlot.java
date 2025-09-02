package com.mc.adventure.items;

public enum EquipSlot {
    WEAPON("Weapon"),
    ARMOR("Armor"),
    HELMET("Helmet"),
    SHOES("Shoes");

    private String name;

    private EquipSlot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
