package com.questions.java.thread.customesemaphore;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 3/2/19
 */
public class CustomSemaphoreWithoutSync {
    private AtomicInteger count;

    public CustomSemaphoreWithoutSync(int count) {
        this.count = new AtomicInteger(count);
    }

    public void acquire() {
        int c = count.get();
        while (c == 0) {
            c = count.get();
        }
        count.decrementAndGet();
    }

    public void release() {
        count.incrementAndGet();
    }

    public int availablePermits() {
        return count.get();
    }

    public static void main(String[] args) {
        CustomSemaphoreWithoutSync customSemaphoreWithoutSync = new CustomSemaphoreWithoutSync(1);

        new Thread(() -> {
            System.out.println(customSemaphoreWithoutSync.availablePermits());
            customSemaphoreWithoutSync.acquire();
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSemaphoreWithoutSync.release();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }, "CustomSemaphoreWithoutSync-1").start();

        new Thread(() -> {
            System.out.println(customSemaphoreWithoutSync.availablePermits());
            customSemaphoreWithoutSync.acquire();
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(1100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSemaphoreWithoutSync.release();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }, "CustomSemaphoreWithoutSync-2").start();

        new Thread(() -> {
            System.out.println(customSemaphoreWithoutSync.availablePermits());
            customSemaphoreWithoutSync.acquire();
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSemaphoreWithoutSync.release();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }, "CustomSemaphoreWithoutSync-3").start();

        new Thread(() -> {
            System.out.println(customSemaphoreWithoutSync.availablePermits());
            customSemaphoreWithoutSync.acquire();
            System.out.println(Thread.currentThread().getName() + " started.");
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customSemaphoreWithoutSync.release();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }, "CustomSemaphoreWithoutSync-4").start();
    }
}
