package com.mc.d_strategy.character;

import com.mc.d_strategy.items.Equipment;
import com.mc.d_strategy.items.Equipments;
import com.mc.d_strategy.items.Slot;
import com.mc.d_strategy.items.code.EquipmentData;

import java.util.Random;

public class Player extends Character {
    Equipments equipments;
    Random random = new Random();

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
        equipments = new Equipments();
    }

    @Override
    public void attack(Character target) {
        int damage = random.nextInt(this.atk, this.atk * 3);

        for (Equipment equipment : this.equipments.findAll()) {
            damage = equipment.calAttackWeight(damage);
        }

        System.out.println("[" + this.name + "] Attack!");
        equipments.getEquipment(Slot.WEAPON).ifPresent(equipment ->
                System.out.println("[" + this.name + "] " + equipment.getEffect())
        );

        target.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        for (Equipment equipment : this.equipments.findAll()) {
            damage = equipment.calDefenceWeight(damage);
        }

        System.out.println("[" + name + "] Take Damage: " + damage);
        this.currentHp -= damage;
        this.currentHp = Math.max(this.currentHp, 0);
    }

    public void equip(EquipmentData equipment) {
        this.equipments.equip(equipment);
    }
}
