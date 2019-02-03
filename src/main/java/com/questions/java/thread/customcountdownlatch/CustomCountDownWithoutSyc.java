package com.questions.java.thread.customcountdownlatch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 3/2/19
 */
public class CustomCountDownWithoutSyc {
    private AtomicInteger atomicInteger;

    public CustomCountDownWithoutSyc(int permits) {
        this.atomicInteger = new AtomicInteger(permits);
    }

    public void await() {
        while (atomicInteger.get() != 0);
    }

    public void countDown() {
        if (atomicInteger.get() > 0) {
            atomicInteger.set(atomicInteger.get() - 1);
        }
    }
}
