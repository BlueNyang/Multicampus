package com.mc.advanture.events;

import com.mc.advanture.characters.Player;
import com.mc.advanture.events.data.Event;
import com.mc.advanture.items.Equipment;
import com.mc.advanture.items.data.Equipments;
import com.mc.advanture.utils.ScanInput;

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
        System.out.println("[Event] Treasure(x"+ count +")Found: " + this.desc);
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
