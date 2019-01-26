package com.questions.java.thread.cyclicbarrier;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jitendra on 08 Mar, 2018
 */
/*
Java.util.Concurrent.CyclicBarrier is a synchronisation aid that allows a set of threads to wait for
 each other to reach a common barrier point. This means that all the threads reaching a specific
 point (called as barrier point) will have to wait for other threads to reach the same point.
 As soon as all the threads have reached the barrier point, all threads to are released to continue.
The barrier is called cyclic because it can be re-used after the waiting threads are released
and that is where it is different than CountdownLatch. We can reuse CyclicBarrier by calling reset()
 method which resets the barrier to its initial state.
CountDownLatch is good for one time event like application/module start-up time and CyclicBarrier
can be used to in case of recurrent event e.g. concurrently (re-)calculating each time when the input data changed.
Let’s try to understand CyclicBarrier by an stack.
Suppose we have two services which should wait for each other to complete the execution. Moreover
the service calling them should also wait for their competition. So in our stack the 2 services
and the main thread calling them will wait for each other to finish their execution.

Difference between CountDownLatch and CyclicBarrier in Java
In our last article, we have to see how CountDownLatch can be used to implement multiple threads waiting
for each other. If you look at CyclicBarrier it also the does the same thing but there is different you can
not reuse CountDownLatch once the count reaches zero while you can reuse CyclicBarrier by calling reset() method
which resets Barrier to its initial State. What it implies that CountDownLatch is a good for one-time events like
application start-up time and CyclicBarrier can be used to in case of the recurrent event e.g. concurrently calculating a solution of the big problem etc.

 */
public class JavaCyclicBarrierExample {
    public static void main(String[] args) {

        //3 threads are part of the barrier, ServiceOne, ServiceTwo and this main thread calling them.
        final CyclicBarrier barrier = new CyclicBarrier(3);

        Thread serviceOneThread = new Thread(new ServiceOne(barrier));
        Thread serviceTwoThread = new Thread(new ServiceTwo(barrier));

        System.out.println("Starting both the services at"+new Date());

        serviceOneThread.start();
        serviceTwoThread.start();

        try {
            barrier.await();
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println("Main Thread interrupted!");
            e.printStackTrace();
        }
        System.out.println("Ending both the services at"+new Date());
    }
}
