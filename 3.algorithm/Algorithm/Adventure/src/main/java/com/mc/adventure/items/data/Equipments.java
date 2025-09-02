package com.mc.adventure.items.data;

import com.mc.adventure.items.EquipSlot;
import com.mc.adventure.items.Equipment;

public enum Equipments {
    BASIC_SWORD("Basic Sword", 5, 0, EquipSlot.WEAPON, ""),
    IRON_SWORD("Iron Sword", 10, 0, EquipSlot.WEAPON, "Slash!"),
    IRON_AXE("Iron Axe", 15, 0, EquipSlot.WEAPON, "Cleave!"),
    STEEL_HAMMER("Steel Hammer", 20, 0, EquipSlot.WEAPON, "Smash!"),
    MITHRIL_SWORD("Mithril Sword", 25, 0, EquipSlot.WEAPON, "Pierce!"),
    EXCALIBUR("Excalibur", 30, 0, EquipSlot.WEAPON, "Excalibur!"),

    WOODEN_SHIELD("Wooden Shield", 0, 5, EquipSlot.ARMOR, ""),
    LEATHER_ARMOR("Leather Armor", 0, 8, EquipSlot.ARMOR, ""),
    IRON_SHIELD("Iron Shield", 0, 10, EquipSlot.ARMOR, ""),
    IRON_ARMOR("Iron Armor", 0, 15, EquipSlot.ARMOR, ""),
    STEEL_ARMOR("Steel Armor", 0, 20, EquipSlot.ARMOR, ""),

    LEATHER_HELMET("Leather Helmet", 0, 3, EquipSlot.HELMET, ""),
    STEEL_HELMET("Steel Helmet", 0, 7, EquipSlot.HELMET, ""),

    LEATHER_BOOTS("Leather Boots", 0, 2, EquipSlot.SHOES, ""),
    STEEL_BOOTS("Steel Boots", 0, 5, EquipSlot.SHOES, "");

    private final String name;
    private final int atk;
    private final int def;
    private final EquipSlot slot;
    private final String effect;

    Equipments(String name, int atk, int def, EquipSlot slot, String effect) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.slot = slot;
        this.effect = effect;
    }

    public Equipment create() {
        return new Equipment(this.name, this.atk, this.def, this.slot, this.effect);
    }
}
