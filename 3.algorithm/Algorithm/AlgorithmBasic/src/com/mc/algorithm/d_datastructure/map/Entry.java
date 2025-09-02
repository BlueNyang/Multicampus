package com.mc.algorithm.d_datastructure.map;

import java.util.Objects;

public class Entry<K, V> {
    private K key;
    private V value;
    private Entry<K, V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Entry<K, V> other = (Entry<K, V>) obj;
        return Objects.equals(key, other.key);
    }

    @Override
    public String toString() {
        return "Entry {" + key + ", " + value + '}';
    }
}
