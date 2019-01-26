package com.questions.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
You obtain a fixed thread pool by calling the static newFixedThreadPool() method of Executors class.
The code snippet below creates a fixed thread pool with a maximum of 10 threads.

ExecutorService fixedPool = Executors.newFixedThreadPool(10);

Here is what the docs say about the pool created above:

A maximum of 10 (or whatever number you desire) threads will be active processing tasks.
If more than 10 tasks are submitted then they are held in a queue until threads become available.
If a thread terminates due to failure during execution and prior to shutdown, a new thread is created to
take its place.
The threads exist till the pool is shutdown.
The object returned by the newFixedThreadPool() belongs to a class which implements the ExecutorService
interface and hence we will be calling the submit() method and will be getting back a Future<T> object
in return. So, to keep this post short I am skipping writing about Future<T> and how to use it to get the result.
 */
public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
