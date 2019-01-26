package com.questions.java.stack;

import java.util.Arrays;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyStack<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    //private Object elements[];
    private E elements[];

    // The elements array will contain only E instances from push(E).
    // This is sufficient to ensure type safety, but the runtime
    // type of the array won't be E[]; it will always be Object[]!
    //@SuppressWarnings("unchecked")
    public MyStack() {
        //elements = new Object[DEFAULT_CAPACITY];
        elements = (E[])new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    public E pop() {
        E e = (E) elements[--size];
        elements[size] = null;
        return e;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
