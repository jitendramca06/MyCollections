package com.questions.java.thread.threadssourcecodes.exceptioninthreads;

/**
 * @author Jitendra Kumar : 25/9/18
 */
public class MixedExceptionHandler {
    public static void main(String[] args) {
        //Register Global Exception Handler for all Threads
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Default Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        });
        //Register ThreadGroup Exception Handler for all Threads in ThreadGroup
        ThreadGroup tr = new ThreadGroup("MyGroup") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ThreadGroup Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        };
        Thread t1 = new Thread(tr, new WorkerThread());
        t1.setName("T1");
        t1.start();
        Thread t2 = new Thread(tr, new WorkerThread());
        t2.setName("T2");
        t2.start();
        Thread t3 = new Thread(new WorkerThread());
        t3.setName("T3");
        t3.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Thread Exception Handler :Thread Name :" + t.getName() + " Message :" + e.getMessage());
            }
        });
        t3.start();
        Thread t4 = new Thread(new WorkerThread());
        t4.setName("T4");
        t4.start();
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("I am printing");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t5.setName("T5");
        t5.start();
    }
}
