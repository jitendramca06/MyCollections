package com.questions.java.thread.deadlock;

/**
 * @author Jitendra Kumar : 30/8/18
 */
public class Worker implements Runnable{
    Object obj1;
    Object obj2;

    public Worker(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    /**
     * Deadlock based code .
     * Here due to nested synchronized block we are facing deadlock
     */


    @Override
    public void run() {
        System.out.println("Thread - " + Thread.currentThread().getName() + " acquiring lock on object - " + obj1.toString());
        synchronized (obj1) {
            System.out.println("Thread - " + Thread.currentThread().getName() + " acquired lock on object - " + obj1.toString());
            work();
            System.out.println("Thread - " + Thread.currentThread().getName() + " acquiring lock on object - " + obj2.toString());
            synchronized (obj2) {
                System.out.println("Thread - " + Thread.currentThread().getName() + " acquired lock on object - " + obj2.toString());
                work();
            }
            System.out.println("Thread - " + Thread.currentThread().getName() + " released lock on object - " + obj2.toString());
        }
        System.out.println("Thread - " + Thread.currentThread().getName() + " released lock on object - " + obj1.toString());
        System.out.println("Thread - " + Thread.currentThread().getName() + " finished");
    }

    /**
     * 1. Avoid Nested Locks: This is the most common reason for deadlocks, avoid locking another resource
     * if you already hold one. It’s almost impossible to get deadlock situation if you are working with
     * only one object lock. For example, here is the another implementation of run() method without nested
     * lock and program runs successfully without deadlock situation.
     *
     * 2. Lock Only What is Required: You should acquire lock only on the resources you have to work on,
     * for example in above program I am locking the complete Object resource but if we are only interested
     * in one of it’s fields, then we should lock only that specific field not complete object.
     *
     * 3. Avoid waiting indefinitely: You can get deadlock if two threads are waiting for each other to finish
     * indefinitely using thread join. If your thread has to wait for another thread to finish, it’s always
     * best to use join with maximum time you want to wait for thread to finish.
     *
     *
     *
     */


    /**
     * Dead lock free code, I removed nested synchronised block from run method to avoid deadlock
     */


    /*@Override
    public void run() {
        System.out.println("Thread - " + Thread.currentThread().getName() + " acquiring lock on object - " + obj1.toString());
        synchronized (obj1) {
            System.out.println("Thread - " + Thread.currentThread().getName() + " acquired lock on object - " + obj1.toString());
            work();
        }
        System.out.println("Thread - " + Thread.currentThread().getName() + " released lock on object - " + obj1.toString());
        System.out.println("Thread - " + Thread.currentThread().getName() + " acquiring lock on object - " + obj2.toString());
        synchronized (obj2) {
            System.out.println("Thread - " + Thread.currentThread().getName() + " acquired lock on object - " + obj2.toString());
            work();
        }
        System.out.println("Thread - " + Thread.currentThread().getName() + " released lock on object - " + obj2.toString());
        System.out.println("Thread - " + Thread.currentThread().getName() + " finished");
    }*/

    private void work() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
