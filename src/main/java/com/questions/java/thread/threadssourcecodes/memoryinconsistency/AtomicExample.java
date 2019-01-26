package com.questions.java.thread.threadssourcecodes.memoryinconsistency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jitendra Kumar : 28/9/18
 */
public class AtomicExample {
    private static AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 50 ; i++) {
            Runnable thread = () -> {
                System.out.println(count.getAndIncrement());
            };
            service.execute(thread);
        }
        service.shutdown();
    }
}
