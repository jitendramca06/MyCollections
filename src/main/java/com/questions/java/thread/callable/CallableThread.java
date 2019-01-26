package com.questions.java.thread.callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Integer> {
    Integer a;
    Integer b;
    CallableThread(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }
    public Integer call() throws Exception {
        System.out.println("Thread-" + Thread.currentThread().getName() + " started");
        return (a+b);
    }
}
