package com.questions.java.thread.customcyclicbarrier;

public class Barrier implements Runnable{
    @Override
    public void run() {
        System.out.println("All thread are reached at barrier.");
    }
}
