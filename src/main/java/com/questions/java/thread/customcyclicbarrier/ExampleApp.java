package com.questions.java.thread.customcyclicbarrier;

public class ExampleApp {
    public static void main(String[] args) {
        Barrier barrier = new Barrier();
        CustomCyclicBarrier customCyclicBarrier = new CustomCyclicBarrier(2, 2, barrier);
        Worker worker = new Worker(customCyclicBarrier);
        new Thread(worker, "Thread-1").start();
        new Thread(worker, "Thread-2").start();
        new Thread(worker, "Thread-3").start();

    }
}
