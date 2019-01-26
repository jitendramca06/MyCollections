package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class ServiceOne implements Runnable {
    private final CountDownLatch latch;

    public ServiceOne(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started service One");
        //reduce count of Count Down Latch by 1.
        latch.countDown();
    }
}
