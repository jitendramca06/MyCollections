package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class Runner implements Runnable {

    public static int count;
    private final CountDownLatch finished;
    private final CountDownLatch start;

    public Runner(CountDownLatch start, CountDownLatch finished) {
        this.start = start;
        this.finished = finished;
    }

    @Override
    public void run() {
        try {
            start.await();
            add(1);
            finished.countDown();
        } catch (InterruptedException ex) {
        } // return;

    }

    public static synchronized void add(int value) {
        count = count + value;
        System.out.println("runner count: " + count);
    }
}
