package com.mc.adventure.events;

import com.mc.adventure.characters.Player;
import com.mc.adventure.events.data.Event;
import com.mc.adventure.items.Equipment;
import com.mc.adventure.items.data.Equipments;
import com.mc.adventure.utils.ScanInput;

import java.util.Random;

public class TreasureEvent implements Event {
    private final String desc;

    public TreasureEvent(String desc) {
        this.desc = desc;
    }

    @Override
    public EventResult startEvent(Player player) {
        getEquipment(player);

        return EventResult.SUCCESS;
    }

    private void getEquipment(Player player) {
        int count = new Random().nextInt(3) + 1;

        System.out.println("-----------------------------------");
        System.out.println("[Event] Treasure(x" + count + ")Found: " + this.desc);
        System.out.print("Press Enter to open the treasure chest...");
        ScanInput.getInstance().scanEnter();

        for (int i = 0; i < count; i++) {
            System.out.println("-----------------------------------");
            Equipment item = getRandomEquipment();
            System.out.println("[Event] You found a " + item.getName() + "!");
            player.equipItem(item);
        }
    }

    private Equipment getRandomEquipment() {
        Equipments[] items = Equipments.values();
        int idx = new Random().nextInt(items.length);
        return items[idx].create();
    }
}
