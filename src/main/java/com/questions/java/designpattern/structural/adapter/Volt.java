package com.questions.java.designpattern.structural.adapter;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
In the Adapter Design Pattern, a class converts the interface of one class to be what another class expects.


One of the great real life stack of Adapter design pattern is mobile charger.
Mobile battery needs 3 volts to charge but the normal socket produces either
 120V (US) or 240V (India). So the mobile charger works as an adapter between mobile
 charging socket and the wall socket.
 */
public class Volt {
    private int volts;

    public Volt(int v){
        this.volts=v;
    }

    public int getVolts() {
        return volts;
    }

    public void setVolts(int volts) {
        this.volts = volts;
    }
}
