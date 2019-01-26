package com.questions.java.thread.threadssourcecodes.conditionwait.otherexample;

/**
 * @author Jitendra Kumar : 24/1/19
 */
public class Consumer implements Runnable {
    private Message message;

    public Consumer(Message msg) {
        message = msg;
    }

    @Override
    public void run() {
        while (!message.isEndIt())
            message.viewMessage();
    }
}
