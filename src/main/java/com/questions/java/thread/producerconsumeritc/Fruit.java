package com.questions.java.thread.producerconsumeritc;

/**
 * Created by jitendra on 09 Mar, 2018
 */
public class Fruit {
    String fruit;
    int quantity;
    boolean available = false;

    public synchronized void produce(String fruit) {
        // if fruit is available, producer has to wait until consumer consumes it
        while (available) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        this.fruit = fruit;
        System.out.println("Producer has produced " + fruit);
        available = true;
        notify();
    }

    public synchronized void consume() {
        // if fruit is not available, consumer has to wait until producer produces one
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        System.out.println("Consumer has consumed " + fruit);
        this.fruit = "";
        notify();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
