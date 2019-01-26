package com.questions.java.thread.threadssourcecodes.synchronizedqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author Jitendra Kumar : 8/1/19
 */
public class Data {
    private SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
    private int count;

    public void produce() {
        while (count <= 100) {
            try {
                System.out.println(Thread.currentThread().getName() + "-" + count);
                synchronousQueue.put(count++);
                //synchronousQueue.put(count++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consume() {
        while (count <= 100) {
            try {
                System.out.println(Thread.currentThread().getName() + "-" + synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
