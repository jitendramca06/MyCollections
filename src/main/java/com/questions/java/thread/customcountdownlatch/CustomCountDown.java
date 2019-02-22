package com.questions.java.thread.customcountdownlatch;

public class CustomCountDown {
    private int count;

    public CustomCountDown(int count) {
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0)
            this.wait();
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) {
            this.notifyAll();
        }
    }
}
