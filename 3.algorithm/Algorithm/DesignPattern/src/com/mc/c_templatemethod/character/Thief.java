package com.mc.c_templatemethod.character;

public class Thief extends Character {
    public Thief(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAttackWeight() {
        return getRandInt(this.atk / 2, this.atk * 5);
    }

    @Override
    protected int calDefenseWeight(int dmg) {
        if (getRandInt(0, 2) == 0) {
            System.out.println("[Invoked thief's skill] Avoid");
            return 0;
        }
        return dmg - (dmg * this.def / 100);
    }
}
