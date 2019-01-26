package com.questions.java.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
Most common methods are used to create:

an ExecutorService with a single thread to execute commands with method newSingleThreadExecutor.

a ScheduledExecutorService with a single thread to execute commands with the method newSingleThreadScheduledExecutor.

an ExecutorService that use a fixed length pool of threads to execute commands with the method newFixedThreadPool.

an ExecutorService with a pool of threads that creates a new thread if no thread is available and reuse an existing
thread if they are available with newCachedThreadPool.

a ScheduledExecutorService with a fixed length pool of threads to execute scheduled commands with the method
newScheduledThreadPool.


// Creates a single thread ExecutorService
ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
// Creates a single thread ScheduledExecutorService
ScheduledExecutorService singleScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
// Creates an ExecutorService that use a pool of 10 threads
ExecutorService fixedExecutorService = Executors.newFixedThreadPool(10);
// Creates an ExecutorService that use a pool that creates threads on demand
// And that kill them after 60 seconds if they are not used
ExecutorService onDemandExecutorService = Executors.newCachedThreadPool();
// Creates a ScheduledExecutorService that use a pool of 5 threads
ScheduledExecutorService fixedScheduledExecutorService = Executors.newScheduledThreadPool(5);

Executor’s newSingleThreadExecutor factory method :

This method returns thread pool executor which executes one task at a time.If you have submitted
 n task to executors, it will execute it one by one.If this thread gets interrupted then a new thread
 will be created for executing the tasks.
 */
public class SingleThreadPoolMain {
    public static void main(String args[])
    {
        ExecutorService es= Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 3; i++) {
            LoopTask loopTask=new LoopTask("LoopTask "+i);
            es.submit(loopTask);
        }
        es.shutdown();
    }
}
