package com.questions.java.thread.threadssourcecodes.consumerperproducer;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class ConsumerTask implements Runnable{
    private Data data;
    private int threadId;

    ConsumerTask(Data data, int threadId) {
        this.data = data;
        this.threadId = threadId;
    }
    @Override
    public void run() {
        data.consume(Thread.currentThread().getName(),threadId);
    }
}
