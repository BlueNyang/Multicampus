package com.mc.algorithm.d_datastructure.set;

import java.util.Arrays;

public class MyHashSetP1<E extends Comparable<E>> {
    private Object[] table;
    private int arraySize = 6;
    int size = 0;

    public MyHashSetP1() {
        this.table = new Object[arraySize];
    }

    public MyHashSetP1(int initialCapacity) {
        this.table = new Object[initialCapacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int hash(Object e) {
        int hashCode = Math.abs(e.hashCode());
        return hashCode % arraySize;
    }

    public boolean add(E e) {
        if (size == arraySize) {
            resize();
        }

        int index = hash(e);
        if (table[index] != null) return false;

        table[index] = e;
        size++;
        return true;
    }

    public boolean remove(Object e) {
        int index = hash(e);
        if (table[index] == null) return false;
        table[index] = null;
        size--;
        return true;
    }

    private void resize() {
        arraySize *= 2;
        Object[] newTable = new Object[arraySize];
        for (Object obj : table) {
            if (obj == null) continue;
            int newIndex = hash(obj);
            newTable[newIndex] = obj;
        }
        table = newTable;
    }

    @Override
    public String toString() {
        return "MyHashSetP1 " + Arrays.toString(table);
    }
}
