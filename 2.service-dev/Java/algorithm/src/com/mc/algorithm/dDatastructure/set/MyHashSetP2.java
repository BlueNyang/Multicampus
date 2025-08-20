package com.mc.algorithm.dDatastructure.set;

import com.mc.algorithm.dDatastructure.list.Node;

import java.util.Arrays;
import java.util.Iterator;

public class MyHashSetP2<E> implements Iterable<E> {
    private int arraySize = 6;
    private Object[] table;
    private int size = 0;

    public MyHashSetP2() {
        this.table = new Object[this.arraySize];
    }

    public MyHashSetP2(int initialCapacity) {
        this.table = new Object[initialCapacity];
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
        Node<E> node = new Node<>(e);
        int index = hash(e);

        if (this.table[index] == null) {
            this.table[index] = node;
            this.size++;
            return true;
        }

        Node<E> link = (Node<E>) this.table[index];
        while (link.getNext() != null) {
            if (link.getData().equals(e))
                return false;
            link = link.getNext();
        }

        if (link.getData().equals(e))
            return false;

        link.setNext(node);
        this.size++;
        return true;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        this.arraySize *= 2;
        Object[] oldTable = this.table;
        this.table = new Object[this.arraySize];
        this.size = 0;

        for (E e : (E[]) oldTable) {
            if (e != null) {
                Node<E> current = (Node<E>) e;
                while (current != null) {
                    addNode(current.getData());
                    current = current.getNext();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public boolean remove(E e) {
        int index = this.hash(e);
        Node<E> current = (Node<E>) this.table[index];
        if (current == null) {
            return false;
        }

        if (current.getData().equals(e)) {
            // If the first node is the one to be removed
            this.table[index] = current.getNext(); // Link to the next node
            this.size--;
            return true;
        }

        while (current != null) {
            if (current.getData().equals(e)) {
                Node<E> previous = (Node<E>) this.table[index];
                while (previous.getNext() != current) {
                    previous = previous.getNext();
                }
                previous.setNext(current.getNext()); // Bypass the current node
                this.size--;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyHashSetP2 { \n");
        for (int i = 0; i < this.arraySize; i++) {
            sb.append("  [");
            if (this.table[i] != null) {
                Node<E> current = (Node<E>) this.table[i];
                while (current != null) {
                    sb.append(current.getData());
                    if (current.getNext() != null) {
                        sb.append(", ");
                    }
                    current = current.getNext();
                }
            } else {
                sb.append("null");
            }
            sb.append("],\n");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("}");
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int index = 0;
            private Node<E> pointer = null;

            @Override
            public boolean hasNext() {
                if (pointer == null) {
                    while (index < arraySize) {
                        if (table[index] != null) {
                            pointer = (Node<E>) table[index];
                            return true;
                        }
                        index++;
                    }
                    return false;
                }

                if (pointer.getNext() != null) {
                    return true;
                }

                int tempIndex = index;
                while (++tempIndex < arraySize) {
                    if (table[tempIndex] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public E next() {
                if (pointer == null || pointer.getNext() == null) {
                    while (index < arraySize && (table[index] == null || ((Node<E>) table[index]).getNext() == null)) {
                        index++;
                    }
                    pointer = (Node<E>) table[index];
                } else {
                    pointer = pointer.getNext();
                }
                return pointer.getData();
            }
        };
    }
}
