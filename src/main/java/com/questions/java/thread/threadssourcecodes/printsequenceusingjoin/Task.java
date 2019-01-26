package com.questions.java.thread.threadssourcecodes.printsequenceusingjoin;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class Task implements Runnable{
    private Data data;

    public Task(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.print(Thread.currentThread().getName());
    }
}
