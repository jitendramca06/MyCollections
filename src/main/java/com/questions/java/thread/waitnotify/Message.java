package com.questions.java.thread.waitnotify;

/**
 * Created by jitendra on 09 Mar, 2018
 */

/*
wait

Object wait methods has three variance, one which waits indefinitely for any other thread to
call notify or notifyAll method on the object to wake up the current thread. Other two variances
puts the current thread in wait for specific amount of time before they wake up.

notify

notify method wakes up only one thread waiting on the object and that thread starts execution.
So if there are multiple threads waiting for an object, this method will wake up only one of them.
The choice of the thread to wake depends on the OS implementation of thread management.

notifyAll

notifyAll method wakes up all the threads waiting on the object, although which one will process
first depends on the OS implementation.
 */
public class Message {
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String str) {
        this.msg=str;
    }
}
