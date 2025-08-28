package com.mc.c_templatemethod.character;

public class Warrior extends Character {
    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAttackWeight() {
        if (getRandInt(0, 5) == 0) {
            System.out.println("[Invoked warrior's skill] Critical Hit");
            return this.atk * 4;
        }
        return getRandInt(this.atk, this.atk * 4);
    }

    @Override
    protected int calDefenseWeight(int dmg) {
        int realDmg = dmg - (dmg * 30 / 100);
        return realDmg - (realDmg * this.def / 100);
    }
}
