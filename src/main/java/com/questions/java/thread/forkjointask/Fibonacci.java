package com.questions.java.thread.forkjointask;

import java.util.concurrent.RecursiveTask;

/**
 * @author Jitendra Kumar : 5/1/19
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    public Fibonacci(int n) {
        this.n = n;
    }
    @Override
    protected Integer compute() {
        if (n <= 1) {
            return n;
        }

        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        return f2.join() + f1.join();
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci(10);
        System.out.println(fibonacci.compute());
        //fibonacci.compute();
    }
}
