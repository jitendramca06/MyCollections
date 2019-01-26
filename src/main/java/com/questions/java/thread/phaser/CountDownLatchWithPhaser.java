package com.questions.java.thread.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @author Jitendra Kumar : 22/1/19
 */
public class CountDownLatchWithPhaser {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(1);

        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));
        executorService.shutdown();

        phaser.awaitAdvance(1); // similar to await

        System.out.println("Main---------");
    }

    public static class DependentService implements Runnable{

        Phaser phaser;
        public DependentService(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arrive();//Similar to count down latch
            System.out.println(Thread.currentThread().getName() + " is arrived...");
        }
    }
}
