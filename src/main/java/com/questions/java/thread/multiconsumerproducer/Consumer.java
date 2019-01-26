package com.questions.java.thread.multiconsumerproducer;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class Consumer implements Runnable{
    MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }
    @Override
    public void run() {
        try {
            while (true) {
                messageQueue.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
