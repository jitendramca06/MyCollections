package com.questions.java.collections.blockingqueue.delay;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class Data {
    private BlockingQueue<DelayData> queue;

    public Data(BlockingQueue<DelayData> queue) {
        this.queue = queue;
    }

    public void producer() {
        while (true) {
            try {
                DelayData data = new DelayData(UUID.randomUUID().toString(), 101);
                System.out.println(Thread.currentThread().getName() + " produced-" + data);
                queue.put(data);
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " comsumed-" + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
