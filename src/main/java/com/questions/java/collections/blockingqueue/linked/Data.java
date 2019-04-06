package com.questions.java.collections.blockingqueue.linked;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class Data {
    private BlockingQueue<String> queue;

    public Data(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void producer() {
        while (true) {
            try {
                String d = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName() + " produced-" + d);
                queue.put(d);
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1100);
                System.out.println(Thread.currentThread().getName() + " consumed-" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
