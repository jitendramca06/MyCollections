package com.questions.java.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author Jitendra Kumar : 24/11/19
 */
public class CompletionApp {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<Data> completionService = new ExecutorCompletionService<Data>(executorService);

        List<Future> futList= new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++) {
            CompletionCallableThread completionCallableThread = new CompletionCallableThread("Thread-" + i, random.nextInt(2000) + 1);
            futList.add(completionService.submit(completionCallableThread));
        }

        Data prevous = null;
        for (Future future : futList) {
            Data data = completionService.take().get();
            if (prevous == null) prevous = data;
            else prevous = prevous.add(data);
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(prevous);
    }
}
