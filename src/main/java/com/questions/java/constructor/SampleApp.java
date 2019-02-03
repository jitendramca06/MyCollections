package com.questions.java.constructor;

/**
 * @author Jitendra Kumar : 2/2/19
 */
public class SampleApp {
    public static void main(String[] args) {
        new Thread(() ->{
            ThreadSafeConstructor obj = new ThreadSafeConstructor();
        }, "ThreadSafeConstructor-1").start();

        new Thread(() ->{
            ThreadSafeConstructor obj = new ThreadSafeConstructor();
        }, "ThreadSafeConstructor-2").start();

        new Thread(() ->{
            ThreadSafeConstructor obj = new ThreadSafeConstructor();
        }, "ThreadSafeConstructor-3").start();

        ThreadSafeMethod threadSafeMethod = new ThreadSafeMethod();

        new Thread(() ->{
            threadSafeMethod.method1(10);
        }, "ThreadSafeMethod-1").start();

        new Thread(() ->{
            threadSafeMethod.method1(10);
        }, "ThreadSafeMethod-2").start();

        new Thread(() ->{
            threadSafeMethod.method1(10);
        }, "ThreadSafeMethod-3").start();

        new Thread(() ->{
            threadSafeMethod.method1(10);
        }, "ThreadSafeMethod-4").start();

        new Thread(() ->{
            threadSafeMethod.method1(20);
        }, "ThreadSafeMethod-5").start();

        new Thread(() ->{
            threadSafeMethod.method1(30);
        }, "ThreadSafeMethod-6").start();
    }
}
