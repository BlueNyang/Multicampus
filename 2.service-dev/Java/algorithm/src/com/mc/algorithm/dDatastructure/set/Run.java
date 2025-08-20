package com.mc.algorithm.dDatastructure.set;

import com.mc.algorithm.dDatastructure.dto.School;

public class Run {
    public static void main(String[] args) {
//        testMyHashSetP1();
        testMyHashSetP2();
    }

    private static void testMyHashSetP1() {
        School seoulUniv = new School("Seoul University", "Gwanak-gu", "University");
        School yonseiUniv = new School("Yonsei University", "Seoul", "University");
        School minsa = new School("Minsa High School", "Daejeon", "High School");
        School multicampus = new School("Multicampus", "Yeoksam", "Academy");
        School wonkwangUniv = new School("Wonkwang University", "Iksan", "University");

        MyHashSetP1<School> set = new MyHashSetP1<>();
        set.add(seoulUniv);
        set.add(yonseiUniv);
        set.add(minsa);
        set.add(multicampus);
        set.add(wonkwangUniv);

        System.out.println(set);
        System.out.println("Size: " + set.size());

        set.remove(new School("Seoul University", "Gwanak-gu", "University"));
        System.out.println("After removing Seoul University:");
        System.out.println(set);
        System.out.println("Size: " + set.size());
    }

    private static void testMyHashSetP2() {
        School seoulUniv = new School("Seoul University", "Gwanak-gu", "University");
        School yonseiUniv = new School("Yonsei University", "Seoul", "University");
        School minsa = new School("Minsa High School", "Daejeon", "High School");
        School multicampus = new School("Multicampus", "Yeoksam", "Academy");
        School wonkwangUniv = new School("Wonkwang University", "Iksan", "University");

        MyHashSetP2<School> set = new MyHashSetP2<>();
        set.add(seoulUniv);
        set.add(yonseiUniv);
        set.add(minsa);
        set.add(multicampus);
        set.add(wonkwangUniv);

        System.out.println(set);
        System.out.println("Size: " + set.size());

        set.remove(new School("Seoul University", "Gwanak-gu", "University"));
        System.out.println("After removing Seoul University:");
        System.out.println(set);
        System.out.println("Size: " + set.size());
    }
}
