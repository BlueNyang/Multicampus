package com.mc.adventure.items.data;

import com.mc.adventure.items.Food;

public enum Foods {
    APPLE_PIE("Apple Pie", 20),
    BREAD("Bread", 10),
    CHICKEN_SOUP("Chicken Soup", 30),
    GRILLED_FISH("Grilled Fish", 25),
    VEGETABLE_SALAD("Vegetable Salad", 15);

    private final String name;
    private final int hpRestore;

    Foods(String name, int hpRestore) {
        this.name = name;
        this.hpRestore = hpRestore;
    }

    public Food create() {
        return new Food(this.name, this.hpRestore);
    }
}
