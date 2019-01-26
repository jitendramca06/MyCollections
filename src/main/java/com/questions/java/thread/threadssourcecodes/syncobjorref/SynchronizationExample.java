package com.questions.java.thread.threadssourcecodes.syncobjorref;

/**
 * @author Jitendra Kumar : 25/9/18
 */
public class SynchronizationExample {
    private static Object LOCK = new Object();
    private Object lock1 = LOCK;
    private Object lock2 = LOCK;
    private Object lock3;

    public static void main(String[] args) {
        SynchronizationExample synchronizationExample = new SynchronizationExample();
        new Thread(() -> {
            synchronizationExample.hello1();
        }).start();
        new Thread(() -> {
            synchronizationExample.hello2();
        }).start();
    }

    public void hello1() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " in synchronized block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " leaving synchronized block");
        }
    }

    public void hello2() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " in synchronized block");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " leaving synchronized block");
        }
    }
}
