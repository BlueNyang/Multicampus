package com.mc.c_templatemethod;

import com.mc.c_templatemethod.character.*;
import com.mc.c_templatemethod.character.Character;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Character player = new Player("Hero", 200, 30, 10);
        Character warrior = new Warrior("Warrior", 3400, 500, 10);
        Character thief = new Thief("Thief", 1800, 600, 10);
        Character monster = new Monter("Boss Slime", 2000, 50, 10);

        try (Scanner sc = new Scanner(System.in)) {
            Character p1 = warrior;
            Character p2 = thief;

            System.out.println("Battle Entered! - " + p1.getName() + " vs " + p2.getName());
            System.out.println("-------------------------");
            while (true) {
                System.out.println("Press Enter to attack...");
                sc.nextLine();

                p1.attack(p2);
                if (p2.isDead()) {
                    System.out.println("[" + p1.getName() + " WIN]");
                    break;
                }

                p2.attack(p1);
                if (p1.isDead()) {
                    System.out.println("[" + p2.getName() + " WIN]");
                    break;
                }

                System.out.println("-------------------------");
                System.out.println("[" + p1.getName() + "] HP: " + Math.max(p1.getCurrentHp(), 0) + "/" + p1.getHp());
                System.out.println("[" + p2.getName() + "] HP: " + Math.max(p2.getCurrentHp(), 0) + "/" + p2.getHp());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
