package com.questions.java.thread.threadssourcecodes.memoryinconsistency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Jitendra Kumar : 28/9/18
 */
public class ReadWriteLockExample {
    private static ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int count;

    private static void write() {
        try {
            Thread.sleep(1);
            lock.writeLock().lock();
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    private static void read() {
        try {
            Thread.sleep(10);
            lock.readLock().lock();
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for (int  i = 0 ; i < 10 ; i++) {
            Runnable thread = () -> {
                read();
            };
            service.execute(thread);
        }

        for (int  i = 0 ; i < 10 ; i++) {
            Runnable thread = () -> {
                write();
            };
            service.execute(thread);
        }

        service.shutdown();
    }
}
