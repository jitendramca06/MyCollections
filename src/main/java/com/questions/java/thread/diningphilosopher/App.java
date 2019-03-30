package com.questions.java.thread.diningphilosopher;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 30/3/19
 *
 * Philosphor-0 have Chopstick -0 as Left and Chopstick -4 as Right
 * Philosphor-1 have Chopstick -1 as Left and Chopstick -0 as Right
 * Philosphor-2 have Chopstick -2 as Left and Chopstick -1 as Right
 * Philosphor-3 have Chopstick -3 as Left and Chopstick -2 as Right
 * Philosphor-4 have Chopstick -4 as Left and Chopstick -3 as Right
 *
 * Philosphor-0 can start eating when he have both Chopstick -0 as Left and Chopstick -4 as Right are available
 * Philosphor-1 can start eating when he have both Chopstick -1 as Left and Chopstick -0 as Right are available
 * ... and so on
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[5];
        ChopStick[]chopSticks = new ChopStick[5];
        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0 ; i < chopSticks.length ; i++) {
            chopSticks[i] = new ChopStick(i);
        }

        philosophers[0] = new Philosopher(0, chopSticks[0], chopSticks[4]);
        service.execute(philosophers[0]);

        for (int i = 1 ; i < philosophers.length ; i++) {
            philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i -1) % 5]);
            service.execute(philosophers[i]);
        }

        Thread.sleep(10*1000);

        for (Philosopher philosopher : philosophers) {
            philosopher.setFull(true);
        }

        service.shutdown();

        if (!service.isTerminated()) {
            service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        }

        for (Philosopher philosopher : philosophers) {
            System.out.println("Philosopher-" + philosopher.getId() + " eats-" + philosopher.getCount() + " times");
        }
    }
}
