package com.questions.java.thread.threadssourcecodes.memoryinconsistency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Jitendra Kumar : 28/9/18
 */
public class VolatileVariable {
    //This will give inconsistance result
    private static volatile int count = 0;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0 ; i < 100 ; i++) {
            Runnable thread = () -> {
                System.out.println(Thread.currentThread().getName() + " - " + count);
                count++;
            };
            service.execute(thread);
        }
        service.shutdown();
    }
}
