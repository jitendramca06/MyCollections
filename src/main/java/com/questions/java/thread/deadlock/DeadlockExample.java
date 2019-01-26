package com.questions.java.thread.deadlock;

/**
 * @author Jitendra Kumar : 30/8/18
 */
public class DeadlockExample {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        Thread thread1 = new Thread(new Worker(lock1, lock2), "1");
        Thread thread2 = new Thread(new Worker(lock2, lock3), "2");
        Thread thread3 = new Thread(new Worker(lock3, lock1), "3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
