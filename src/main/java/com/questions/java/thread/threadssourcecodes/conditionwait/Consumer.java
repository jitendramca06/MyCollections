package com.questions.java.thread.threadssourcecodes.conditionwait;

/**
 * @author Jitendra Kumar : 5/1/19
 */
public class Consumer implements Runnable{
    Data data;

    Consumer(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "=" + data.consumer());
        }
    }
}
