package com.mc.algorithm.dDatastructure;

public class Run {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        init(list);

        testGet(list);
        testRemove(list);
        testSet(list);
        testForEach(list);
    }

    private static void init(MyArrayList<Integer> list) {
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

    private static void testGet(MyArrayList<Integer> list) {
        for (int i = 5; i < 8; i++) {
            System.out.println("Index: " + i + ", Value: " + list.get(i));
        }
    }

    private static void testSet(MyArrayList<Integer> list) {
        System.out.println("previous value = " + list.set(0, 10));
        System.out.println("List after set: " + list);
    }

    private static void testRemove(MyArrayList<Integer> list) {
        for (int i = 7; i > 4; i--) {
            System.out.println("Removing index: " + i + ", Value: " + list.remove(i));
        }
        System.out.println("List after removals: " + list);
    }

    private static void testForEach(MyArrayList<Integer> list) {
        System.out.println("Iterating using forEach:");
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }

        System.out.println("Sum of elements: " + sum);
    }
}
