package com.questions.java.thread.multiconsumerproducer;


/**
 * @author Jitendra Kumar : 6/9/18
 */
public class Producer implements Runnable{
    MessageQueue messageQueue;
    int producerCount;

    public Producer(MessageQueue messageQueue, int producerCount) {
        this.messageQueue = messageQueue;
        this.producerCount = producerCount;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < messageQueue.totalTaskForEachProducer ; i++) {
            try {
                messageQueue.produce(i, producerCount);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
