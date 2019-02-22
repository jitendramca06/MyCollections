package com.questions.java.thread.customcyclicbarrier;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 9/2/19
 * /
 * TODO- have to refactor because for cases it may fail
 */
public class CustomCyclicBarrierWithoutSync {
    private AtomicInteger parties;
    private int count;

    public CustomCyclicBarrierWithoutSync(int count) {
        this.count = count;
        parties = new AtomicInteger(count);
    }

    public void await() {
        if (parties.get() > 0) {
            parties.set(parties.get() - 1);
            while (parties.get() > 0);
            if (parties.get() == 0) {
                parties.set(count);
            }
        }
    }

    public static void main(String[] args) {
        CustomCyclicBarrierWithoutSync customCyclicBarrierWithoutSync = new CustomCyclicBarrierWithoutSync(3);
        int count = 0;
        while (count++< 3) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                customCyclicBarrierWithoutSync.await();
                System.out.println(Thread.currentThread().getName() + " completed.");
            }).start();
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started.");
                try {
                    Thread.sleep(1100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                customCyclicBarrierWithoutSync.await();
                System.out.println(Thread.currentThread().getName() + " completed.");
            }).start();
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started.");
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                customCyclicBarrierWithoutSync.await();
                System.out.println(Thread.currentThread().getName() + " completed.");
            }).start();
        }

        System.out.println("Main thread............");
    }
}
