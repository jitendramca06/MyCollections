package com.questions.java.thread.threadssourcecodes.printinsequence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 22/9/18
 */
public class Data {
    private int noOfThreads;
    private AtomicInteger atomicInteger;
    private Object lock;

    public Data(int noOfThreads, AtomicInteger atomicInteger, Object lock) {
        this.noOfThreads = noOfThreads;
        this.atomicInteger = atomicInteger;
        this.lock = lock;
    }

    public void print(int threadId, String thread) {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    if (atomicInteger.get() % noOfThreads != threadId) {
                        lock.wait();
                    } else {
                        System.out.println(thread + ", " + atomicInteger.getAndIncrement());
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
