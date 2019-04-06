package com.questions.java.collections.blockingqueue.transferqueue;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author Jitendra Kumar : 6/4/19
 */
public class Data {
    private TransferQueue<String> transferQueue;

    public Data(TransferQueue<String> transferQueue) {
        this.transferQueue = transferQueue;
    }

    public void producer() {
        while (true) {
            try {
                String data = UUID.randomUUID().toString();
                System.out.println(Thread.currentThread().getName() + " produced-" + data);
                transferQueue.transfer(data);
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
                System.out.println(Thread.currentThread().getName() + " consumed-" + transferQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
