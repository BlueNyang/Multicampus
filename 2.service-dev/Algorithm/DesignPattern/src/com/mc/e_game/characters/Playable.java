package com.mc.e_game.characters;

import com.mc.e_game.items.Equipment;
import com.mc.e_game.items.EquipSlot;
import com.mc.e_game.items.Food;

public interface Playable {
    void expUp(int exp);

    void equipItem(Equipment equipment);

    void unequipItem(EquipSlot slot);

    void addFoodToInventory(Food food);

    void useFood(Food food);
}
