package com.questions.java.thread.executor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jitendra on 15 Mar, 2018
 */
public class CompletionServiceExample implements Callable<String> {

    final String name;
    final long period;

    CompletionServiceExample(final String name, final long period) {
        this.name = name;
        this.period = period;
    }

    public String call() {
        try {
            Thread.sleep(period);
        } catch (InterruptedException ex) {
        }
        return name;
    }

    public static void executorService() {
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        final List<? extends Callable<String>> callables = Arrays.asList(
                new CompletionServiceExample("quick", 500),
                new CompletionServiceExample("slow", 5000));
        try {
            for (final Future<String> future : pool.invokeAll(callables)) {
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException ex) { }
        pool.shutdown();
    }

    public static void completionExecutorServic() {
        final ExecutorService pool = Executors.newFixedThreadPool(2);
        final CompletionService<String> service = new ExecutorCompletionService<String>(pool);
        final List<? extends Callable<String>> callables = Arrays.asList(
                new CompletionServiceExample("slow", 5000),
                new CompletionServiceExample("quick", 500));
        for (final Callable<String> callable : callables) {
            service.submit(callable);
        }
        pool.shutdown();
        try {
            while (!pool.isTerminated()) {
                final Future<String> future = service.take();
                System.out.println(future.get());
            }
        } catch (ExecutionException | InterruptedException ex) { }
    }

    public static void main(String[] args) {
        executorService();
        System.out.println();
        completionExecutorServic();
    }
}
