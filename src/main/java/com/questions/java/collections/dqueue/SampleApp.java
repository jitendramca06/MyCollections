package com.questions.java.collections.dqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        Data data = new Data(deque);

        new Thread(()->data.producer(), "Producer-1").start();
        new Thread(()->data.consumer(), "Consumer-1").start();
        new Thread(()->data.producer(), "Producer-1").start();
        new Thread(()->data.consumer(), "Consumer-1").start();
    }
}
