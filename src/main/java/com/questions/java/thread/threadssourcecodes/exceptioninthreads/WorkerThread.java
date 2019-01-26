package com.questions.java.thread.threadssourcecodes.exceptioninthreads;

/**
 * @author Jitendra Kumar : 25/9/18
 */
public class WorkerThread implements Runnable{
    @Override
    public void run() {
        throw new RuntimeException("RuntimeException");
    }
}
