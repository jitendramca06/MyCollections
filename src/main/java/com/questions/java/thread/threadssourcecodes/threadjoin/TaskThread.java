package com.questions.java.thread.threadssourcecodes.threadjoin;

/**
 * @author Jitendra Kumar : 26/9/18
 */
public class TaskThread implements Runnable {
    public TaskThread() {
    }

    public TaskThread(Thread threadToJoin) {
        try {
            threadToJoin.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("Start Thread :" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Thread :" + Thread.currentThread().getName());
    }
}
