package com.questions.java.collections.blockingqueue.array;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);
        Data data = new Data(blockingQueue);

        new Thread(()-> data.produce(), "Producer-1").start();
        new Thread(()-> data.consumer(), "Consumer-1").start();
        new Thread(()-> data.produce(), "Producer-2").start();
        new Thread(()-> data.consumer(), "Consumer-2").start();
    }
}
