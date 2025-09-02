package com.mc.adventure.events;

import com.mc.adventure.characters.Player;
import com.mc.adventure.events.data.Event;
import com.mc.adventure.items.Food;
import com.mc.adventure.items.data.Foods;
import com.mc.adventure.utils.ScanInput;

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

        return eatOrStore(player, food);
    }

    private Food getRandomFood() {
        Foods[] items = Foods.values();
        int idx = new Random().nextInt(items.length);
        Food food = items[idx].create();
        food.addStock(new Random().nextInt(2));
        return food;
    }

    private EventResult eatOrStore(Player player, Food food) {
        System.out.println("[Event] Choose an action: ");
        System.out.println("1. Eat the food(x1) and store the rest");
        System.out.println("2. Store the food in inventory");
        System.out.println("3. Exit game");
        System.out.print("Enter your choice (1-3): ");

        return switch (ScanInput.getInstance().scanInt()) {
            case 1 -> EatOneAndStoreRest(player, food);
            case 2 -> {
                System.out.println("[System] You chose to store the food in your inventory.");
                player.addFoodToInventory(food);
                yield EventResult.SUCCESS;
            }
            case 3 -> {
                System.out.println("[System] You chose to exit the game. Goodbye!");
                yield EventResult.EXIT;
            }
            default -> {
                System.out.println("[System] Invalid choice. Adding food to inventory by default.");
                player.addFoodToInventory(food);
                yield EventResult.SUCCESS;
            }
        };
    }

    private EventResult EatOneAndStoreRest(Player player, Food food) {
        System.out.println("[System] You chose to eat the food.");
        player.heal(food.getHpRestore());
        food.addStock(-1);
        System.out.println("[System] You restored " + food.getHpRestore() + " HP.");
        System.out.println("[System] Current HP: " + player.getCurrentHp() + "/" + player.getHp());
        player.addFoodToInventory(food);
        return EventResult.SUCCESS;
    }
}
