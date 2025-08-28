package com.mc.algorithm.d_datastructure.map;

import com.mc.algorithm.d_datastructure.list.MyLinkedList;
import com.mc.algorithm.d_datastructure.set.MyHashSetP3;

public class MyHashMap<K, V> {
    private int size = 0;
    private Object[] table;
    private int arraySize = 10;
    private final MyHashSetP3<Entry<K, V>> entrySet = new MyHashSetP3<>();

    public MyHashMap() {
        this.table = new Object[arraySize];
    }

    public MyHashMap(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than zero.");
        }

        this.arraySize = initialCapacity;
        this.table = new Object[arraySize];
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

    @SuppressWarnings("unchecked")
    private V addEntry(Entry<K, V> e) {
        int index = hash(e);

        if (this.table[index] == null) {
            this.table[index] = new MyLinkedList<Entry<K, V>>();
        }

        MyLinkedList<Entry<K, V>> row = (MyLinkedList<Entry<K, V>>) this.table[index];

        Entry<K, V> prev = null;
        if (row.contains(e)) {
            prev = row.remove(row.indexOf(e));
            entrySet.remove(prev);
        }

        // Add the new element to the linked list at this index
        row.add(e);
        entrySet.add(e);
        this.table[index] = row;
        this.size++;

        return prev == null ? null : prev.getValue();
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        this.arraySize *= 2;
        Object[] oldTable = this.table;
        this.table = new MyLinkedList[this.arraySize];
        this.size = 0;

        for (MyLinkedList<Entry<K, V>> list : (MyLinkedList<Entry<K, V>>[]) oldTable) {
            if (list == null) continue;
            for (Entry<K, V> e : list) {
                if (e == null) continue;
                addEntry(e);
            }
        }
    }

    public V put(K key, V value) {
        checkKey(key);

        Entry<K, V> entry = new Entry<>(key, value);
        if (this.size == this.arraySize) {
            resize();
        }

        return addEntry(entry);
    }

    @SuppressWarnings("unchecked")
    public V get(Object key) {
        checkKey(key);

        int index = hash(new Entry<>(key, null));

        MyLinkedList<Entry<K, V>> row = (MyLinkedList<Entry<K, V>>) this.table[index];
        if (row == null) return null;

        int idx = row.indexOf(new Entry<>((K) key, null));
        return idx != -1 ? row.get(idx).getValue() : null;
    }

    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        checkKey(key);

        int index = hash(new Entry<>(key, null));

        MyLinkedList<Entry<K, V>> row = (MyLinkedList<Entry<K, V>>) this.table[index];
        if (row == null) return null;

        int idx = row.indexOf(new Entry<>((K) key, null));
        V prev = idx != -1 ? row.remove(idx).getValue() : null;

        entrySet.remove(new Entry<>((K) key, prev));

        if (row.isEmpty()) {
            this.table[index] = null; // Remove empty row
        }

        return prev;
    }

    private void checkKey(Object key) {
        if (key == null) {
            throw new IllegalArgumentException("Key must not be null.");
        }
    }

    public MyHashSetP3<Entry<K, V>> getEntrySet() {
        return entrySet;
    }

    @SuppressWarnings("unchecked")
    public boolean containsKey(Object key) {
        checkKey(key);

        int index = hash(new Entry<>(key, null));
        MyLinkedList<Entry<K, V>> row = (MyLinkedList<Entry<K, V>>) this.table[index];

        return row != null && row.contains(new Entry<>((K) key, null));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyHashMap {\n");
        for (int i = 0; i < this.arraySize; i++) {
            sb.append("  Index ").append(i).append(": ");
            if (this.table[i] != null) {
                sb.append(this.table[i].toString());
            } else {
                sb.append("[null]");
            }
            sb.append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }
}
