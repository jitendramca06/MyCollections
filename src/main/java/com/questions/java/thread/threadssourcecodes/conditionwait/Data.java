package com.questions.java.thread.threadssourcecodes.conditionwait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jitendra Kumar : 5/1/19
 */
public class Data {
    private Lock lock = new ReentrantLock();
    private Condition forProducer = lock.newCondition();
    private Condition forConsumer = lock.newCondition();
    private List<String> list = new ArrayList<>();
    private final int MAX_COUNT = 10;

    public String get() {
        return list.remove(0);
    }

    public void add(String s) {
        list.add(s);
    }

    public String consumer() {
        try{
            lock.lock();
            while (list.size() == 0){
                /**
                 * For for producer to produce data
                 */
                forProducer.await();
            }

            String s = get();
            /**
             * Data has been consumed, Give notification to producer
             */
            forConsumer.signal();
            return s;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public void produce(String s) {
        try {
            lock.lock();
            while (list.size() == MAX_COUNT)
            /**
             * Wait for consumer to consume data
             */
                forConsumer.await();
            add(s);
            /**
             * Data has been produces, give notification to consumer
             */
            forProducer.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
