package com.questions.java.thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        Future<Integer> a = executorService.submit(new CallableThread(1,2));
        Future<Integer> b = executorService.submit(new CallableThread(3,4));
        Future<Integer> c = executorService.submit(new CallableThread(5,6));
        Future<Integer> d = executorService.submit(new CallableThread(7,8));
        Future<Integer> e = executorService.submit(new CallableThread(9,10));
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        int sum = 0;
        for (Future<Integer> s : list) {
            try {
                sum = sum + s.get();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        }
        executorService.shutdown();
        System.out.println(sum);
    }
}
