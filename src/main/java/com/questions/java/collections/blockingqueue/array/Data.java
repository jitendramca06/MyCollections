package com.questions.java.collections.blockingqueue.array;


import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class Data {
    BlockingQueue<String> queue;

    Data(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void produce() {
        while (true) {
            String data = UUID.randomUUID().toString();
            try {
                queue.put(data);
                System.out.println(Thread.currentThread().getName() + " produced-" + data);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
                System.out.println(Thread.currentThread().getName() + " consumed-" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
