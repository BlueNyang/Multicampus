package com.mc.e_game.items.data;

import com.mc.e_game.items.Food;

public enum Foods {
    APPLE_PIE("Apple Pie", "Restores 20 HP", 20),
    BREAD("Bread", "Restores 10 HP", 10),
    CHICKEN_SOUP("Chicken Soup", "Restores 30 HP", 30),
    GRILLED_FISH("Grilled Fish", "Restores 25 HP", 25),
    VEGETABLE_SALAD("Vegetable Salad", "Restores 15 HP", 15);

    private final String name;
    private final String effect;
    private final int hpRestore;

    Foods(String name, String effect, int hpRestore) {
        this.name = name;
        this.effect = effect;
        this.hpRestore = hpRestore;
    }

    public Food create() {
        return new Food(this.name, this.effect, this.hpRestore);
    }
}
