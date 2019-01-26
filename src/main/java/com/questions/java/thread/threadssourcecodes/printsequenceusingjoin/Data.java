package com.questions.java.thread.threadssourcecodes.printsequenceusingjoin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class Data {
    private AtomicInteger data;

    public Data(AtomicInteger data) {
        this.data = data;
    }

    public void print(String thread) {
        try {
            Thread.sleep(1000);
            System.out.println(thread + "-" + data.getAndIncrement());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
