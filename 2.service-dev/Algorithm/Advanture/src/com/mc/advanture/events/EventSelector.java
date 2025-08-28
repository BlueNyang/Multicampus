package com.mc.advanture.events;

import com.mc.advanture.events.data.Event;
import com.mc.advanture.events.data.EventType;

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
