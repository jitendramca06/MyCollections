package com.questions.java.thread.customthreadpool1;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class SampleApp {
    public static void main(String[] args) {
        MyExecutorService myExecutorService = MyExecutorService.getFixedSizeThreadPool(3);
        for (int i = 0 ; i < 100 ; i++) {
            Task task = new Task("" + (i+1));
            myExecutorService.execute(task);
        }

        myExecutorService.stop();
        myExecutorService.awaitTermination();
    }
}
