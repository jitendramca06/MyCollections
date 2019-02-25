package com.questions.java.customeiterator;

import java.util.Iterator;

/**
 * @author Jitendra Kumar : 23/2/19
 *
 * Modify existing iterator so that it can print every alternative element
 */
public class SkipEverySecondElement<T> implements Iterator<T> {

    private Iterator<T> iterator;
    private int size;
    private int currentSize;

    public SkipEverySecondElement(Iterator<T> iterator, int size, int currentSize) {
        this.iterator = iterator;
        this.size = size;
        this.currentSize = currentSize;
    }

    @Override
    public boolean hasNext() {
        return currentSize < size;
    }

    @Override
    public T next() {
        if (currentSize == 0) {
            currentSize = currentSize + 1;
            return iterator.next();
        }
        else {
            if (hasNext()) {
                currentSize = currentSize + 1;
                iterator.next();
            }
            if (hasNext()) {
                currentSize = currentSize + 1;
                return iterator.next();
            }
        }
        return null;
    }
}
