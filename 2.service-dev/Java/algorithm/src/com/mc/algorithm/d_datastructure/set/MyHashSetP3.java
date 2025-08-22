package com.mc.algorithm.d_datastructure.set;

import com.mc.algorithm.d_datastructure.list.MyLinkedList;

import java.util.Iterator;

public class MyHashSetP3<E> implements Iterable<E> {
    private int arraySize = 6;
    private Object[] table;
    private int size = 0;

    public MyHashSetP3() {
        this.table = new MyLinkedList[this.arraySize];
    }

    public MyHashSetP3(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero.");
        }
        this.arraySize = initialCapacity;
        this.table = new MyLinkedList[this.arraySize];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private int hash(Object e) {
        int hashCode = Math.abs(e.hashCode());
        return hashCode % this.arraySize;
    }

    public boolean add(E e) {
        if (this.size == this.arraySize) {
            resize();
        }

        return addNode(e);
    }

    @SuppressWarnings("unchecked")
    private boolean addNode(E e) {
        int index = hash(e);

        if (this.table[index] == null) {
            this.table[index] = new MyLinkedList<E>();
        }

        MyLinkedList<E> row = (MyLinkedList<E>) this.table[index];

        if (row.contains(e)) {
            return false; // Element already exists
        }

        // Add the new element to the linked list at this index
        row.add(e);
        this.table[index] = row;
        this.size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        this.arraySize *= 2;
        Object[] oldTable = this.table;
        this.table = new MyLinkedList[this.arraySize];
        this.size = 0;

        for (MyLinkedList<E> list : (MyLinkedList<E>[]) oldTable) {
            if (list == null) continue;
            for (E e : list) {
                if (e == null) continue;
                addNode(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object e) {
        int index = hash(e);
        if (this.table[index] == null) return false;

        MyLinkedList<E> list = (MyLinkedList<E>) this.table[index];
        if (!list.contains(e)) return false;

        list.remove(list.indexOf(e));
        this.size--;
        if (list.isEmpty()) {
            this.table[index] = null; // Clear the slot if the list is empty
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("MyHashSetP3 {\n");
        for (MyLinkedList<E> row : (MyLinkedList<E>[]) this.table) {
            sb.append("  ");
            if (row != null) {
                sb.append(row).append(",\n");
            } else {
                sb.append("[null],\n");
            }
        }
        sb.append("}\n");

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private int rowIndex = -1;
            private Iterator<E> pointer = null;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (index >= size) return null;

                while (pointer == null || !pointer.hasNext()) {
                    rowIndex++;
                    if (table[rowIndex] != null) {
                        pointer = ((MyLinkedList<E>) table[rowIndex]).iterator();
                    } else {
                        pointer = null;
                    }
                }

                E current = pointer.next();
                index++;

                return current;
            }
        };
    }
}
