package com.mc.algorithm.d_datastructure.list;

import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            size++;
            return true;
        }

        Node<E> link = head;
        while (link.getNext() != null) {
            link = link.getNext();
        }

        link.setNext(newNode);
        size++;

        return true;
    }


    public E get(int index) {
        this.rangeCheck(index);

        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.getNext();
        }
        return link.getData();
    }

    public E set(int index, E element) {
        this.rangeCheck(index);

        Node<E> link = head;
        for (int i = 0; i < index; i++) {
            link = link.getNext();
        }
        E oldValue = link.getData();
        link.setData(element);

        return oldValue;
    }

    public E remove(int index) {
        this.rangeCheck(index);

        Node<E> link = head;
        if (index == 0) {
            E oldValue = head.getData();
            head = head.getNext();
            size--;
            return oldValue;
        }

        Node<E> prev = null;
        for (int i = 0; i < index; i++) {
            prev = link;
            link = link.getNext();
        }

        E oldValue = link.getData();
        if (prev == null) {
            head = link.getNext();
        } else {
            prev.setNext(link.getNext());
        }
        size--;

        return oldValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyLinkedList<> [");

        Node<E> current = head;
        while (current != null) {
            sb.append(current.getData());
            current = current.getNext();
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // iterator
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    // contains
    public boolean contains(Object element) {
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    // IndexOf
    public int indexOf(Object element) {
        Node<E> current = head;
        int index = 0;

        while (current != null) {
            if (current.getData().equals(element)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return -1; // Not found
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
