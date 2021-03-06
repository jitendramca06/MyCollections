package com.questions.java.thread.threadssourcecodes.exceptioninthreads;

/**
 * @author Jitendra Kumar : 25/9/18
 *
 * 1. catch If you have method which connects to resource (eg opens file/network)
 * 2. throw if class higher in hierarchy needs information about error
 * 3. You generally throws an exception when you want to notify the caller of the method of some failures.
 */
public class GlobalExceptionHandler {
    public static void main(String[] args) {
        //Register Global Exception Handler for all Threads
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Default Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Exception from New Thread spawned from "main" thread
                throw new RuntimeException("I am RuntimeException");
            }
        }, "t1");
        t1.start();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Exception from main thread
            throw new RuntimeException("I am RuntimeException");
        }
    }
}
