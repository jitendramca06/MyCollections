package com.questions.java.thread.threadssourcecodes.oddeven;

/**
 * @author Jitendra Kumar : 22/9/18
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
        data.print(threadId, Thread.currentThread().getName());
    }
}
