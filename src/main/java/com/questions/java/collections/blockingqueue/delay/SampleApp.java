package com.questions.java.collections.blockingqueue.delay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        BlockingQueue<DelayData> queue = new DelayQueue<>();
        Data data = new Data(queue);

        new Thread(()->data.producer(), "Producer-1").start();
        new Thread(()->data.consumer(), "Consumer-1").start();
        new Thread(()->data.producer(), "Producer-1").start();
        new Thread(()->data.consumer(), "Consumer-1").start();
    }
}
