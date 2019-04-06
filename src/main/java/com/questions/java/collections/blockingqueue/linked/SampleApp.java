package com.questions.java.collections.blockingqueue.linked;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Data data = new Data(queue);

        new Thread(()-> data.producer(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
        new Thread(()-> data.producer(), "Producer-2").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
    }
}
