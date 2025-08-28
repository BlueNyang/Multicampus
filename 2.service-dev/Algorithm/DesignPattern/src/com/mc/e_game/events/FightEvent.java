package com.mc.e_game.events;

import com.mc.e_game.characters.Character;
import com.mc.e_game.characters.Player;
import com.mc.e_game.characters.data.Monsters;
import com.mc.e_game.events.data.Event;
import com.mc.e_game.items.Food;
import com.mc.e_game.utils.ScanInput;

import java.util.Collection;
import java.util.Random;

public class FightEvent implements Event {
    String desc;

    public FightEvent(String desc) {
        this.desc = desc;
    }

    @Override
    public EventResult startEvent(Player player) {
        System.out.println("[Event] Fight Event Started: " + this.desc);
        Character monster = this.getRandomMonster(player);

        System.out.println("[Event] " + player.getName() + " is fighting " + monster.getName());

        while (true) {
            System.out.println("-----------------------------------");
            EventResult res = action(player, monster);
            System.out.println(player.getName() + " HP: " + player.getCurrentHp() + "/" + player.getHp());
            System.out.println(monster.getName() + " HP: " + monster.getCurrentHp() + "/" + monster.getHp());

            if (res == EventResult.SUCCESS) {
                System.out.println("[Event] " + player.getName() + " won against " + monster.getName());
                player.expUp(monster.getLevel() * 80);
                return EventResult.SUCCESS;
            } else if (res == EventResult.FAILED) {
                System.out.println("[Event] " + player.getName() + " was defeated by " + monster.getName());
                return EventResult.FAILED;
            }
        }
    }

    private Character getRandomMonster(Player player) {
        int level = player.getLevel();
        Monsters[] monsters = Monsters.values();
        int idx = new Random().nextInt(level, Math.min(level + 1, monsters.length));
        return monsters[idx].create();
    }

    private EventResult fight(Player player, Character monster) {
        player.attack(monster);
        if (monster.isAlive()) {
            monster.attack(player);
        }

        if (player.isDead()) {
            return EventResult.FAILED;
        }

        if (monster.isDead()) {
            return EventResult.SUCCESS;
        }

        return EventResult.ONGOING;
    }

    private void useFood(Player player) {
        Collection<Food> foods = player.getAllFoods();
        if (foods.isEmpty()) {
            System.out.println("[System] No food available.");
            return;
        }

        System.out.println("[System] Choose a food to use:");
        for (int i = 0; i < foods.size(); i++) {
            Food food = (Food) foods.toArray()[i];
            System.out.println((i + 1) + ". " + food.getName() + " (Heals " + food.getHpRestore() + " HP)");
        }
        System.out.print("Enter your choice: ");
        int choice = ScanInput.getInstance().scanInt();
        if (choice < 1 || choice > foods.size()) {
            System.out.println("[System] Invalid choice.");
        }

        Food selectedFood = (Food) foods.toArray()[choice - 1];
        player.useFood(selectedFood);
        return;
    }

    private EventResult action(Player player, Character monster) {
        System.out.println("[Fight] Choose an action:");
        System.out.println("1. Attack");
        System.out.println("2. Use Food");
        System.out.print("Enter your choice: ");
        int choice = ScanInput.getInstance().scanInt();

        return switch (choice) {
            case 1 -> fight(player, monster);
            case 2 -> {
                useFood(player);
                yield EventResult.ONGOING;
            }
            default -> {
                System.out.println("[System] Invalid choice.");
                yield EventResult.ONGOING;
            }
        };
    }
}
