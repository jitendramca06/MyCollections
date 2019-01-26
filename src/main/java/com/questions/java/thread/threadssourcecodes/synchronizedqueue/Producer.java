package com.questions.java.thread.threadssourcecodes.synchronizedqueue;

/**
 * @author Jitendra Kumar : 8/1/19
 */
public class Producer implements Runnable{
    Data data;

    public Producer(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        data.produce();
    }
}
