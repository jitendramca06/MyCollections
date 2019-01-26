package com.questions.java.thread.threadssourcecodes.consumerproducerwithexchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Jitendra Kumar : 4/1/19
 */
public class App {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        Thread t = new Thread(new Producer(exchanger), "Producer");
        Thread t1 = new Thread(new Consumer(exchanger), "Consumer");
        t.start();
        t1.start();
    }
}
