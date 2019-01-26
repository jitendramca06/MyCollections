package com.questions.java.thread.threadssourcecodes.printingroup;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class Task implements Runnable{
    private Data data;
    private int threadId;

    public Task(Data data, int threadId) {
        this.data = data;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        data.print(Thread.currentThread().getName(), threadId);
    }
}
