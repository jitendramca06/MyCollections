package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
For Example, it can be used when a Thread has to wait until few dependent threads have started.
CountDownLatch is initialised with a given count. This count is decremented by calls to
the countDown() method. Each Thread on whose completion the main Thread is waiting will call countDown()
method and decrease the count. Once all such threads are executed the count will become 0 and then the
waiting main thread can start its execution.
 */
public class JavaCountDownLatchExample {
    public static void main(String[] args) {
        // intialising count down latch by 2, as it will wait for 2 threads to
        // finish execution
        final CountDownLatch latch = new CountDownLatch(2);

        // making two threads for 2 services
        Thread serviceOneThread = new Thread(new ServiceOne(latch));
        Thread serviceTwoThread = new Thread(new ServiceTwo(latch));

        serviceOneThread.start();
        serviceTwoThread.start();

        // latch waits till the count becomes 0
        // this way we can make sure that the execution of main thread only
        // finishes ones 2 services have executed
        try {
            latch.await();
            System.out.println("Starting main Thread!!!");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
