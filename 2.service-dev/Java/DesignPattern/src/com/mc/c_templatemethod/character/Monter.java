package com.mc.c_templatemethod.character;

public class Monter extends Character {
    public Monter(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAttackWeight() {
        return getRandInt(this.atk, this.atk * 2);
    }

    @Override
    protected int calDefenseWeight(int dmg) {
        return dmg - (dmg * this.def / 100);
    }
}
