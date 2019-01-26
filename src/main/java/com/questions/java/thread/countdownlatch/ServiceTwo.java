package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class ServiceTwo implements Runnable{
    private final CountDownLatch latch;

    public ServiceTwo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("started service Two");
        //reduce count of Count Down Latch by 1.
        latch.countDown();
    }
}
