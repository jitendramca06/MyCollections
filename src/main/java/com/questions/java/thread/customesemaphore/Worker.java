package com.questions.java.thread.customesemaphore;

public class Worker implements Runnable{
    CustomSemaphore semaphore;

    public Worker(CustomSemaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.aquire();
            System.out.println("Thread-" + Thread.currentThread().getName() + " acquire the semaphore.");
            for (int i = 0 ; i < 5 ; i++) {
                Thread.sleep(100);
                System.out.println("Thread-" + Thread.currentThread().getName() + " executing.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
    }
}
