package com.questions.java.methodreferences;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MethodReferenceWithThread {
    public static void threadStatus(){
        System.out.println("Thread is running...");
    }

    public static void method() {
        System.out.println("Added another method.");
    }
    public static void main(String[] args) {
        Thread t2=new Thread(MethodReferenceWithThread::threadStatus);
        t2.start();
    }
}
