package com.questions.java.thread.multiconsumerproducer;

import java.util.List;

/**
 * @author Jitendra Kumar : 6/9/18
 */
public class MessageQueue {
    List<Integer> queue;
    int taskCount;
    int totalTaskForEachProducer;

    MessageQueue(List<Integer> queue, int taskCount, int totalTaskForEachProducer) {
        this.queue = queue;
        this.taskCount = taskCount;
        this.totalTaskForEachProducer = totalTaskForEachProducer;
    }

    void produce(int i, int producerCount) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == taskCount) {
                System.out.println("Queue is full, " + Thread.currentThread().getName() + " is waiting to get space in queue.");
                queue.wait();
            }
            int item = producerCount* totalTaskForEachProducer + i;
            queue.add(item);
            System.out.println(Thread.currentThread().getName() + " is produced data - " + item);
            Thread.sleep(1000);
            queue.notify();
        }
    }

    void consume() throws InterruptedException {
        synchronized (queue) {
            while (queue.size() == 0) {
                System.out.println(Thread.currentThread().getName() + " is waiting because not data is available in queue.");
                queue.wait();
            }
            System.out.println(Thread.currentThread().getName() + " is consumed data - " + queue.remove(0));
            Thread.sleep(1000);
            queue.notify();
        }
    }
}
