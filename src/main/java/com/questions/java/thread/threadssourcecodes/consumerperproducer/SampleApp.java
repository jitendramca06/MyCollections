package com.questions.java.thread.threadssourcecodes.consumerperproducer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class SampleApp {
    public static void main(String[] args) {
        AtomicInteger atomicIntegerP = new AtomicInteger(0);
        AtomicInteger atomicIntegerC = new AtomicInteger(0);
        List<Integer> list = new ArrayList<>();
        Data data = new Data(atomicIntegerP, 3, list, 5, atomicIntegerC);
        Thread p1 = new Thread(new ProducerTask(data, 0), "P1");
        Thread p2 = new Thread(new ProducerTask(data, 1), "P2");
        Thread p3 = new Thread(new ProducerTask(data, 2), "P3");

        Thread c1 = new Thread(new ConsumerTask(data, 0), "C1");
        Thread c2 = new Thread(new ConsumerTask(data, 1), "C2");
        Thread c3 = new Thread(new ConsumerTask(data, 2), "C3");

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
