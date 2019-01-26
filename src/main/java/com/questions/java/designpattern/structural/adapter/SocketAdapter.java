package com.questions.java.designpattern.structural.adapter;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public interface SocketAdapter {
    public Volt get120Volt();

    public Volt get12Volt();

    public Volt get3Volt();
}
