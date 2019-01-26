package com.questions.java.thread.threadssourcecodes.threadjoin;

/**
 * @author Jitendra Kumar : 26/9/18
 */
public class ThreadJoinExample extends Thread{
    private static ThreadJoinExample obj;
    @Override
    public void run() {
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " completed the task.");
        }
    }

    public static void main(String[] args) {
        obj = new ThreadJoinExample();
        obj.setName("My Thread");
        obj.start();

        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            try {
                Thread.sleep(1000);
                /**
                 * If you look at source code of join() method, It internally invokes wait() method and wait() method
                 * release all the resources before going to WAITING state.
                 */
                obj.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " completed the task.");
        }
    }
}
