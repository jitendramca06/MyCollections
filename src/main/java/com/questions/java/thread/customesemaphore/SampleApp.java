package com.questions.java.thread.customesemaphore;

public class SampleApp {
    public static void main(String[] args) {
        CustomSemaphore semaphore = new CustomSemaphore(1);
        Worker worker = new Worker(semaphore);
        new Thread(worker, "Thread-1").start();
        new Thread(worker, "Thread-2").start();
        new Thread(worker, "Thread-3").start();
    }
}
