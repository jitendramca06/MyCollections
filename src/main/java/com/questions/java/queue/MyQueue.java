package com.questions.java.queue;

import java.util.Arrays;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyQueue<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    private int front = 0;
    private int rear = -1;

    public MyQueue() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void enQueue(E value) {
        if (isFull()) {
            System.out.println("Queue is full!! Can not add more elements");
        } else {
            if(front == DEFAULT_CAPACITY-1){
                front = 0;
            }
            elements[front] = value;
            front++;
            size++;
            System.out.println(value + " added to the queue");
        }
    }

    public E deQueue() {
        E value = null;
        if (isEmpty()) {
            System.out.println("Queue is empty!! Can not dequeue element");
        } else {
            rear++;
            if(rear == DEFAULT_CAPACITY-1){
                value = (E) elements[rear];
                rear = 0;
            } else {
                value = (E) elements[rear];
            }
            size--;
        }
        return value;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (size == DEFAULT_CAPACITY){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Queue [front=" + front + ", rear=" + rear + ", size=" + size
                + ", queue=" + Arrays.toString(elements) + "]";
    }
}
