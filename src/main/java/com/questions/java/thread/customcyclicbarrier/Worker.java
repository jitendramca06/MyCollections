package com.questions.java.thread.customcyclicbarrier;

public class Worker implements Runnable{
    CustomCyclicBarrier customCyclicBarrier;

    public Worker(CustomCyclicBarrier customCyclicBarrier) {
        this.customCyclicBarrier = customCyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Thread - " + Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(100);
            customCyclicBarrier.await();
            for (int i = 1 ; i <= 5 ; i++)
                System.out.println("Thread - " + Thread.currentThread().getName() + "==" + i);
            System.out.println("Thread - " + Thread.currentThread().getName() + " completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
