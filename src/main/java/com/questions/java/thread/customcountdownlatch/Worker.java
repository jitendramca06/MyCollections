package com.questions.java.thread.customcountdownlatch;

public class Worker implements Runnable{
    CustomCountDown customCountDown;

    public Worker(CustomCountDown customCountDown) {
        this.customCountDown = customCountDown;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println("Thread-" + Thread.currentThread().getName() + " started.");
            customCountDown.countDown();
            for (int i = 1 ; i <= 5 ; i++) {
                System.out.println(i);
            }
            System.out.println("Thread-" + Thread.currentThread().getName() + " completed its work.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
