package com.mc.adventure.characters;

import com.mc.adventure.items.EquipSlot;
import com.mc.adventure.items.Equipment;
import com.mc.adventure.items.Food;
import com.mc.adventure.items.Inventory;
import com.mc.adventure.utils.ScanInput;

import java.util.Collection;

public class Player extends Character implements Playable {
    int exp;
    Inventory inventory;

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
        this.exp = 0;
        this.inventory = new Inventory();
    }

    @Override
    public void attack(Character target) {
        int damage = this.atk;

        for (Equipment equipment : inventory.findAllEquips()) {
            damage = equipment.calAttackWeight(damage);
            String effect = equipment.getEffect();

            if (effect == null || effect.isEmpty()) {
                continue;
            }

            System.out.println(effect);
        }

        if (damage < 0) {
            damage = 0;
        }

        System.out.println("[System] " + this.name + " attacks " + target.getName());
        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        damage -= damage * this.def / 100;

        for (Equipment equipment : inventory.findAllEquips()) {
            damage = equipment.calDefenceWeight(damage);
        }

        if (damage < 0) {
            return;
        }

        this.currentHp -= damage;

        if (this.currentHp < 0) {
            this.currentHp = 0;
        }

        System.out.println(this.name + " takes " + damage + " damage. (HP: " + this.currentHp + "/" + this.hp + ")");

        if (this.isDead()) {
            System.out.println(this.name + " is dead!");
        }
    }

    @Override
    public void expUp(int exp) {
        this.exp += exp;
        if (this.exp >= 100) {
            this.level++;
            this.exp -= 100;
            System.out.println(this.name + " leveled up to level " + this.level + "!");
        }
    }

    @Override
    public void equipItem(Equipment equipment) {
        Equipment nowEquipped = inventory.findEquipBySlot(equipment.getSlot());

        if (nowEquipped != null) {
            System.out.println("[System] You already have an item equipped in the " + equipment.getSlot() + " slot");
            System.out.println("[System] Now Equipped: " + nowEquipped);
            System.out.println("[System] New Item: " + equipment);
            System.out.print("[System] Do you want to replace it? (yes/no): ");
            if (ScanInput.getInstance().scanYesOrNo()) {
                inventory.unequip(equipment.getSlot());
            } else {
                System.out.println("[System] You decided not to equip the new item.");
                return;
            }
        }

        System.out.println("[System] You have equipped the new item.");
        System.out.println();
        inventory.equip(equipment);
    }

    @Override
    public void unequipItem(EquipSlot slot) {
        inventory.unequip(slot);
    }

    public void heal(int amount) {
        this.currentHp += amount;
        if (this.currentHp > this.hp) {
            this.currentHp = this.hp;
        }
        System.out.println(this.name + " healed " + amount + " HP. (HP: " + this.currentHp + "/" + this.hp + ")");
    }

    @Override
    public void addFoodToInventory(Food food) {
        inventory.storeFood(food);
    }

    @Override
    public void useFood(Food food) {
        if (inventory.removeFood(food)) {
            heal(food.getHpRestore());
            System.out.println("[System] You used " + food.getName() + " and restored " + food.getHpRestore() + " HP.");
        } else {
            System.out.println("[System] You don't have " + food.getName() + " in your inventory.");
        }
    }

    public Collection<Food> getAllFoods() {
        return inventory.findAllFoods();
    }
}
