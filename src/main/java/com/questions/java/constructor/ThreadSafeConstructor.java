package com.questions.java.constructor;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jitendra Kumar : 2/2/19
 */
public class ThreadSafeConstructor {
    private static AtomicBoolean status = new AtomicBoolean(false);

    public ThreadSafeConstructor() {
        /**
         * Only one thread should allow to excess this constructor
         */
        while (status.getAndSet(true));
        System.out.println(Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " completed.");
        status.set(false);
    }
}
