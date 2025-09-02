package com.mc.algorithm.a_ot;

public class Run {
    public static void main(String[] args) {
        int a = 11;
        int b = 16;

        a = a ^ b; // a = 11 ^ 16 => 01011 ^ 10000 => 11011 (27 in decimal)
        b = a ^ b; // b = (11 ^ 16) ^ 16 => 11011 ^ 10000 => 01011 (11 in decimal)
        a = b ^ a; // a = 11 ^ (11 ^ 16) => 01011 ^ 11011 => 10000 (16 in decimal)
    }
}
