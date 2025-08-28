package com.mc.advanture.characters;

public class Monster extends Character {
    public Monster(String name, int hp, int atk, int def, int level) {
        super(name, hp, atk, def);
        this.level = level;
    }

    @Override
    public void attack(Character target) {
        System.out.println("[System] " + this.name + " attacks " + target.getName());
        target.takeDamage(this.atk);
    }

    @Override
    public void takeDamage(int damage) {
        damage -= damage * this.def / 100;

        this.currentHp -= damage;

        if (this.currentHp < 0) {
            this.currentHp = 0;
        }

        System.out.println(this.name + " takes " + damage + " damage. (HP: " + this.currentHp + "/" + this.hp + ")");

        if (this.isDead()) {
            System.out.println(this.name + " is dead!");
        }
    }
}
