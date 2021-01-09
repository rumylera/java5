package com.rumylera.list;

import java.util.*;

public class CustomList implements List{
    Object[] data;
    int capacity;    // maximum capacity of the list
    int sz;          // current size of the list
    static final int DEFAULT_CAPACITY = 10;

    public boolean isEmpty() {
        return sz == 0;
    }
    public CustomList() {
        this(DEFAULT_CAPACITY);
    }
    public CustomList(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        sz = 0;
    }

    public void add(Object o){
                                 //add element at the end of list
        if (sz >= capacity) {
            throw new CapacityExceeded("list capacity exceeded");
        }
        data[sz] = o;
        sz++;
    }
    public void add(int index, Object o) {
                                            //add element at given place
        if (index < 0) {
            throw new IndexOutOfBoundsException("!Negative Index!");
        }
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("Try less, index out of upper bound");
        }
        if(index <= sz){
            System.arraycopy(data, index, data, index + 1, sz - index);

            data[index] = o;
            sz++;
        }
        else{
            throw new RuntimeException("Index Error");
        }


    }
    public Object get(int index) {
                                                   // find the element at given index
        if (index < 0 || index >= sz) {
            throw new RuntimeException("Index out of bounds");
        }
        return data[index];
    }

    public Object remove(int index) {
                                                    //delete element at give index
    }
        if (index >= sz || index < 0) {
            throw new NoSuchElementException("No such index");
        }
        Object object = data[index];
        for (int j = index; j < sz - 1; j++) {
            data[j] = data[j + 1];
        }
        sz--;
        return object;
    }

    public boolean contains(Object o) {
                                      //check if there's such element
        for (int i = 0; i < sz; i++) {
            if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }