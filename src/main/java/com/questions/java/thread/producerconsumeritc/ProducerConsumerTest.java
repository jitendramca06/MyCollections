package com.questions.java.thread.producerconsumeritc;

/**
 * Created by jitendra on 09 Mar, 2018
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Fruit f = new Fruit();
        Producer p = new Producer(f);
        Consumer c = new Consumer(f);
        p.start();
        c.start();
    }
}
