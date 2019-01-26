package com.questions.java.queue;

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
    }
}
