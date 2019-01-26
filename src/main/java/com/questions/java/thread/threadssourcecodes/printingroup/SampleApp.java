package com.questions.java.thread.threadssourcecodes.printingroup;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Object lock = new Object();
        Data data = new Data(atomicInteger, 2, lock, 3);

        Thread t1 = new Thread(new Task(data, 0), "T1");
        Thread t2 = new Thread(new Task(data, 1), "T2");
        Thread t3 = new Thread(new Task(data, 2), "T3");
        t1.start();
        t2.start();
        t3.start();
    }
}
