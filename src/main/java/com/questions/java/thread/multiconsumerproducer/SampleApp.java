package com.questions.java.thread.multiconsumerproducer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>(4);
        MessageQueue messageQueue = new MessageQueue(queue, 4, 5);
        Producer producer1 = new Producer(messageQueue, 0);
        Consumer consumer1 = new Consumer(messageQueue);
        Producer producer2 = new Producer(messageQueue, 1);
        Consumer consumer2 = new Consumer(messageQueue);
        Producer producer3 = new Producer(messageQueue, 2);
        Consumer consumer3 = new Consumer(messageQueue);

        Thread p1T = new Thread(producer1, "Producer1");
        Thread c1T = new Thread(consumer1, "Consumer1");
        Thread p2T = new Thread(producer2, "Producer2");
        Thread c2T = new Thread(consumer2, "Consumer2");
        Thread p3T = new Thread(producer3, "Producer3");
        Thread c3T = new Thread(consumer3, "Consumer3");
        p1T.start();
        c1T.start();
        p2T.start();
        c2T.start();
        p3T.start();
        c3T.start();
    }
}
