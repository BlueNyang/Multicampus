package com.mc.algorithm.dDatastructure;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    Object[] elementsData;

    private int CAPACITY = 10;
    private int size;

    public MyArrayList() {
        this.elementsData = new Object[CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean add(E element) {
        if (size >= elementsData.length - 1) {
            int newCapacity = elementsData.length + (elementsData.length >> 1);
            elementsData = Arrays.copyOf(elementsData, newCapacity);
        }

        elementsData[size++] = element;

        return true; // Placeholder return value
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elementsData[index];
    }

    public E set(int index, E element) {
        this.rangeCheck(index);

        E oldValue = get(index);
        elementsData[index] = element;

        return oldValue;
    }

    public E remove(int index) {
        this.rangeCheck(index);

        E oldValue = get(index);
        while (index++ < size - 1)
            elementsData[index] = elementsData[index + 1];

        elementsData[--size] = null; // Clear the last element
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("MyArrayList<> [");
        for (int i = 0; i < size; i++) {
            sb.append(elementsData[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("No more elements to iterate.");
                }
                return (E) elementsData[currentIndex++];
            }

            @Override
            public void remove() {
                MyArrayList.this.remove(currentIndex);
            }
        };
    }
}
