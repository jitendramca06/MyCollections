package com.questions.java.thread.customesemaphore;

public class CustomSemaphore {
    private int count;

    public CustomSemaphore(int count) {
        this.count = count;
    }

    public synchronized void aquire() throws InterruptedException {
        if (count == 0) {
            this.wait();
        }
        count--;
    }

    public synchronized void release() {
        count++;
        if (count > 0)
            this.notify();
    }

    public int availablePermits() {
        return count;
    }
}
