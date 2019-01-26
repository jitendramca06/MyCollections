package com.questions.java.thread.threadssourcecodes.consumerperproducer;

/**
 * @author Jitendra Kumar : 23/9/18
 */
public class ProducerTask implements Runnable{
    private Data data;
    private int threadId;

    public ProducerTask(Data data, int threadId) {
        this.data = data;
        this.threadId = threadId;
    }
    @Override
    public void run() {
        data.produce(Thread.currentThread().getName(), threadId);
    }
}
