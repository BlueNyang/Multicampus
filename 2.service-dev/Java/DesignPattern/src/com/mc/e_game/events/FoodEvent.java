package com.mc.e_game.events;

import com.mc.e_game.characters.Player;
import com.mc.e_game.events.data.Event;
import com.mc.e_game.items.Food;
import com.mc.e_game.items.data.Foods;
import com.mc.e_game.utils.ScanInput;

import java.util.Random;

public class FoodEvent implements Event {
    private final String desc;

    public FoodEvent(String desc) {
        this.desc = desc;
    }

    @Override
    public EventResult startEvent(Player player) {
        System.out.println("[Event] You found some food: " + this.desc);
        Food food = getRandomFood();
        System.out.println("[Event] You found a " + food.getName() + "(x" + food.getStock() + ")");

        eatOrStore(player, food);

        return EventResult.SUCCESS;
    }

    private Food getRandomFood() {
        Foods[] items = Foods.values();
        int idx = new Random().nextInt(items.length);
        Food food = items[idx].create();
        food.addStock(new Random().nextInt(2));
        return food;
    }

    private void eatOrStore(Player player, Food food) {
        System.out.print("[Event] Do you want to (1) Eat(x1) or (2) Store in inventory? ");
        int choice = ScanInput.getInstance().scanInt();
        if (choice == 1) {
            System.out.println("[System] You chose to eat the food.");
            player.heal(food.getHpRestore());
            food.addStock(-1);
            System.out.println("[System] You restored " + food.getHpRestore() + " HP.");
            System.out.println("[System] Current HP: " + player.getCurrentHp() + "/" + player.getHp());
        } else {
            System.out.println("[System] You chose to store the food in your inventory.");
        }
        player.addFoodToInventory(food);
    }
}
