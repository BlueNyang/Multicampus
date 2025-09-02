package com.mc.algorithm.d_datastructure.stack;

import com.mc.algorithm.d_datastructure.list.Node;

import java.util.EmptyStackException;

public class MyStack<E> {
    private Node<E> top;
    private int size;

    public E push(E e) {
        Node<E> newNode = new Node<>(e);

        if (top != null) newNode.setNext(top);

        top = newNode;
        size++;
        return e;
    }

    public E peek() {
        if (size == 0) throw new EmptyStackException();
        if (top == null) return null;
        return top.getData();
    }

    public E pop() {
        if (size == 0) throw new EmptyStackException();

        E data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int search(Object o) {
        if (size == 0) return -1;
        Node<E> pointer = top;

        int index = 0;
        while (pointer != null) {
            if (pointer.getData().equals(o)) {
                return index;
            }
            pointer = pointer.getNext();
            index++;
        }

        return -1; // Element not found
    }
}
