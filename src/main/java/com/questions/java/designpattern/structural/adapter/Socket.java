package com.questions.java.designpattern.structural.adapter;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class Socket {
    public Volt getVolt(){
        return new Volt(120);
    }
}
