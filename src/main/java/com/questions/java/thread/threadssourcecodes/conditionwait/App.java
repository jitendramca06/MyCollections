package com.questions.java.thread.threadssourcecodes.conditionwait;

/**
 * @author Jitendra Kumar : 5/1/19
 */
public class App {
    public static void main(String[] args) {
        Data data = new Data();
        Thread t = new Thread(new Producer(data), "Producer");
        Thread t1 = new Thread(new Consumer(data), "Consumer");
        t.start();
        t1.start();
    }
}
