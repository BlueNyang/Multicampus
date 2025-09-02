package com.mc.adventure.characters;

import com.mc.adventure.items.EquipSlot;
import com.mc.adventure.items.Equipment;
import com.mc.adventure.items.Food;

public interface Playable {
    void expUp(int exp);

    void equipItem(Equipment equipment);

    void unequipItem(EquipSlot slot);

    void addFoodToInventory(Food food);

    void useFood(Food food);
}
