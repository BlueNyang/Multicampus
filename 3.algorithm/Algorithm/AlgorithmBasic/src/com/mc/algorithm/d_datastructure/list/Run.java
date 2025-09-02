package com.mc.algorithm.d_datastructure.list;

import com.mc.algorithm.d_datastructure.dto.School;

import java.util.ArrayList;
import java.util.Collections;

public class Run {
    public static void main(String[] args) {
        testGet();
        testRemove();
        testSet();
        testForEach();
//        testSort();
    }

    private static void testSort() {
        School seoulUniv = new School("Seoul University", "Gwanak-gu", "University");
        School yonsei = new School("Yonsei University", "Seoul", "University");
        School minsa = new School("Minsa High School", "Daejeon", "High School");
        School multicampus = new School("Multicampus", "Yeoksam", "Academy");

        ArrayList<School> schools = new ArrayList<>();
        schools.add(seoulUniv);
        schools.add(yonsei);
        schools.add(minsa);
        schools.add(multicampus);

        System.out.println("Before sorting: " + schools);
//        Collections.sort(schools);
        Collections.sort(schools,
                (s1, s2) ->
                        s1.getType().compareTo(s2.getType()) == 0 ?
                                -s1.getName().compareTo(s2.getName()) :
                                s1.getType().compareTo(s2.getType())
        );
        System.out.println("After sorting: " + schools);
    }

    private static void init(MyLinkedList<Integer> list) {
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
    }

    private static void testGet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        init(list);

        for (int i = 5; i < 8; i++) {
            System.out.println("Index: " + i + ", Value: " + list.get(i));
        }
    }

    private static void testSet() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        init(list);

        System.out.println("previous value = " + list.set(0, 10));
        System.out.println("List after set: " + list);
    }

    private static void testRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        init(list);

        for (int i = 7; i > 4; i--) {
            System.out.println("Removing index: " + i + ", Value: " + list.remove(i));
        }
        System.out.println("List after removals: " + list);
    }

    private static void testForEach() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        init(list);

        System.out.println("Iterating using forEach:");
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }

        System.out.println("Sum of elements: " + sum);
    }
}
