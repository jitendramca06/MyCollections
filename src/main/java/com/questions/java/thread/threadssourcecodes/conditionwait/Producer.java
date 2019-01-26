package com.questions.java.thread.threadssourcecodes.conditionwait;

/**
 * @author Jitendra Kumar : 5/1/19
 */
public class Producer implements Runnable{
    Data data;

    Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(Thread.currentThread().getName() + "=" + i);
            data.produce(i+"");
        }
    }
}
