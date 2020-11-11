package com.sagax.javaprocamp2020.task1;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class CustomArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
    private int size;

    private Object[] listElements;

    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList(int capacity) {
        this.listElements = new Object[capacity];
    }

    public CustomArrayList() {
        this.listElements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(E element) {
        if(size == this.listElements.length) {
            changeCapacity(size * 2);
        }
        this.listElements[size] = element;
        size++;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index is greater than size of ArrayList!!! \n "
                    + " Index : " + index + " Size : " + size);
        }

        E value = (E) this.listElements[index];
        System.arraycopy(this.listElements, index + 1, this.listElements, index, size - index - 1);
        size--;
        this.listElements[size] = null;

        if(size <= (this.listElements.length / 4)) {
            changeCapacity(this.listElements.length / 2);
        }
        return value;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index is greater than size of ArrayList!!! \n "
                    + " Index : " + index + " Size : " + size);
        }
        return (E) this.listElements[index];
    }

    private void changeCapacity(int capacity) {
        this.listElements = Arrays.copyOf(listElements, capacity);
    }

}
