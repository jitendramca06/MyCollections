package com.questions.java.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
An executor initiates and controls the execution of threads. An executor offers an alternative to managing threads through the Thread class.

At the core of an executor is the Executor interface. It defines the following method:

void execute(Runnable thread)
execute() starts the specified thread.

The ExecutorService interface extends Executor and adds methods that help manage and control the execution of threads.
ScheduledExecutorService interface extends ExecutorService to support the scheduling of threads.

The concurrent API defines two predefined executor classes: ThreadPoolExecutor and ScheduledThreadPoolExecutor.

ThreadPoolExecutor implements the Executor and ExecutorService interfaces and provides support for a managed pool of threads.

ScheduledThreadPoolExecutor implements the ScheduledExecutorService interface to allow a pool of threads to be scheduled.

A thread pool provides many threads that are used to execute various tasks.

The following static factory methods returns an executor.

Here are some examples:

static ExecutorService newCachedThreadPool()
creates a thread pool that adds threads as needed but reuses threads if possible.
static ExecutorService newFixedThreadPool(int numThreads)
creates a thread pool that consists of a specified number of threads.
static ScheduledExecutorService newScheduledThreadPool(int numThreads)
newScheduledThreadPool() creates a thread pool that supports thread scheduling.
 */
public class CountDownWithExecutorSer {
    public static void main(String args[]) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDownLatch countDownLatch2 = new CountDownLatch(5);
        CountDownLatch countDownLatch3 = new CountDownLatch(5);
        CountDownLatch countDownLatch4 = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new MyThread(countDownLatch, "A"));
        executorService.execute(new MyThread(countDownLatch2, "B"));
        executorService.execute(new MyThread(countDownLatch3, "C"));
        executorService.execute(new MyThread(countDownLatch4, "D"));
        try {
            countDownLatch.await();
            countDownLatch2.await();
            countDownLatch3.await();
            countDownLatch4.await();
        } catch (Exception exc) {
            System.out.println(exc);
        }
        executorService.shutdown();
    }
}

class MyThread implements Runnable {
    String name;
    CountDownLatch latch;

    MyThread(CountDownLatch c, String n) {
        latch = c;
        name = n;
        new Thread(this);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ": " + i);
            latch.countDown();
        }
    }
}
