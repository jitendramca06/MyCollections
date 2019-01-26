package com.questions.java.thread.threadssourcecodes.exceptioninthreads;

/**
 * @author Jitendra Kumar : 25/9/18
 */
public class ThreadLevelExceptionHandler {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("I am RuntimeException");
            }
        });
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        });
        t1.start();
    }
}
