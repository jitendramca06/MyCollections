package com.questions.java.queue;

import java.util.Arrays;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyQueue<E> {
    private int currentSize = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E elements[];
    private int front = 0;
    private int rear = -1;

    public MyQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void enQueue(E value) {
        if (isFull()) {
            System.out.println("Queue is full!! Can not add more elements");
        } else {
            if(front == DEFAULT_CAPACITY-1 && currentSize != elements.length){
                front = 0;
            }
            elements[front] = value;
            front++;
            currentSize++;
            System.out.println(value + " added to the queue");
        }
    }

    public E deQueue() {
        E value = null;
        if (isEmpty()) {
            System.out.println("Queue is empty!! Can not dequeue element");
        } else {
            rear++;
            if(rear == DEFAULT_CAPACITY-1 && currentSize != elements.length){
                value = (E) elements[rear];
                rear = 0;
            } else {
                value = (E) elements[rear];
            }
            currentSize--;
        }
        return value;
    }

    public boolean isEmpty(){
        if (currentSize == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (currentSize == DEFAULT_CAPACITY){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Queue [front=" + front + ", rear=" + rear + ", size=" + currentSize
                + ", queue=" + Arrays.toString(elements) + "]";
    }
}
