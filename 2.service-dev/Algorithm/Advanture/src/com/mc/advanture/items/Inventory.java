package com.mc.advanture.items;

import com.mc.advanture.items.data.Equipments;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<EquipSlot, Equipment> equipments;
    private final Map<String, Food> foods;

    public Inventory() {
        equipments = new HashMap<>();
        foods = new HashMap<>();
        // 기본 무기 장착
        this.equip(Equipments.BASIC_SWORD.create());
    }

    public void equip(Equipment equipment) {
        equipments.put(equipment.getSlot(), equipment);
    }

    public void unequip(EquipSlot slot) {
        if (slot == EquipSlot.WEAPON) {
            this.equip(Equipments.BASIC_SWORD.create());
            return;
        }
        equipments.remove(slot);
    }

    public void storeFood(Food food) {
        if (foods.containsKey(food.getName())) {
            foods.get(food.getName()).addStock(food.getStock());
        } else {
            foods.put(food.getName(), food);
        }
    }

    public boolean removeFood(Food food) {
        if (!foods.containsKey(food.getName())) {
            return false;
        }

        Food storedFood = foods.get(food.getName());
        storedFood.addStock(-1);
        if (storedFood.getStock() == 0) {
            foods.remove(storedFood.getName());
        }
        return true;
    }

    public Collection<Equipment> findAllEquips() {
        return equipments.values();
    }

    public Equipment findEquipBySlot(EquipSlot slot) {
        return equipments.get(slot);
    }

    public Collection<Food> findAllFoods() {
        return foods.values();
    }
}
