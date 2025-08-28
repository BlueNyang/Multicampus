package com.mc.advanture.characters;

public abstract class Character {
    String name;
    int hp;
    int currentHp;
    int level;
    int atk;
    int def;

    public Character(String name, int hp, int atk, int def) {
        super();
        this.name = name;
        this.hp = hp;
        this.currentHp = hp;
        this.level = 1;
        this.atk = atk;
        this.def = def;
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

    public int getLevel() {
        return level;
    }

    public boolean isDead() {
        return this.currentHp <= 0;
    }

    abstract public void attack(Character target);

    abstract public void takeDamage(int damage);
}
