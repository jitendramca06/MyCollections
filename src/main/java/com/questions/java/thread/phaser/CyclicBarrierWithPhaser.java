package com.questions.java.thread.phaser;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

/**
 * @author Jitendra Kumar : 22/1/19
 */
public class CyclicBarrierWithPhaser {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Phaser phaser = new Phaser(1);

        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));
        executorService.submit(new DependentService(phaser));
        executorService.shutdown();
        Thread.sleep(5000);

        System.out.println("Main---------");
    }

    public static class DependentService implements Runnable{

        Phaser phaser;
        public DependentService(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            phaser.arriveAndAwaitAdvance();//Similar to barrier with await
            System.out.println(Thread.currentThread().getName() + " is arrived...");
        }
    }
}
