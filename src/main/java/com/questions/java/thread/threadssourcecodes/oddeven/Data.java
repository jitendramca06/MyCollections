package com.questions.java.thread.threadssourcecodes.oddeven;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 22/9/18
 */
public class Data {
    private AtomicInteger data;
    private Object lock;

    public Data(AtomicInteger data, Object lock) {
        this.data = data;
        this.lock = lock;
    }

    public void print(int threadId, String thread) {
        while (true) {
            try {
                Thread.sleep(1000);
                synchronized (lock) {
                    if (data.get() % 2 != threadId) lock.wait();
                    else {
                        System.out.println(thread + ", " + data.getAndIncrement());
                        lock.notify();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
