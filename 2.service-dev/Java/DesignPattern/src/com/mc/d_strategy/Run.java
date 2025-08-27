package com.mc.d_strategy;

import com.mc.d_strategy.character.Monster;
import com.mc.d_strategy.character.Player;
import com.mc.d_strategy.items.Equipment;
import com.mc.d_strategy.items.Slot;
import com.mc.d_strategy.items.code.EquipmentData;

import java.util.Random;
import java.util.Scanner;

// Strategy Pattern: when need to reuse the code.
// Using Interface and Composing classes.
public class Run {
    public static void main(String[] args) {
        Player player = new Player("Hero", 200, 30, 10);
        Monster monster = new Monster("Slime", 200, 30, 10);

        try (Scanner sc = new Scanner(System.in)) {
            boolean eventFlag = true;
            while (true) {
                System.out.print("=========================");
                sc.nextLine();

                if (player.getCurrentHp() < 150) {
                    EquipmentData[] equipments = EquipmentData.values();
                    int idx = new Random().nextInt(equipments.length);

                    if (eventFlag) {
                        // 전략을 생성
                        // 전략을 주입, Dependency Injection, Inversion of Control
                        EquipmentData e = equipments[idx];
                        System.out.println("[Event] Found " + e.name());
                        player.equip(e);
                        eventFlag = false;
                    }
                }

                player.attack(monster);
                if (monster.isDead()) {
                    System.out.println("[Result] WIN");
                    break;
                }

                monster.attack(player);
                if (player.isDead()) {
                    System.out.println("[Result] LOSE");
                    break;
                }

                System.out.println("=========================");
                System.out.println("Player HP: " + player.getCurrentHp() + "/" + player.getHp());
                System.out.println("Monster HP: " + monster.getCurrentHp() + "/" + monster.getHp());
            }
        }
    }
}
