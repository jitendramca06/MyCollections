package com.questions.java.thread.customcountdownlatch;

public class ExampleApp {
    public static void main(String[] args) {
        /*CustomCountDown customCountDown = new CustomCountDown(3);
        Worker worker = new Worker(customCountDown);
        new Thread(worker, "Thread-1").start();
        new Thread(worker, "Thread-2").start();
        new Thread(worker, "Thread-3").start();
        try {
            customCountDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads completed their work.");*/

        CustomCountDownWithoutSyc customCountDownWithoutSyc = new CustomCountDownWithoutSyc(3);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started..");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " partially completed.");
            customCountDownWithoutSyc.countDown();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started..");
            try {
                Thread.sleep(2010);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " partially completed.");
            customCountDownWithoutSyc.countDown();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started..");
            try {
                Thread.sleep(2008);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " partially completed.");
            customCountDownWithoutSyc.countDown();
            System.out.println(Thread.currentThread().getName() + " completed.");
        }).start();

        customCountDownWithoutSyc.await();
        System.out.println("All threads completed their work.");
    }
}
