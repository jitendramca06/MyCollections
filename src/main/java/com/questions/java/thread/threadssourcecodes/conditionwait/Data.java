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
    private Condition added = lock.newCondition();
    private Condition removed = lock.newCondition();
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
                added.await();
            }

            String s = get();
            removed.signal();
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
                removed.await();
            add(s);
            added.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
