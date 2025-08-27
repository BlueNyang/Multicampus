package com.mc.e_game.events;

import com.mc.e_game.characters.Player;
import com.mc.e_game.events.data.Event;
import com.mc.e_game.items.Equipment;
import com.mc.e_game.items.data.Equipments;

import java.util.Random;

public class TreasureEvent implements Event {
    private final String desc;

    public TreasureEvent(String desc) {
        this.desc = desc;
    }

    @Override
    public EventResult startEvent(Player player) {
        System.out.println("[Event] Treasure Found: " + this.desc);

        Equipment item = getRandomEquipment();
        System.out.println("[Event] You found a " + item.getName() + "!");

        player.equipItem(item);

        return EventResult.SUCCESS;
    }

    private Equipment getRandomEquipment() {
        Equipments[] items = Equipments.values();
        int idx = new Random().nextInt(items.length);
        return items[idx].create();
    }
}
