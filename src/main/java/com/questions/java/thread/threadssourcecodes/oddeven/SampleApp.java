package com.questions.java.thread.threadssourcecodes.oddeven;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 22/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Object lock = new Object();
        Data data = new Data(atomicInteger, lock);
        Thread t1 = new Thread(new Task(data, 1), "T1");
        Thread t2 = new Thread(new Task(data, 0), "T2");
        t1.start();
        t2.start();
    }
}
