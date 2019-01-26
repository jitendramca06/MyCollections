package com.questions.java.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
newSingleThreadScheduledExecutor(); creates an executor with a single thread that will never do anything
in parallel to the existing thread. It has just one and threads can't execute more than 1 thing at a time.

If your tasks takes longer than 10 seconds, it will still create a new task after 10 seconds and put
it in the queue of tasks that await completion. If tasks always take longer than the rate at which you
schedule them you will get a constantly growing task queue and probably a memory related crash at some point.
 */
public class SingleThreadScheduledExecutor {
    public static final void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors
                .newSingleThreadScheduledExecutor();
        HeartbeatTask heartbeatTask = new HeartbeatTask();
        heartbeatTask.addService(new Service("JmsConsumer"));
        heartbeatTask.addService(new Service("DatabaseUpdateService"));
        try {
            scheduledExecutorService.scheduleAtFixedRate(heartbeatTask, 0, 1,
                    TimeUnit.SECONDS);
            Thread.sleep(8000);
        } finally {
            System.out.println("Shutdown scheduledExecutorService");
            heartbeatTask.shutdown();
            scheduledExecutorService.shutdownNow();
        }
    }
}
