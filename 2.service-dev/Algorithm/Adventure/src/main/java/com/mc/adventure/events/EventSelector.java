package com.mc.adventure.events;

import com.mc.adventure.events.data.Event;
import com.mc.adventure.events.data.EventType;

import java.util.Random;

public class EventSelector {
    public EventSelector() {
    }

    public Event getFinalEvent() {
        return EventType.FIGHT_ENEMY.create();
    }

    public Event getNewRandomEvent() {
        EventType[] types = EventType.values();
        int idx = new Random().nextInt(types.length);
        return types[idx].create();
    }
}
