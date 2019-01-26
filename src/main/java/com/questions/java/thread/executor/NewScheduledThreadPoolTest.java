package com.questions.java.thread.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
newScheduledThreadPool() returns ScheduledExecutorService. newScheduledThreadPool()
creates the pool of threads. We need to pass the number of threads. ScheduledExecutorService
schedules the threads for a given time of delay. Threads run for the given interval of time.
We use the newScheduledThreadPool() as
final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
 ScheduledExecutorService has the method scheduleWithFixedDelay(). That runs threads periodically
 with delay of given time. We use it as
schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);
 The threads will start after 2 seconds and when threads complete its task, it again starts to
 run after 3 second and it continues after every 3 seconds. Find the complete stack.
 */
public class NewScheduledThreadPoolTest {
    public static void main(final String... args) throws InterruptedException, ExecutionException {
        // creates thread pool with 2 thread
        final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(2);
        // Object creation of runnable thread.
        final Runnable ob = new NewScheduledThreadPoolTest().new DemoThread();
        // Thread scheduling
        schExService.scheduleWithFixedDelay(ob, 2, 3, TimeUnit.SECONDS);
        // waits for termination for 30 seconds only
        schExService.awaitTermination(10, TimeUnit.SECONDS);
        // shutdown now.
        schExService.shutdownNow();
        System.out.println("Shutdown Complete");
    }
    // Runnable thread
    class DemoThread implements Runnable {
        @Override
        public void run() {
            int cnt = 0;
            for (; cnt < 2; cnt++) {
                System.out.println("runnable thread:" + cnt);
            }
            System.out.println("Done");
        }
    }
}
