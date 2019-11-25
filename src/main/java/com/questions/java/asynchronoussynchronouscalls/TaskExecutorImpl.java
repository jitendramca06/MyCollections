package com.questions.java.asynchronoussynchronouscalls;

/**
 * @author Jitendra Kumar : 2/5/19
 */
public class TaskExecutorImpl implements TaskExecutor {
    @Override
    public void executeTask(String task) {
        System.out.println("Executing the task-" + task);
    }
}
