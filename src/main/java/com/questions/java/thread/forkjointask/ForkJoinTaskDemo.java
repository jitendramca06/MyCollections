package com.questions.java.thread.forkjointask;

/**
 * Created by jitendra on 07 Mar, 2018
 *
 *
 * http://tutorials.jenkov.com/java-util-concurrent/java-fork-and-join-forkjoinpool.html
 *
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinTaskDemo {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();
        DemoTask task = new DemoTask();
        ForkJoinTask<String>  fjt = ForkJoinTask.adapt(task);
        fjp.invoke(fjt);
        System.out.println(fjt.isDone());
    }
}

class DemoTask implements Callable<String>{
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println( "Task Done");
        return "Task Done";
    }
}
