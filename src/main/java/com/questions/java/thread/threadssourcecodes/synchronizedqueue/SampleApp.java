package com.questions.java.thread.threadssourcecodes.synchronizedqueue;

/**
 * @author Jitendra Kumar : 8/1/19
 */
public class SampleApp {
    public static void main(String[] args) {
        Data data = new Data();
        Thread p = new Thread(new Producer(data), "Producer");
        Thread c = new Thread(new Consumer(data), "Consumer");
        p.start();
        c.start();
    }
}
