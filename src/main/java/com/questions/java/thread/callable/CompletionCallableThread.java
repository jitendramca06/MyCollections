package com.questions.java.thread.callable;

import java.util.concurrent.Callable;

/**
 * @author Jitendra Kumar : 24/11/19
 */
public class CompletionCallableThread implements Callable<Data> {
    private String thread;
    private long time;

    CompletionCallableThread(String thread, long time) {
        this.thread = thread;
        this.time = time;
    }
    @Override
    public Data call() throws Exception {
        Thread.sleep(time);
        Data data = new Data();
        data.setA();
        data.setB();
        data.setC();
        data.setD();
        data.setAll(thread);
        System.out.println("====================================" + thread + " sleep time " + time +"====================================");
        System.out.println(data.toString());
        System.out.println("====================================End====================================");
        return data;
    }
}
