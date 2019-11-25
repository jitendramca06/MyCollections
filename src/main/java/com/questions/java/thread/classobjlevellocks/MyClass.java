package com.questions.java.thread.classobjlevellocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 1/5/19
 */
public class MyClass {
    /**
     * 'classLevelLock' behaves like class level lock
     */
    private static Object classLevelLock = new Object();
    private Object objectLevelLock = new Object();

    /**
     * Class level lock
     */
    public synchronized static void synchronizedStaticMethod() {
        System.out.println("Thread-" + Thread.currentThread().getName() + "-in synchronizedStaticMethod");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Object level lock
     */
    public synchronized void synchronizedMethod() {
        System.out.println("Thread-" + Thread.currentThread().getName() + "-in synchronizedMethod");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class level lock
     */
    public void methodWithClassLevelLock() {
        synchronized (classLevelLock) {
            System.out.println("Thread-" + Thread.currentThread().getName() + "-in MethodWithClassLevelLock");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Class level lock
     */
    public void methodWithClassLevelLock1() {
        synchronized (MyClass.class) {
            System.out.println("Thread-" + Thread.currentThread().getName() + "-in MethodWithClassLevelLock1");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Object level lock
     */
    public void methodWithObjLevelLock() {
        synchronized (objectLevelLock) {
            System.out.println("Thread-" + Thread.currentThread().getName() + "-in MethodWithObjLevelLock");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("====Only one thread with only one instance can acquire the lock====");
        ExecutorService executorService = Executors.newFixedThreadPool(11);
        for (int i = 0 ; i < 11 ; i++) {
            MyClass obj1 = new MyClass();
            Thread t1 = new Thread(() -> {
                obj1.synchronizedStaticMethod();
            });
            executorService.submit(t1);
        }
        executorService.shutdown();
        TimeUnit.MILLISECONDS.sleep(10000);
        System.out.println("====Single bject with single lock====");
        ExecutorService executorService1 = Executors.newFixedThreadPool(11);
        for (int i = 0 ; i < 11 ; i++) {
            MyClass obj1 = new MyClass();
            Thread t1 = new Thread(() -> {
                obj1.synchronizedMethod();
            });
            executorService1.submit(t1);
        }
        executorService1.shutdown();
        TimeUnit.MILLISECONDS.sleep(10000);
        System.out.println("====methodWithClassLevelLock====");
        ExecutorService executorService2 = Executors.newFixedThreadPool(11);
        for (int i = 0 ; i < 11 ; i++) {
            MyClass obj1 = new MyClass();
            Thread t1 = new Thread(() -> {
                obj1.methodWithClassLevelLock();
            });
            executorService2.submit(t1);
        }
        executorService2.shutdown();
        TimeUnit.MILLISECONDS.sleep(10000);
        System.out.println("====methodWithClassLevelLock1====");
        ExecutorService executorService3 = Executors.newFixedThreadPool(11);
        for (int i = 0 ; i < 11 ; i++) {
            MyClass obj1 = new MyClass();
            Thread t1 = new Thread(() -> {
                obj1.methodWithClassLevelLock1();
            });
            executorService3.submit(t1);
        }
        executorService3.shutdown();
        TimeUnit.MILLISECONDS.sleep(10000);
        System.out.println("====methodWithObjLevelLock====");
        ExecutorService executorService4 = Executors.newFixedThreadPool(11);
        for (int i = 0 ; i < 11 ; i++) {
            MyClass obj1 = new MyClass();
            Thread t1 = new Thread(() -> {
                obj1.methodWithObjLevelLock();
            });
            executorService4.submit(t1);
        }
        executorService4.shutdown();
    }
}
