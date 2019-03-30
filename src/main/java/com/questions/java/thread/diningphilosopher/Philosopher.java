package com.questions.java.thread.diningphilosopher;

import java.util.Random;

/**
 * @author Jitendra Kumar : 30/3/19
 */
public class Philosopher implements Runnable{
    private int id;
    private Random random;
    private ChopStick leftCopStick;
    private ChopStick rightChopStick;
    private volatile boolean isFull;
    private int count = 0;

    Philosopher(int id, ChopStick leftCopStick, ChopStick rightChopStick) {
        this.id = id;
        this.leftCopStick = leftCopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!isFull) {
            try {
                /**
                 * Try to acquire left chopstick first
                 */
                if (leftCopStick.pickChopStick(this, State.LEFT)) {
                    /**
                     * If left chopstick is acquired then try to acquire right chopstick also
                     */
                    if (rightChopStick.pickChopStick(this, State.RIGHT)) {
                        /**
                         * Start eating when both Left and Right chopsticks are available
                         */
                        eat();
                        /**
                         * After eating put down the right chopstick first
                         */
                        rightChopStick.putDown(this, State.RIGHT);
                    }
                    /**
                     * After eating put down the Left chopstick
                     */
                    leftCopStick.putDown(this, State.LEFT);
                }
                waitToAcquireSticks();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher-" + id + " is eating...");
        Thread.sleep(random.nextInt(1000));
        count++;
    }

    public void waitToAcquireSticks() throws InterruptedException {
        System.out.println("Philosopher-" + id + " is waiting...");
        Thread.sleep(random.nextInt(1000));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getCount() {
        return count;
    }
}
