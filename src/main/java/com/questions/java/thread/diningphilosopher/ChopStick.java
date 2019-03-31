package com.questions.java.thread.diningphilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jitendra Kumar : 30/3/19
 */
public class ChopStick {
    private Lock lock;
    private int id;

    ChopStick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickChopStick(Philosopher philosopher, State state) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println("Philosopher-" + philosopher.getId() + " picked the chopstick-" + id + " as " + state.name());
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        lock.unlock();
        System.out.println("Philosopher-" + philosopher.getId() + " put down the chopstick-" + id + " as " + state.name());
    }
}
