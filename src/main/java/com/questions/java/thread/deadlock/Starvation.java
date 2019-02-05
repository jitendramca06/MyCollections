package com.questions.java.thread.deadlock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Jitendra Kumar : 5/2/19
 */
public class Starvation {
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    public static void method() {
        try {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " started execution...");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " completed execution...");
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            method();
        });
        Thread thread2 = new Thread(() -> {
            method();
        });
        Thread thread3 = new Thread(() -> {
            method();
        });
        Thread thread4 = new Thread(() -> {
            method();
        });
        Thread thread5 = new Thread(() -> {
            method();
        });
        Thread thread6 = new Thread(() -> {
            method();
        });

        thread1.setPriority(10);
        thread2.setPriority(9);
        thread3.setPriority(8);
        thread4.setPriority(7);
        thread5.setPriority(6);

        //We set low the priority for this thread.
        thread6.setPriority(1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        System.out.println("main thread completed");
    }
}
