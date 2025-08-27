package com.mc.e_game.events.data;

import com.mc.e_game.characters.Player;
import com.mc.e_game.events.FightEvent;
import com.mc.e_game.events.FoodEvent;
import com.mc.e_game.events.TreasureEvent;

public enum EventType {
    FIND_TREASURE, FIND_FOOD, FIGHT_ENEMY;

    public Event create() {
        return switch (this) {
            case FIND_TREASURE -> new TreasureEvent("A mysterious chest appears before you.");
            case FIND_FOOD -> new FoodEvent("You found some food in the box.");
            case FIGHT_ENEMY -> new FightEvent("A wild monster appears!");
        };
    }
}
