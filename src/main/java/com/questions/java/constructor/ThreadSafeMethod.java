package com.questions.java.constructor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.*;

/**
 * @author Jitendra Kumar : 3/2/19
 */
public class ThreadSafeMethod {
    private Lock lock = new ReentrantLock();
    ConcurrentHashMap<Integer, AtomicBoolean> threadStatus = new ConcurrentHashMap<>();

    public void method1(int i) {
        /**
         * If a thread carry i=10 then it should allow to execute this method, but if an another
         * thread carry i =10 then it should not allow to execute this method. it should wait till the first thread
         * complete the execution
         */
        try {
            AtomicBoolean status = threadStatus.get(i);
            lock.lock();
            if (status == null) status = new AtomicBoolean();
            lock.unlock();
            while (status.getAndSet(true));
            threadStatus.put(i, status);
            System.out.println(Thread.currentThread().getName() + " started executing for i-" + i);
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " completed.");
            status.set(false);
            threadStatus.put(i, status);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
