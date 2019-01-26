package com.questions.java.thread.threadssourcecodes.printingroup;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class Data {
    private AtomicInteger noOfIteration;
    private int dataPerThread;
    private Object lock;
    private int noOfThread;

    public Data(AtomicInteger noOfIteration, int dataPerThread, Object lock, int noOfThread) {
        this.noOfIteration = noOfIteration;
        this.dataPerThread = dataPerThread;
        this.lock = lock;
        this.noOfThread = noOfThread;
    }

    public void print(String thread, int threadId) {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    if (noOfIteration.get() % noOfThread != threadId) lock.wait();
                    else {
                        int count = noOfIteration.getAndIncrement();
                        count = count*dataPerThread;
                        for (int i = 1 ; i <= dataPerThread ; i++) {
                            int result = count + i;
                            System.out.println(thread + ", " + result);
                        }
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
