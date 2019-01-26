package com.questions.java.thread.threadssourcecodes.printinsequence;

/**
 * @author Jitendra Kumar : 22/9/18
 */
public class Task implements Runnable{
    private int threadId;
    private Data data;

    public Task(int threadId, Data data) {
        this.threadId = threadId;
        this.data = data;
    }

    @Override
    public void run() {
        data.print(threadId, Thread.currentThread().getName());
    }
}
