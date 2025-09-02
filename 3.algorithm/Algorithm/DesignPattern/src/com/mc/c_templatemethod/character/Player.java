package com.mc.c_templatemethod.character;

public class Player extends Character {
    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAttackWeight() {
        return getRandInt(this.atk / 2, this.atk * 3);
    }

    @Override
    protected int calDefenseWeight(int dmg) {
        return dmg - (dmg * this.def / 100);
    }
}
