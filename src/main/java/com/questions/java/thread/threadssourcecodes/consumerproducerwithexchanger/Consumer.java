package com.questions.java.thread.threadssourcecodes.consumerproducerwithexchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Jitendra Kumar : 4/1/19
 */
public class Consumer implements Runnable{
    Exchanger<Integer> exchanger;

    public Consumer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(1));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(3));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(5));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(7));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(9));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
