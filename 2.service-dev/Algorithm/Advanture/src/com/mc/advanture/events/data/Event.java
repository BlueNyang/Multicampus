package com.mc.advanture.events.data;

import com.mc.advanture.characters.Player;
import com.mc.advanture.events.EventResult;

public interface Event {
    EventResult startEvent(Player player);
}
