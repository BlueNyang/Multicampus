package com.mc.algorithm.d_datastructure.Queue;

import com.mc.algorithm.d_datastructure.list.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueue<E> implements Iterable<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size = 0;
    private final int maxSize;

    public MyQueue() {
        this(10); // Default size
    }

    public MyQueue(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }

        this.maxSize = maxSize;
    }

    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return front.getData();
    }

    public boolean add(E e) {
        if (size >= maxSize) {
            throw new IllegalStateException();
        }

        Node<E> newNode = new Node<>(e);
        if (rear != null) {
            rear.setNext(newNode);
        }
        rear = newNode;

        if (front == null) {
            front = newNode;
        }

        size++;
        return true;
    }

    public boolean offer(E e) {
        if (size >= maxSize) {
            return false;
        }

        Node<E> newNode = new Node<>(e);
        if (rear != null) {
            rear.setNext(newNode);
        }
        rear = newNode;

        if (front == null) {
            front = newNode;
        }

        size++;
        return true;
    }

    public E peek() {
        if (size == 0) return null;
        return front.getData();
    }

    public E poll() {
        if (size == 0) return null;

        E data = front.getData();
        front = front.getNext();
        size--;

        if (size == 0) {
            rear = null;
        }

        return data;
    }

    public E remove() {
        if (size == 0) throw new NoSuchElementException();

        E data = front.getData();
        front = front.getNext();
        size--;

        if (size == 0) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                E data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
