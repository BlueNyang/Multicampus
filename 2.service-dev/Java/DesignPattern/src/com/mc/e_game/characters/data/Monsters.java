package com.mc.e_game.characters.data;

import com.mc.e_game.characters.Monster;

public enum Monsters {
    SLIME("Slime", 80, 10, 0, 1),
    GOBLIN("Goblin", 100, 15, 2, 3),
    ORC("Orc", 150, 20, 5, 5),
    TROLL("Troll", 200, 30, 10, 8),
    DRAGON("Dragon", 350, 45, 20, 15);

    private final String name;
    private final int hp;
    private final int atk;
    private final int def;
    private final int level;

    Monsters(String name, int hp, int atk, int def, int level) {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.level = level;
    }

    public Monster create() {
        return new Monster(this.name, this.hp, this.atk, this.def, this.level);
    }
}
