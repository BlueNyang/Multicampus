package com.mc.d_strategy.character;

public class Monster extends Character {
    public Monster(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    public void attack(Character target) {
        System.out.println("[" + this.name + "] Attack!");
        target.takeDamage(this.atk);
    }

    @Override
    public void takeDamage(int damage) {
        System.out.println("[" + name + "] Take Damage: " + damage);
        this.currentHp -= damage;
        this.currentHp = Math.max(this.currentHp, 0);
    }
}
