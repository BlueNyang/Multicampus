package com.mc.d_strategy.character;

public abstract class Character {
    String name;
    int hp;
    int currentHp;
    int atk;
    int def;

    public Character(String name, int hp, int atk, int def) {
        super();
        this.name = name;
        this.hp = hp;
        this.currentHp = hp;
        this.atk = atk;
        this.def = def;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public boolean isDead() {
        return this.currentHp <= 0;
    }

    abstract public void attack(Character target);

    abstract public void takeDamage(int damage);
}
