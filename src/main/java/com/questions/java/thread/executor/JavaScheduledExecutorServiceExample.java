package com.questions.java.thread.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by jitendra on 08 Mar, 2018
 */

/*
ScheduledExecutorService is java.util.concurrent.ExecutorService thus it inherits all the functional
abstractions from ExecutorService interface (and its super interfaces!); nevertheless, the difference being,
ScheduledExecutorService can “schedule commands to run after a given delay, or to execute periodically” (Source).
The public API to use ScheduledExecutorService is pretty straightforward. We can “schedule” a repetitive
or delayed task encapsulated in a java.lang.Runnable or java.util.concurrent.Callable instance with
ScheduledExecutorService configuring the delays. It is obvious that a Runnable task would be non result
 bearing one and Callable would produce some result.
An instance of ScheduledThreadPoolExecutor can be retrieved from the convenient factory API,
java.util.concurrent.Executors.newScheduledThreadPool(int corePoolSize) or its overloaded version
Executors.newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory). In the subsequent
sections, we will demonstrate these APIs through the way of an stack.
3. ScheduledExecutorServicve in Action: Scheduled Database updates
Let us say we need to update the database at the end of each day – at midnight. For instance,
if the updating client was started at any particular time on a day, the client would then calculate
the duration until that day’s midnight (the delay) and schedule the updater code with ScheduledExecutorService
to fire at the end of expiry of this duration, thereafter it would invoke database updater code every 24
hour which would be configured as “fixed delay” with the ScheduledExecutorService. So we have an initial
delay and thereafter fixed regular delays! And all this requirements can be easily configured with
ScheduledExecutorService . In the subsequent passages we would be calculating: (i) The initial delay
and (ii) the fixed delays.
3.1 Initial Delay calculation
Just to re-iterate, we would be calculating the initial duration left until the clock ticks that
days midnight. For the sake demonstration we would be using some deprecated APIs from the java.util.Date
class. Let us define our midnight straightaway.
 */
public class JavaScheduledExecutorServiceExample {
    public static void main(String[] args) {
        ScheduledExecutorService execService
                =   Executors.newScheduledThreadPool(5);
        execService.scheduleAtFixedRate(()->{
            //The repetitive task, say to update Database
            System.out.println("hi there at: "+ new java.util.Date());
        }, 0, 1000L, TimeUnit.MILLISECONDS);
    }
}
