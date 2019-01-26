package com.questions.java.thread.threadssourcecodes.conditionwait.otherexample;

/**
 * @author Jitendra Kumar : 24/1/19
 */
public class ExampleApp {
    public static void main(String[] args) {
        Message msg = new Message();
        Thread p = new Thread(new Producer(msg));
        Thread c = new Thread(new Consumer(msg));
        p.start();
        c.start();
    }
}
