package com.questions.java.thread.customthreadpool1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class MyExecutorService {
    private int poolCount;
    private ConcurrentLinkedQueue<Task> taskList;
    private List<Thread> threads;
    private AtomicBoolean shouldExecute;

    public MyExecutorService(int poolCount) {
        this.poolCount = poolCount;
        this.shouldExecute = new AtomicBoolean(true);
        this.taskList = new ConcurrentLinkedQueue<>();
        this.threads = new ArrayList<>();
        for (int i = 0 ; i < poolCount ; i++) {
            TaskExecutor taskExecutor = new TaskExecutor(taskList, shouldExecute);
            Thread thread = new Thread(taskExecutor, "TaskExecutor-" + (i+1));
            thread.start();
        }
    }

    public static MyExecutorService getFixedSizeThreadPool(int threadCount) {
        return new MyExecutorService(threadCount);
    }

    public void execute(Task task) {
        if (this.shouldExecute.get()) {
            taskList.add(task);
        }else {
            throw new IllegalStateException("Thread pool is terminated. Unable to accept new task");
        }
    }

    public void stop() {
        shouldExecute.set(false);
    }

    public void terminate() {
        taskList.clear();;
        stop();
    }

    public void awaitTermination() {
        if (shouldExecute.get()) {
            throw new IllegalStateException("Unable to terminate the thread pool.");
        }

        while (true) {
            try {
                boolean isAlive = true;
                for (Thread thread : threads) {
                    if (thread.isAlive()) {
                        isAlive = false;
                    }
                }
                if (isAlive) return;
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException("awaitTermination is interrupted");
            }
        }
    }

    public void awaitTermination(long waitTime) {
        if (shouldExecute.get()) {
            throw new IllegalStateException("Unable to terminate the thread pool.");
        }
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime <= waitTime) {
            try {
                boolean isAlive = true;
                for (Thread thread : threads) {
                    if (thread.isAlive()) {
                        isAlive = false;
                    }
                }
                if (isAlive) return;
                TimeUnit.MILLISECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new IllegalStateException("awaitTermination is interrupted");
            }
        }
    }
}
