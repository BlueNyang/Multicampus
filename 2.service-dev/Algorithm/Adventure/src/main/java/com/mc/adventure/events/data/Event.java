package com.mc.adventure.events.data;

import com.mc.adventure.characters.Player;
import com.mc.adventure.events.EventResult;

public interface Event {
    EventResult startEvent(Player player);
}
