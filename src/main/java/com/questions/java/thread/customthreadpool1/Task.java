package com.questions.java.thread.customthreadpool1;

import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class Task implements Runnable{
    private String task;

    public Task(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task-" + task + " started executing.......");
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Task-" + task + " is interrupted.......");
        }
    }

    public String getTask() {
        return task;
    }
}
