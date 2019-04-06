package com.questions.java.collections.blockingqueue.prority;

import com.questions.java.collections.blockingqueue.linked.Data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        Data data = new Data(queue);
        new Thread(()-> data.producer(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
        new Thread(()-> data.producer(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
    }
}
