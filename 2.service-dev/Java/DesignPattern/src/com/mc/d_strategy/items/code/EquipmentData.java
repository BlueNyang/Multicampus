package com.mc.d_strategy.items.code;

import com.mc.d_strategy.items.Equipment;
import com.mc.d_strategy.items.Slot;

public enum EquipmentData {
    BASIC_WEAPON("Hand", 1, 1, Slot.WEAPON, "Swing fist"),
    WOODEN_SWORD("Wooden Sword", 3, 0, Slot.WEAPON, "Wield a wooden sword"),
    WOODEN_AXE("Wooden Axe", 5, -1, Slot.WEAPON, "Swing a wooden axe"),
    KATANA("Katana", 7, -2, Slot.WEAPON, "Slash with a katana"),

    LEATHER_ARMOR("Leather Armor", 0, 3, Slot.ARMOR, ""),
    LEATHER_BOOTS("Leather Boots", 0, 1, Slot.SHOES, ""),
    STEEL_ARMOR("Steel Armor", 0, 5, Slot.ARMOR, "");

    private final String name;
    private final int atk;
    private final int def;
    private final Slot slot;
    private final String effect;

    EquipmentData(String name, int atk, int def, Slot slot, String effect) {
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
