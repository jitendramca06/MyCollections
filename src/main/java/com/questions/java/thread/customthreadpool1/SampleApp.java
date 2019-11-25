package com.questions.java.thread.customthreadpool1;

import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = MyExecutorService.getFixedSizeThreadPool(3);
        for (int i = 0 ; i < 10 ; i++) {
            Task task = new Task("" + (i+1), 100);
            myExecutorService.execute(task);
        }

        Task task = new Task("" + 12,1000);
        myExecutorService.execute(task);

        myExecutorService.stop();
        myExecutorService.awaitTermination(200);
    }
}
