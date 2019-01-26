package com.questions.java.thread.threadssourcecodes.printsequenceusingjoin;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        Data data = new Data(atomicInteger);
        Task task = new Task(data);

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");
        try {
            t1.start();
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
