package com.questions.java.collections.dqueue;

import java.util.UUID;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class Data {
    BlockingDeque<String> deque;

    public Data(BlockingDeque<String> deque) {
        this.deque = deque;
    }

    public void producer() {
        while (true) {
            try {
                String data = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName() + " produced-" + data);
                deque.putFirst(data);
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
                System.out.println(Thread.currentThread().getName() + " produced-" + deque.takeLast());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
