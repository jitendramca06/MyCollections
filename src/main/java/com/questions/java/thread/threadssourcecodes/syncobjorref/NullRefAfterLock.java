package com.questions.java.thread.threadssourcecodes.syncobjorref;

/**
 * @author Jitendra Kumar : 25/9/18
 */
public class NullRefAfterLock {
    private Object lock = new Object();

    public static void main(String[] args) {
        NullRefAfterLock nullRefAfterLock = new NullRefAfterLock();
        System.out.println(nullRefAfterLock.checkRunTime());
        new Thread(() -> {
            nullRefAfterLock.lockCheck();
        }).start();
    }

    private void lockCheck() {
        synchronized (lock) {
            System.out.println("Before null");
            lock = null;
            System.out.println("After null");
        }
    }

    private int checkRunTime() {
        try {
            throw new RuntimeException("Run time exception");
        } finally {
            return 10;
        }
    }
}
