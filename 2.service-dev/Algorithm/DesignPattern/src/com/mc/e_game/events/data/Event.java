package com.mc.e_game.events.data;

import com.mc.e_game.characters.Player;
import com.mc.e_game.events.EventResult;

public interface Event {
    EventResult startEvent(Player player);
}
