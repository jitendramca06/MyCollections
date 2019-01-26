package com.questions.java.thread.threadssourcecodes.synchronizedqueue;

/**
 * @author Jitendra Kumar : 8/1/19
 */
public class Consumer implements Runnable{
    private Data data;

    public Consumer(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        data.consume();
    }
}
