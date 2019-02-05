package com.questions.java.thread.deadlock;

/**
 * @author Jitendra Kumar : 5/2/19
 */
public class DeadLockExample2 {
    Thread mainThread;

    public static void main(String[] args) {
        DeadLockExample2 deadLockExample2 = new DeadLockExample2();
        deadLockExample2.mainThread = Thread.currentThread();

        Thread thread1 = new Thread(() -> {
            deadLockExample2.method();
        });
        thread1.start();
        try {
            //Main thread is waiting to the task of thread1
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * Here both thread are waiting for eachother to complete the task
         */
    }

    private void method() {
        System.out.println(Thread.currentThread().getName() + " started execution");
        try {
            //Thread1 is waiting to complete the task of main thread
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
