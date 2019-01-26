package com.questions.java.thread.threadssourcecodes.printinsequence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 22/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        Object lock = new Object();
        Data data = new Data(4, integer, lock);
        Thread t1 = new Thread(new Task(1, data), "T1");
        Thread t2 = new Thread(new Task(2, data), "T2");
        Thread t3 = new Thread(new Task(3, data), "T3");
        Thread t4 = new Thread(new Task(0, data), "T4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
