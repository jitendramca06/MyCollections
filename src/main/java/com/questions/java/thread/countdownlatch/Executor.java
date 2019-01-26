package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jitendra on 08 Mar, 2018
 */
public class Executor {
    final static int MAX_COUNT = 10;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("starting counter: " + StaticCounter.getCounter());

        for (int i = 0; i < MAX_COUNT; i++) {

            new Thread(()->StaticCounter.addToCounter(1)).start();
        }

        // This will return an inaccurate value most of the time. To get an accurate result use a countdown latch
        System.out.println("=====> final counter: " + StaticCounter.getCounter());

        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch finished = new CountDownLatch(MAX_COUNT);

        for (int i = 0; i < MAX_COUNT; ++i) {
            new Thread(new Runner(start, finished)).start();
        }
        System.out.println("Starting the countdown...");
        start.countDown(); // Starting all threads... way cool!
        finished.await();  // Waiting for all threads to finish
        System.out.println("=====> final count on Runner: " + Runner.count);
    }
}
