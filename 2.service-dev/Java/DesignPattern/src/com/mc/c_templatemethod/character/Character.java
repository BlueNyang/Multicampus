package com.mc.c_templatemethod.character;

import java.util.Random;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int currentHp;
    protected int atk;
    protected int def;

    public Character(String name, int hp, int atk, int def) {
        super();
        this.name = name;
        this.hp = hp;
        this.currentHp = hp;
        this.atk = atk;
        this.def = def;
    }

    public void attack(Character target) {
        System.out.println("[" + this.name + "] attacks [" + target.name + "]");
        int dmg = calAttackWeight();
        target.takeDamage(dmg);
    }

    public void takeDamage(int dmg) {
        int realDmg = calDefenseWeight(dmg);
        this.currentHp -= realDmg;
        System.out.println("[" + this.name + "] takes " + realDmg + " damage. (HP: " + Math.max(this.currentHp, 0) + "/" + this.hp + ")");
        if (this.currentHp <= 0) {
            System.out.println("[" + this.name + "] is dead.");
        }
    }

    public boolean isDead() {
        return this.currentHp <= 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    protected int getRandInt(int min, int max) {
        return new Random().nextInt(min, max);
    }

    abstract protected int calAttackWeight();

    abstract protected int calDefenseWeight(int dmg);

}
