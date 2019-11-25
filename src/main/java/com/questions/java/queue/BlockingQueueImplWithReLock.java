package com.questions.java.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jitendra Kumar : 30/4/19
 */
public class BlockingQueueImplWithReLock<T>{
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private int size;
    private Queue<T> list;

    public BlockingQueueImplWithReLock(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }

    public void put(T t) {
        try {
            lock.lock();
            while (list.size() == size) {
                notFull.wait();
            }
            list.offer(t);
            notEmpty.signalAll();
            System.out.println(Thread.currentThread().getName() + "->" + t);
        }catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void take() {
        T t = null;
        try {
            lock.lock();
            while (list.isEmpty()) {
                notEmpty.wait();
            }
            t = list.poll();
            notFull.signalAll();
            System.out.println(Thread.currentThread().getName() + "->" + t);
        }catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
