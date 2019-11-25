package com.questions.java.queue;

import java.util.concurrent.TimeUnit;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enQueue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);

        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());
        System.out.println(myQueue.deQueue());

        MyQueue<String> queue = new MyQueue<>();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

        BlockingQueueImplWithReLock<String> queueImplWithReLock = new BlockingQueueImplWithReLock<>(1);
        new Thread(()-> {
            while (true) {
                queueImplWithReLock.put("Hello");
                try {
                    TimeUnit.MILLISECONDS.sleep(11);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();
        new Thread(()-> {
            while (true) {
                queueImplWithReLock.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}
