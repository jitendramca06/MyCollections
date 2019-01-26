package com.questions.java.thread.customcountdownlatch;

public class ExampleApp {
    public static void main(String[] args) {
        CustomCountDown customCountDown = new CustomCountDown(3);
        Worker worker = new Worker(customCountDown);
        new Thread(worker, "Thread-1").start();
        new Thread(worker, "Thread-2").start();
        new Thread(worker, "Thread-3").start();
        try {
            customCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads completed their work.");
    }
}
