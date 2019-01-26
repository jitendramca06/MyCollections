package com.questions.java.thread.threadssourcecodes.threadjoin;

/**
 * @author Jitendra Kumar : 26/9/18
 */
public class ThreadJoinWithTasks {
    public static void main(String[] args) {
        System.out.println("Inside Main Thread");

        Thread thread1 = new Thread(new TaskThread());
        thread1.start();

        Thread thread2 = new Thread(new TaskThread(thread1));
        thread2.start();

        Thread thread3 = new Thread(new TaskThread(thread2));
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of Main Thread");
    }
}
