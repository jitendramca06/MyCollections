package com.questions.java.thread.producerconsumerbq;

/**
 * Created by jitendra on 09 Mar, 2018
 */
public class Message {
    private String msg;

    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }
}
