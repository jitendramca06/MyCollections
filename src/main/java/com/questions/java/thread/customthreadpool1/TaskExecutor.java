package com.questions.java.thread.customthreadpool1;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Jitendra Kumar : 23/4/19
 */
public class TaskExecutor implements Runnable {
    private ConcurrentLinkedQueue<Task> taskList;
    private AtomicBoolean shouldExecute;

    public TaskExecutor(ConcurrentLinkedQueue<Task> taskList, AtomicBoolean shouldExecute) {
        this.taskList = taskList;
        this.shouldExecute = shouldExecute;
    }

    @Override
    public void run() {
        while (shouldExecute.get() || !taskList.isEmpty()) {
            Task task = null;
            while ((task = taskList.poll()) != null) {
                System.out.println(Thread.currentThread().getName() + " taken task-" + task.getTask() + " for execution.");
                task.run();
                System.out.println(Thread.currentThread().getName() + " completed task-" + task.getTask());
            }
        }
    }
}
