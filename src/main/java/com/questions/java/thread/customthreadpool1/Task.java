package com.questions.java.thread.customthreadpool1;

import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class Task implements Runnable{
    private String task;
    private long sleepTime;

    public Task(String task, long sleepTime) {
        this.task = task;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task-" + task + " started executing.......");
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("Task-" + task + " is interrupted.......");
        }
    }

    public String getTask() {
        return task;
    }
}
