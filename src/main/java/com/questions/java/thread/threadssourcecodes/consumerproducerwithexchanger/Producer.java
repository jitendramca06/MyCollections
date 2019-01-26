package com.questions.java.thread.threadssourcecodes.consumerproducerwithexchanger;

import java.util.concurrent.Exchanger;

/**
 * @author Jitendra Kumar : 4/1/19
 */
public class Producer implements Runnable{
    Exchanger<Integer> exchanger;

    public Producer(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(2));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(4));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(6));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(8));
            System.out.println(Thread.currentThread().getName() + " - " + exchanger.exchange(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
