package com.questions.java.asynchronoussynchronouscalls;

/**
 * @author Jitendra Kumar : 2/5/19
 */
public class SynchronousCallbacks {
    private TaskExecutor taskExecutor;

    public void register(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void myTask() {
        System.out.println("Started executing the task------");
        if (taskExecutor != null) taskExecutor.executeTask("Task-1");
    }

    public static void main(String[] args) {
        SynchronousCallbacks synchronousCallbacks = new SynchronousCallbacks();
        TaskExecutor taskExecutor = new TaskExecutorImpl();
        synchronousCallbacks.register(taskExecutor);
        synchronousCallbacks.myTask();
    }
}
