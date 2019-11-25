package com.questions.java.asynchronoussynchronouscalls;

import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 2/5/19
 */
public class ASynchronousCallbacks {
    private TaskExecutor taskExecutor;

    public void register(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void executeTask() {
        System.out.println("Started executing the task------");
        new Thread(() -> {
            if (taskExecutor != null) taskExecutor.executeTask("Task-1");
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        ASynchronousCallbacks a = new ASynchronousCallbacks();
        TaskExecutor taskExecutor = new TaskExecutorImpl();
        a.register(taskExecutor);
        a.executeTask();
    }
}
