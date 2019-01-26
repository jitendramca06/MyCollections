package com.questions.java.thread.customcyclicbarrier;

public class CustomCyclicBarrier {
    private int initParties;
    private int parties;
    private Barrier barrier;

    public CustomCyclicBarrier(int initParties, int parties, Barrier barrier) {
        this.initParties = initParties;
        this.parties = parties;
        this.barrier = barrier;
    }

    public synchronized void await() throws InterruptedException {
        if (parties > 0) {
            parties--;
            this.wait();
        }
        else {
            parties = initParties;
            this.notifyAll();
            new Thread(barrier).start();
        }
    }
}
