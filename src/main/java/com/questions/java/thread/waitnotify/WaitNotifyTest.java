package com.questions.java.thread.waitnotify;

/**
 * Created by jitendra on 09 Mar, 2018
 */

/*
When we will invoke the above program, we will see below output but program will not complete because there are
two threads waiting on Message object and notify() method has wake up only one of them, the other thread is still waiting to get notified.
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Message msg = new Message("process it");
        Waiter waiter = new Waiter(msg);
        new Thread(waiter,"waiter").start();

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1, "waiter1").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }
}
