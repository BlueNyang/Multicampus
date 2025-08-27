package com.mc.e_game.utils;

import java.util.Scanner;

public class ScanInput implements AutoCloseable {
    private final Scanner sc;
    private static ScanInput instance;

    private ScanInput() {
        sc = new Scanner(System.in);
    }

    public static ScanInput getInstance() {
        if (instance == null) {
            instance = new ScanInput();
        }
        return instance;
    }

    public Scanner scanner() {
        return sc;
    }

    public boolean scanYesOrNo() {
        String input = sc.nextLine().trim().toLowerCase();
        while (true) {
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.print("[System] Invalid input. Please enter 'yes' or 'no':");
            }
        }
    }

    public int scanInt() {
        while (true) {
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("[System] Invalid input. Please enter a valid integer:");
            }
        }
    }

    @Override
    public void close() {
        sc.close();
    }
}
